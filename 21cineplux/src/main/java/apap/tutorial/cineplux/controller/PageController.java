package apap.tutorial.cineplux.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String home(Model model){
        String userRole = getUserRole();
        model.addAttribute("userRole", userRole);
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    public String getUserRole() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getAuthorities().toString().replace("[", "").replace("]","");
    }
}
