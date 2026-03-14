package com.example.post_serviceSis6.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Schema(description = "Request body for creating a post")
public class CreatePostRequest {

    @Schema(description = "ID of the user creating the post", example = "user-42")
    @NotBlank(message = "userId must not be blank")
    private String userId;

    @Schema(description = "Post content, max 280 characters", example = "Hello Kafka!")
    @NotBlank(message = "content must not be blank")
    @Size(max = 280, message = "content must be at most 280 characters")
    private String content;

    @Schema(description = "List of hashtags without #", example = "[\"kafka\", \"spring\"]")
    private List<String> hashtags;

    public CreatePostRequest() {
    }

    public CreatePostRequest(String userId, String content, List<String> hashtags) {
        this.userId = userId;
        this.content = content;
        this.hashtags = hashtags;
    }

    public String getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }
}