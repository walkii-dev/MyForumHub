package com.educational.MyForumHub.domain.answer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnswerUpdateData(@NotNull Long answerId, @NotBlank String message) {
}
