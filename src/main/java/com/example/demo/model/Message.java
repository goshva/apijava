
package com.example.demo.model;

public class Message {
    private Long id;
    private String text;
    
    // Конструкторы, геттеры и сеттеры
    public Message() {}
    
    public Message(Long id, String text) {
        this.id = id;
        this.text = text;
    }
    
    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}
