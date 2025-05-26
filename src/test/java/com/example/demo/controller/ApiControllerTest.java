
package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.service.ApiService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ApiControllerTest {

    @Mock
    private ApiService apiService;

    @InjectMocks
    private ApiController apiController;

    @Test
    void testGetAllMessages() {
        // Setup mock
        List<Message> mockMessages = Arrays.asList(
            new Message(1L, "First"),
            new Message(2L, "Second")
        );
        when(apiService.getAllMessages()).thenReturn(mockMessages);

        // Test
        List<Message> result = apiController.getAllMessages();
        
        // Verify
        assertEquals(2, result.size());
        verify(apiService, times(1)).getAllMessages();
    }

    @Test
    void testGetMessageByIdFound() {
        Message mockMessage = new Message(1L, "Test");
        when(apiService.getMessageById(1L)).thenReturn(mockMessage);

        ResponseEntity<Message> response = apiController.getMessageById(1L);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockMessage, response.getBody());
    }

    @Test
    void testGetMessageByIdNotFound() {
        when(apiService.getMessageById(1L)).thenReturn(null);

        ResponseEntity<Message> response = apiController.getMessageById(1L);
        
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testCreateMessage() {
        Message input = new Message(null, "New");
        Message saved = new Message(1L, "New");
        when(apiService.createMessage(input)).thenReturn(saved);

        Message result = apiController.createMessage(input);
        
        assertEquals(saved, result);
    }

    @Test
    void testUpdateMessageSuccess() {
        Message input = new Message(null, "Updated");
        Message updated = new Message(1L, "Updated");
        when(apiService.updateMessage(1L, input)).thenReturn(updated);

        ResponseEntity<Message> response = apiController.updateMessage(1L, input);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updated, response.getBody());
    }

    @Test
    void testDeleteMessageSuccess() {
        when(apiService.deleteMessage(1L)).thenReturn(true);

        ResponseEntity<Void> response = apiController.deleteMessage(1L);
        
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testDeleteMessageNotFound() {
        when(apiService.deleteMessage(1L)).thenReturn(false);

        ResponseEntity<Void> response = apiController.deleteMessage(1L);
        
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
