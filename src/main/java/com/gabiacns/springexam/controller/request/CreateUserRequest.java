package com.gabiacns.springexam.controller.request;

import lombok.Data;

@Data
public class CreateUserRequest {

    private String name;

    private String password;
}
