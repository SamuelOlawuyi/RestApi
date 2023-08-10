package com.example.classactivity.controller;

import com.example.classactivity.entities.FacebookUser;
import com.example.classactivity.entities.Post;
import com.example.classactivity.repositories.UserRepository;
import com.example.classactivity.services.PostServicesImpl;
import com.example.classactivity.services.UserServicesImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;




@RestController
@RequestMapping("/")
public class UserController {
    private final UserServicesImpl userServices;
    private final UserRepository userRepository;
    private final PostServicesImpl postServices;

    @Autowired
    public UserController(UserServicesImpl userServices, UserRepository userRepository, PostServicesImpl postServices) {
        this.userServices = userServices;
        this.userRepository = userRepository;
        this.postServices = postServices;
    }

    @GetMapping("/bb")
    public String showRegistrationForm(Model model) {
        model.addAttribute("FacebookUser", new FacebookUser());
        return "registration";
    }


    @GetMapping("")
    public ResponseEntity<String> home() {
        return new ResponseEntity("Connected established", HttpStatus.OK);
    }



    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("user")FacebookUser user) {
        try {
            userServices.registerUser(user);
            return "redirect:/welcome";
        } catch (IllegalArgumentException e) {
            return "registration";
        }
    }

    @GetMapping("/welcome")
    public String showWelcomePage() {
        return "welcome";
    }

    @PostMapping("/welcome")
    public String processLogin(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               HttpSession session,
                               Model model) {
        // Attempt to login the user
        Optional<FacebookUser> optionalUser = userServices.loginUser(email, password);

        if (optionalUser.isPresent()) {
            FacebookUser user = optionalUser.get();

            // Set the user in the session for authentication
            session.setAttribute("user", user);

            // Redirect to the home page
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "welcome";
        }
    }
    @GetMapping("/home")
    public String showHomePage(@RequestBody Model model, HttpSession session) {
        // Get the authenticated user from the session
        FacebookUser user = (FacebookUser) session.getAttribute("user");

        // Check if the user is logged in
        if (user != null) {
            // Add the user's name to the model
            model.addAttribute("userName", user.getName());

            // Retrieve all posts
            List<Post> posts = postServices.getAllPosts();

            // Add the posts to the model
            model.addAttribute("posts", posts);

            // Return the homepage template
            return "home";
        } else {
            // If the user is not logged in, redirect to the login page
            return "redirect:/welcome";
        }
    }


}
