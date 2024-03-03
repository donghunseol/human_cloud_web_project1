package com.example.project1.user;

import lombok.RequiredArgsConstructor;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private  final UserRepository userRepository;

    @PostMapping("/join")
    public String join(UserRequest.JoinDTO requestDTO){
        System.out.println(requestDTO);

   userRepository.save(requestDTO);
    return "redirect:/loginForm";
    }

    @PostMapping("/login")
    public String login(UserRequest.JoinDTO requestDTO){
        System.out.println(requestDTO);
        return "redirect:/loginForm";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/user/loginForm")
    public String login(){
        return "user/loginForm";
    }

    @PostMapping("/user/joinForm")
    public String join(){
        return "user/joinForm";
    }

    @GetMapping("/user/updateForm")
    public String update(){
        return "user/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

    @GetMapping("/myPage")
    public String myPage(){
        return "myPage/main";
    }

    @GetMapping("/myPage/selectList")
    public String myPageList(){
        return "myPage/selectList";
    }
}
