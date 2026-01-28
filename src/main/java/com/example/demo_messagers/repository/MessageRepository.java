package com.example.demo_messagers.repository;
import com.example.demo_messagers.model.Message;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {
    private final List<Message> messages = new ArrayList<>();
    private int messageId = 1;

    public MessageRepository(){
        populateMessages();
    }
    public void populateMessages(){
        while(messageId <= 3){
            messages.add(new Message(messageId, "Velkommen til " + messageId + ".Semester"));
            messageId++;
        }
    }
    public List<Message> getAllMessages(){
        return messages;
    }
    public Message findMessageById(int id){
        for(Message message : messages){
            if(message.getId() == id){
                return message;
            }
        }
        return null;
    }
}
