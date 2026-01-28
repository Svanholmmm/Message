package com.example.demo_messagers.service;

import com.example.demo_messagers.model.Message;
import com.example.demo_messagers.repository.MessageRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepository repository;

    public MessageService(MessageRepository repository){
        this.repository = repository;
    }
    public List<Message> getMessages(){
        return repository.getAllMessages();
    }
    public Message findMessageById(int id, boolean caps){
        Message message = repository.findMessageById(id);
        caps = true;
        if(caps){
            return new Message(message.getId(), message.getContent().toUpperCase());
        }
        return message;
    }
}
