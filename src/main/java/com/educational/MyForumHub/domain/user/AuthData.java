package com.educational.MyForumHub.domain.user;

import jakarta.validation.constraints.NotBlank;

public record AuthData(@NotBlank String login, @NotBlank String password) {
}
