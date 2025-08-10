package com.educational.MyForumHub.domain.answer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnswerCreationData(@NotNull Long topicId ,
                                 @NotBlank String message) {
}
