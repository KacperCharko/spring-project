package com.example.projekt.projekt.api;

import com.example.projekt.projekt.models.Thread;
import com.example.projekt.projekt.service.ThreadService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/thread")
public class ThreadApi {
    private ThreadService threadService;

    public ThreadApi(ThreadService threadService) {
        this.threadService = threadService;
    }

//    @PostMapping("/create")
//    public Thread createNew(@RequestBody Thread thread){
//        return threadService.createThread(thread);
//    }


}
