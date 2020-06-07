package ac.kr.smu.tacos.web.controller;

import ac.kr.smu.tacos.domain.User;
import ac.kr.smu.tacos.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String registerForm(){
        return "registration";
    }
    @PostMapping
    public String registerUser(User user){
        userService.registerUser(user);
        return "redirect:/login";
    }
}
