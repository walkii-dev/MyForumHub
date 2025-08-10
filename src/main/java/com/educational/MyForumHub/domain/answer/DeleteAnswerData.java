package com.educational.MyForumHub.domain.answer;

import jakarta.validation.constraints.NotBlank;

public record DeleteAnswerData(@NotBlank Long topicId,@NotBlank Long id) {
}
