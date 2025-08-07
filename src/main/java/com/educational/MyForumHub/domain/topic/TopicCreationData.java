package com.educational.MyForumHub.domain.topic;

import jakarta.validation.constraints.NotBlank;

public record TopicCreationData(@NotBlank String title,
                                @NotBlank String message,
                                @NotBlank String author,
                                @NotBlank String course) {
}
