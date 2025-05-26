
package com.example.demo.service;

import com.example.demo.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {
    private final List<Message> messages = new ArrayList<>();
    private Long nextId = 1L;
    
    public List<Message> getAllMessages() {
        return new ArrayList<>(messages);
    }
    
    public Message getMessageById(Long id) {
        return messages.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public Message createMessage(Message message) {
        message.setId(nextId++);
        messages.add(message);
        return message;
    }
    
    public Message updateMessage(Long id, Message message) {
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getId().equals(id)) {
                message.setId(id);
                messages.set(i, message);
                return message;
            }
        }
        return null;
    }
    
    public boolean deleteMessage(Long id) {
        return messages.removeIf(m -> m.getId().equals(id));
    }
}
