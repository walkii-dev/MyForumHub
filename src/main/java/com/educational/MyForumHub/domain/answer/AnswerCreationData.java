package com.educational.MyForumHub.domain.answer;

import jakarta.validation.constraints.NotBlank;

public record AnswerCreationData(@NotBlank String message, @NotBlank String author) {
}
