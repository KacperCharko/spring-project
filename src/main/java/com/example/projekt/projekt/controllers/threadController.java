package com.example.projekt.projekt.controllers;

import com.example.projekt.projekt.models.Message;
import com.example.projekt.projekt.models.helpers.ThreadViewModel;
import com.example.projekt.projekt.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thread")
public class threadController {

    private MessageRepo messageRepo;

    @Autowired
    public threadController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping("/show/{threadId}")
    public String updateSchedulePage(@PathVariable("threadId")Long threadId, Model model) {

        Iterable<Message> messages = messageRepo.findAllByThreadId(threadId);

        model.addAttribute("msgs",messages);
        return "thread/thread";
    }

}
