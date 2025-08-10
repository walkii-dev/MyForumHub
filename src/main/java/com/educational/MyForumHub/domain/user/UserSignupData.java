package com.educational.MyForumHub.domain.user;

import jakarta.validation.constraints.NotBlank;

public record UserSignupData(@NotBlank String login, @NotBlank String password) {
}
