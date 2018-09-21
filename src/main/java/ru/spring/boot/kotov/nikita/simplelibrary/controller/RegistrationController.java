package ru.spring.boot.kotov.nikita.simplelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.spring.boot.kotov.nikita.simplelibrary.entities.Role;
import ru.spring.boot.kotov.nikita.simplelibrary.entities.User;
import ru.spring.boot.kotov.nikita.simplelibrary.repos.UserRepo;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String addUSer(User user, Map<String,Object> model){
        User userFromDb=userRepo.findByUsername(user.getUsername());
        if(userFromDb!=null){
            model.put("error", "User already exist");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";
    }
}
