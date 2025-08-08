package com.educational.MyForumHub.domain.answer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnswerCreationData(@NotNull(message = "tá errado isso ai!") Long topicId , @NotBlank String message, @NotBlank String author) {
}
