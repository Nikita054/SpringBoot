package ru.spring.boot.kotov.nikita.simplelibrary.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_message;
    private String name;
    private String email;
    private Integer id_text;

    public int getIdMessage() {
        return id_message;
    }

    public void setIdMessage(int id_message) {
        this.id_message = id_message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdText() {
        return id_text;
    }

    public void setIdText(Integer id_text) {
        this.id_text = id_text;
    }
}
