package ru.spring.boot.kotov.nikita.simplelibrary.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_text;
    private String text;

    public Integer getIdText() {
        return id_text;
    }

    public void setIdText(int idText) {
        this.id_text = idText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}