package com.gmail.ribil39;

import com.gmail.ribil39.domain.Message;
import com.gmail.ribil39.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


        @PostMapping
        public String add(@RequestParam String content, Map < String, Object > model){
            Message message = new Message(content);
            messageRepo.save(message);

            Iterable<Message> messages = messageRepo.findAll();
            model.put("messages", messages);

            return "admin";
        }

}

