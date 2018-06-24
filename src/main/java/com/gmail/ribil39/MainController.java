package com.gmail.ribil39;

import com.gmail.ribil39.domain.Message;
import com.gmail.ribil39.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String index(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/admin/articles")
    public String articles(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "articles";
    }

    @RequestMapping(value = "/admin/articles/{slug}", method = RequestMethod.GET)
    public String watchSlug(Model model, @PathVariable("slug") String slug) {
        model.addAttribute("currentMessage", messageRepo.findBySlug(slug));

        return "element";
    }


    @GetMapping("/admin/articles/add")
    public String addPage() {
        return "add";
    }

    @PostMapping
    public String add(@RequestParam String content, @RequestParam String title,
                      @RequestParam String slug, Map<String, Object> model) {
        Message message = new Message(content, title, slug);
        messageRepo.save(message);
        return "redirect:/admin/articles";
    }

    @GetMapping("/delete/{slug}")
    public String deleteArticle(@PathVariable("slug") String slug) {
        messageRepo.deleteBySlug(slug);
        return "redirect:/admin/articles";
    }

    @GetMapping("/admin/articles/edit/{id}")
    public String editArticle(@PathVariable("id") Integer id, Model model) {
        Message message = messageRepo.findById(id);
        model.addAttribute("message", message);
        return "edit";
    }

    @PostMapping("editArticle")
    public String edit(@RequestParam Integer id, @RequestParam String content, @RequestParam String title,
                       @RequestParam String slug, @ModelAttribute ("message") Message message) {
        message.setId(id);
        message.setContent(content);
        message.setSlug(slug);
        message.setTitle(title);
        messageRepo.save(message);
        return "redirect:/admin/articles";
    }

}

