package com.example.projekt.projekt.service;


import com.example.projekt.projekt.models.Thread;
import com.example.projekt.projekt.models.helpers.NewThreadModel;
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

    public Thread getThreadById(Long id){
        return threadRepo.findByThreadId(id);
    }

    public Iterable<Thread> getAllThreads() {
        return threadRepo.findAll();
    }

    public Thread createThread(NewThreadModel newThreadModel) {
        Thread thread = new Thread();
        thread.setAuthorId(1L);
        thread.setCategoryId(newThreadModel.getCategoryId());
        thread.setThreadContent(newThreadModel.getThreadContent());
        thread.setThreadName(newThreadModel.getThreadTopic());
        thread.setCreationDate(new Date());

        return threadRepo.save(thread);
    }
}
