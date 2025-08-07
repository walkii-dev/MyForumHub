package com.educational.MyForumHub.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicUpdateData(@NotNull Long id,
                              @NotBlank String title,
                              @NotBlank String message,
                              @NotBlank String author,
                              @NotBlank String course) {
    public TopicUpdateData(Topic topic){
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getAuthor(), topic.getCourse());
    }
}
