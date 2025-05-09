package com.example.SQLtest.DTOs;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NoteDTO {

    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Content cannot be blank")
    @Size(min = 10, max = 1000, message = "Content must be between 10 and 1000 characters")
    private String content;

    private String tags;
    public NoteDTO() {
    }
    public NoteDTO(String title, String content, String tags) {
        this.title = title;
        this.content = content;
        this.tags = tags;
    }
    public NoteDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }

}
