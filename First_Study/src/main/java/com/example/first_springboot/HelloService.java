package com.example.first_springboot;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String get() {
        return "Get";
    }

    public String post() {
        return "Post";
    }

    public String patch() {
        return "Patch";
    }

    public String put() {
        return "Put";
    }

    public String delete() {
        return "Delete";
    }

    public String hello() {
        return "Hello, World!";
    }
}
