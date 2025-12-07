package com.nemo.NotesAPI;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Note {

    private Long id;

    @NotBlank(message = "Title cannot be empty!")
    @Size(max = 100, message = "Title cannot be more than 100 characters!")
    private String title;

    @NotBlank(message = "Content cannot be empty.")
    private String content;

    public Note() {}
    public Note(Long id, String title, String content){
        this.id = id;
        this. title = title;
        this.content = content;
    }

    public long getId() {
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
}
