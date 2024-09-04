package com.tsys.exauth.domain.user;

public record UserRegisterDTO(String login, String password, UserRole role) {
}
