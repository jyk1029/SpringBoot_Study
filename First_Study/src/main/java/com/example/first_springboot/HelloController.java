package com.example.first_springboot;

//프레젠테이션

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/user") //url 통일
@RestController //ResponseBody + Controller
public class HelloController {

    private final HelloService hello; //지시자 상수(변하지 않는 값) 변수 변수명

    @GetMapping //url 연결
    public String helloGet() { //기본 지시자 문자열형
        return hello.get(); //hello.get 반환
    }

    @PostMapping
    public String helloPost() {
        return hello.post();
    }

    @PatchMapping
    public String helloPatch() {
        return hello.patch();
    }

    @PutMapping
    public String helloPut() {
        return hello.put();
    }

    @DeleteMapping
    public String helloDelete() {
        return hello.delete();
    }

    @GetMapping("/hello")
    public String hello() {
        return hello.hello();
    }
}