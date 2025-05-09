package com.example.SQLtest.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity  // Marks this class as a JPA entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate primary key
    @Column(name = "Note_ID")
    private Long id;

    @Column(name = "Title")
    @NotBlank(message = "Title cannot be blank")  // Validation constraint
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @Column(name = "Content")
    @NotBlank(message = "Content cannot be blank")  // Validation constraint
    @Size(min = 10, max = 1000, message = "Content must be between 10 and 1000 characters")
    private String content;

    @Column(name = "Tag")
    private String tags;  // Optional tags for categorization

    @Column(name = "Created_At")
    private LocalDateTime createdAt;  // Timestamp for creation

    @Column(name = "Updated_At")
    private LocalDateTime updatedAt;  // Timestamp for last update

    @OneToMany(mappedBy = "note",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public Note() {
        // Default constructor
    }

    public Note(String title, String content, String tags) {
        this.title = title;
        this.content = content;
        this.tags = tags;
    }

    public Note(Long id, String title, String content, String tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.tags = tags;
    }

    @PrePersist  // Automatically set timestamps before saving
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate  // Automatically update the timestamp before updating
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Getters and setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
