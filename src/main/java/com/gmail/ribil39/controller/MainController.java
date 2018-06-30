package com.gmail.ribil39.controller;

import com.gmail.ribil39.domain.Message;
import com.gmail.ribil39.domain.User;
import com.gmail.ribil39.repos.MessageRepo;
import com.gmail.ribil39.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private UserRepo userRepo;

    private String author;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "index";
    }

    @GetMapping("/index")
    public String index(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "index";
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

    @PostMapping("/admin/articles/add")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String content, @RequestParam String title,
                      @RequestParam String slug) {
        Message message = new Message(content, title, slug, user);
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
        author = message.getAuthorName();
        //model.addAttribute("author", author);
        model.addAttribute("message", message);
        return "edit";
    }

    @PostMapping("editArticle")
    public String edit(
            /*@ModelAttribute ("author") String author,*/
                       @ModelAttribute ("message") Message message) {
        User user = userRepo.findByUsername(author);
        message.setAuthor(user);
        messageRepo.save(message);
        return "redirect:/admin/articles";
    }
}
