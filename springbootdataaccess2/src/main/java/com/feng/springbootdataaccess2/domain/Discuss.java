package com.feng.springbootdataaccess2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity(name = "t_comment")
public class Discuss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private String author;
    @Column(name = "a_id")
    private Integer aId;
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Integer getaId() {
        return aId;
    }
    public void setaId(Integer aId) {
        this.aId = aId;
    }
    @Override
    public String toString() {
        return "Discuss{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", aId=" + aId +
                '}';
    }
}