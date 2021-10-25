package com.example.demo.controller;


import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
@Controller
public class UserLogin {

    private User user;

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //    @Autowired
//    public void setUser(User user) {
//        this.user = user;
//    }


    @Autowired
    public UserLogin(User user) {
        this.user = user;
    }

    //    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    @GetMapping("/login/{name}")
    public String loginPage(@PathVariable("name") String username){
        System.out.println(username);
        return "login";
    }

//    @GetMapping("/login")
//    public String loginPage2(@RequestParam("user") String id){
//        System.out.println(id);
//        return "login";
//    }

//    @GetMapping("/login")
//    public ModelAndView loginPage2(ModelAndView modelAndView){
//        User user = new User();
//        modelAndView.addObject("user",user);
//        modelAndView.setViewName("login");
//        return modelAndView;
//    }

    @GetMapping("/login")
    public String loginPage2(Model model,
                             @Nullable @RequestParam String valid){

//        user.setUsername("spring");
//        user.setPassword("123");
//        userRepository.save(user);
        if (userRepository.findById("spring").isPresent()){
            userRepository.deleteById("spring");
//            user = userRepository.findById("spring").get();
//            user.setPassword("159");
//            userRepository.save(user);
        }

//        User user = new User();
        model.addAttribute("user",user);
        if (valid != null && valid.equals("false")){
            model.addAttribute("valid","false");
        }
        return "login";
    }

    @PostMapping("/login")
    public String submit(@ModelAttribute User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        if (user.getPassword().equals("123")){
            return "profile";
        }
        else {
            return "redirect:/login?valid=false";
        }

    }

}