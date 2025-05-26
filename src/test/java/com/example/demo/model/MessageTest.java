

package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @Test
    void testMessageCreation() {
        Message message = new Message(1L, "Test message");
        
        assertEquals(1L, message.getId());
        assertEquals("Test message", message.getText());
        
        // Test setters
        message.setId(2L);
        message.setText("Updated message");
        
        assertEquals(2L, message.getId());
        assertEquals("Updated message", message.getText());
    }

    @Test
    void testEqualsAndHashCode() {
        Message message1 = new Message(1L, "Test");
        Message message2 = new Message(1L, "Test");
        Message message3 = new Message(2L, "Different");
        
        assertEquals(message1, message2);
        assertNotEquals(message1, message3);
        assertEquals(message1.hashCode(), message2.hashCode());
    }
}
