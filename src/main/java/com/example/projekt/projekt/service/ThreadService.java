package com.example.projekt.projekt.service;


import com.example.projekt.projekt.models.Thread;
import com.example.projekt.projekt.repository.ThreadRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class ThreadService {

    private ThreadRepo threadRepo;

    public ThreadService(ThreadRepo threadRepo) {
        this.threadRepo = threadRepo;
    }


    public Iterable<Thread> getAllThreads() {
        return threadRepo.findAll();
    }

    public Thread createThread(Thread thread) {
        thread.setCreationDate(new Date());
        return threadRepo.save(thread);
    }
}
