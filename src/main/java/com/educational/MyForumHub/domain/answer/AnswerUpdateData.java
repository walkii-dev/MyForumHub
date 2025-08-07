package com.educational.MyForumHub.domain.answer;

import jakarta.validation.constraints.NotBlank;

public record AnswerUpdateData(@NotBlank String message) {
}
