

package com.example.demo.service;

import com.example.demo.model.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ApiServiceTest {

    private ApiService apiService;

    @BeforeEach
    void setUp() {
        apiService = new ApiService();
    }

    @Test
    void testGetAllMessagesInitiallyEmpty() {
        List<Message> messages = apiService.getAllMessages();
        assertTrue(messages.isEmpty());
    }

    @Test
    void testCreateAndGetMessage() {
        Message created = apiService.createMessage(new Message(null, "Test"));
        assertNotNull(created.getId());
        assertEquals("Test", created.getText());
        
        Message retrieved = apiService.getMessageById(created.getId());
        assertEquals(created, retrieved);
    }

    @Test
    void testUpdateMessage() {
        Message created = apiService.createMessage(new Message(null, "Original"));
        Message updated = apiService.updateMessage(created.getId(), new Message(null, "Updated"));
        
        assertEquals(created.getId(), updated.getId());
        assertEquals("Updated", updated.getText());
        
        Message retrieved = apiService.getMessageById(created.getId());
        assertEquals("Updated", retrieved.getText());
    }

    @Test
    void testDeleteMessage() {
        Message created = apiService.createMessage(new Message(null, "To delete"));
        assertTrue(apiService.deleteMessage(created.getId()));
        assertNull(apiService.getMessageById(created.getId()));
    }
}
