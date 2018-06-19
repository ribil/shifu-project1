package com.gmail.ribil39;

import com.gmail.ribil39.domain.Message;
import com.gmail.ribil39.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/index")
    public String greeting(@RequestParam(name = "name", required = false,
            defaultValue = "Гасак Сергей Александрович") String name, Map<String, Object> model) {
        model.put("name", name);
        return "index";
    }

    /*@GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }*/

    @GetMapping("/admin")
    public String admin(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "admin";
    }

   /* @GetMapping("{slug}")
    public String watchSlug(@PathVariable Message message, Map<String, Object> model) {
        model.addAttribute("currentMessage", messageRepo.findBySlug(slug));
        return "element";
    }*/

    @RequestMapping(value = "element/{slug}", method = RequestMethod.GET)
    public String watchSlug(Model model, @PathVariable("slug") String slug) {
        model.addAttribute("currentMessage", messageRepo.findBySlug(slug));

        return "element";
    }


        @PostMapping
        public String add(@RequestParam String content, @RequestParam String title,
                          @RequestParam String slug, Map < String, Object > model){
            Message message = new Message(content, title, slug);
            messageRepo.save(message);

            Iterable<Message> messages = messageRepo.findAll();
            model.put("messages", messages);

            return "admin";
        }

}

