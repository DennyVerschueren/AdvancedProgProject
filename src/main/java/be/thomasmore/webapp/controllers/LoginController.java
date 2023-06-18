package be.thomasmore.webapp.controllers;

import be.thomasmore.webapp.model.EndUser;
import be.thomasmore.webapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping({"/login", "/user/login"})
    public String login(Principal principal, Model model) {
        if (principal != null) return "redirect:/home";
        return "user/login";
    }

    @GetMapping({"/signup", "/user/signup"})
    public String register(Principal principal) {
        if (principal != null) return "redirect:/home";
        return "user/signup";
    }

    @GetMapping({"/logout", "/user/logout"})
    public String logout(Principal principal) {
        if (principal != null) return "redirect:/home";
        return "user/logout";
    }

    @PostMapping({"/signup", "/user/signup"})
    public String registerPost(Principal principal, @RequestParam String emailAddress, @RequestParam String userName, @RequestParam String password)  {
        if (principal != null) return "redirect:/festivallijst";
        if (emailAddress == null || emailAddress.trim().equals("")) return "redirect:/home";
        if (userName == null || userName.trim().equals("")) return "redirect:/home";
        if (password == null || password.trim().equals("")) return "redirect:/home";
        userName = userName.trim();

        String encodedPassword = encoder.encode(password.trim());

        EndUser user = new EndUser(emailAddress, userName, encodedPassword, "ROLE_USER");
        userRepository.save(user);

        autologin(userName, password.trim());

        return "redirect:/home";
    }

    private void autologin(String userName, String password) {
        SecurityContext sc = SecurityContextHolder.getContext();
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName, password);
            Authentication auth = authenticationManager.authenticate(token);
            sc.setAuthentication(auth);
        } catch (AuthenticationException e) {
            sc.setAuthentication(null);
        }
    }
}
