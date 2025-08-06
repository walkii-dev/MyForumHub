package com.educational.MyForumHub.domain.topic;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record TopicCreationData(@NotBlank String title,
                                @NotBlank String message,
                                          LocalDateTime creation_data,
                                          String topic_status,
                                @NotBlank String author,
                                @NotBlank String course) {
}
