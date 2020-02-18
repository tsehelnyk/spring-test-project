package com.dev.test.dto;

public class UserResponseDto {
    private String email;
    private String name;

    public UserResponseDto(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nUserResponseDto{"
                + "email= " + email
                + ", name= " + name + "}";
    }
}
