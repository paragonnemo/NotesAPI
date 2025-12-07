package com.nemo.NotesAPI;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NoteRequest {

    @NotBlank(message = "Title cannot be empty")
    @Size(max = 100, message = "Title must be <= 100 characters")
    private String title;

    @NotBlank(message = "Content cannot be empty")
    @Size(max = 5000, message = "Content must be <= 5000 characters")
    private String content;

    public NoteRequest() {
    }

    public NoteRequest(String title, String content) {
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
}