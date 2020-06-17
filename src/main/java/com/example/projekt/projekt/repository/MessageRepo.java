package com.example.projekt.projekt.repository;


import com.example.projekt.projekt.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo  extends CrudRepository<Message, Long> {

    Iterable<Message> findAllByThreadId(Long id);
}
