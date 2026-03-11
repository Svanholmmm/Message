package com.example.demo_messagers.controller;

import com.example.demo_messagers.model.Message;
import com.example.demo_messagers.repository.MessageRepository;
import com.example.demo_messagers.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("")
public class MessageController {
    private final MessageService service;

    public MessageController(MessageService messageService) {
        this.service = messageService;
    }

    @GetMapping("")
    public ResponseEntity<List<Message>> getMessage() {
        List<Message> messages = service.getMessages();

        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable int id, @RequestParam(defaultValue = "false") boolean caps) {
        Message message = service.findMessageById(id, caps);
        if (message == null) {
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    @PostMapping("/add")
    public ResponseEntity<Message> addMessage(@RequestBody Message message){
        Message savedMessage = service.addMessage(message);
        return new ResponseEntity<Message>(savedMessage, HttpStatus.OK);
    }
}




