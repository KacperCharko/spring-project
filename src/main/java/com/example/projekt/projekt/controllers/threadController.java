package com.example.projekt.projekt.controllers;

import com.example.projekt.projekt.models.Message;
import com.example.projekt.projekt.models.Thread;
import com.example.projekt.projekt.models.helpers.NewThreadModel;
import com.example.projekt.projekt.models.helpers.ThreadViewModel;
import com.example.projekt.projekt.repository.MessageRepo;
import com.example.projekt.projekt.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/thread")
public class ThreadController {

    private MessageRepo messageRepo;
    private ThreadService threadService;
    private IndexController indexController;


    @Autowired
    public ThreadController(MessageRepo messageRepo, IndexController indexController, ThreadService threadService) {
        this.messageRepo = messageRepo;
        this.indexController = indexController;
        this.threadService = threadService;
    }

    @GetMapping("/show/{threadId}")
    public String showThread(@PathVariable("threadId") Long threadId, Model model) {
        NewThreadModel newThreadModel = new NewThreadModel();
        Iterable<Message> messages = messageRepo.findAllByThreadId(threadId);
        Thread thread = threadService.getThreadById(threadId);

        if(thread !=null) {
            newThreadModel.setCategoryId(thread.getCategoryId());
            newThreadModel.setThreadContent(thread.getThreadContent());
            newThreadModel.setThreadTopic(thread.getThreadName());

            model.addAttribute("msgs", messages);
            model.addAttribute("thread", newThreadModel);
            return "thread/thread";
        }
        else
            return "home/index";
    }

    @GetMapping("new/{categoryId}")
    public String createNewThread(@PathVariable("categoryId") Long categoryId, Model model) {
        NewThreadModel newThreadModel =new NewThreadModel();
        newThreadModel.setCategoryId(categoryId);

        model.addAttribute("model", newThreadModel);
        return"thread/create";
    }

    @RequestMapping("/create")
    public String createNewThread(@ModelAttribute(value = "model") NewThreadModel newThreadModel, Model model) {

        threadService.createThread(newThreadModel);

        return indexController.getAllCategories(model);
    }
}
