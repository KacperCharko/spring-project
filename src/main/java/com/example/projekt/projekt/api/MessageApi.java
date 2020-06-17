package com.example.projekt.projekt.api;

import com.example.projekt.projekt.models.Message;
import com.example.projekt.projekt.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/message")
public class MessageApi {

    private MessageService messageService;

    @Autowired
    public MessageApi(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message){
        return messageService.createMsg(message);
    }

}
