
package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.Message;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreateAndGetMessage() {
        // Create message
        Message message = new Message(null, "Integration Test");
        ResponseEntity<Message> createResponse = restTemplate.postForEntity(
            "http://localhost:" + port + "/api/messages",
            message,
            Message.class);
        
        assertEquals(HttpStatus.OK, createResponse.getStatusCode());
        Message created = createResponse.getBody();
        assertNotNull(created);
        assertNotNull(created.getId());
        
        // Get message
        ResponseEntity<Message> getResponse = restTemplate.getForEntity(
            "http://localhost:" + port + "/api/messages/" + created.getId(),
            Message.class);
        
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertEquals(created, getResponse.getBody());
    }
}
