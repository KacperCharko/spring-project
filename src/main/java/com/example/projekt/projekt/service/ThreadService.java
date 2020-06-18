package com.example.projekt.projekt.service;


import com.example.projekt.projekt.models.Thread;
import com.example.projekt.projekt.models.helpers.CategoryModel;
import com.example.projekt.projekt.models.helpers.ThreadModel;
import com.example.projekt.projekt.models.helpers.ThreadViewModel;
import com.example.projekt.projekt.repository.ThreadRepo;
import org.springframework.stereotype.Service;

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

    public Thread createThread(ThreadModel threadModel) {
        Thread thread = new Thread();
        if(threadModel.getThreadId()!=null)
            thread.setThreadId(threadModel.getThreadId());
        thread.setAuthorId(1L);
        if(threadModel.getCategoryId()!=null)
        thread.setCategoryId(threadModel.getCategoryId());

        thread.setThreadContent(threadModel.getThreadContent());
        thread.setThreadName(threadModel.getThreadTopic());
        thread.setCreationDate(new Date());

        return threadRepo.save(thread);
    }



    public void deleteThread(Long threadId) {
         threadRepo.deleteById(threadId);
         return;
    }
}
