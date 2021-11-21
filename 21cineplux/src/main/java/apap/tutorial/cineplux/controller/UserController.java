package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.RoleService;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// Java program for the above approach

import java.util.regex.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    private String addUserFormPage(Model model) {
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, @RequestParam String password, @RequestParam String email, Model model) {
        if(!isAllPresent(password)) {
            return "failed-create-user";
        }
        Boolean ada = userService.isEmailExist(email);
        if(ada.equals(true)) {
            return "failed-create-user";
        }
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/viewall")
    public String viewAllUser(Model model) {
        List<UserModel> listUser = userService.getListUser();
        String userRole = getUserRole();
        if (!userRole.equals("ADMIN")) {
            return "error-no-authorities";
        }
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(
            @PathVariable String username,
            Model model
    ) {
        UserModel user = userService.getUserByUsername(username);
        userService.deleteUser(user);
        model.addAttribute("username", username);
        return "delete-user";
    }

    public String getUserRole() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getAuthorities().toString().replace("[", "").replace("]","");
    }

    public String getUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @GetMapping("/changePassword")
    public String changePasswordForm(
            Model model
    ) {
        String username = getUsername();
        UserModel user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        return "form-change-password";
    }

    @PostMapping(value = "/changePassword")
    private String changePasswordSubmit(
            @ModelAttribute UserModel user,
            @RequestParam(value = "oldPassword") String oldPassword,
            @RequestParam(value = "newPassword") String newPassword,
            @RequestParam(value = "confirmedNewPassword") String confirmedNewPassword,
            Model model) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(passwordEncoder.matches(oldPassword, user.getPassword())) {
            if(isAllPresent(newPassword)) {
                if (confirmedNewPassword.equals(newPassword)) {
                    user.setPassword(newPassword);
                } else {
                    return "not-matches-kriteria";
                }
            } else {
                return "not-matches-kriteria";
            }
        } else {
            return "not-matches-kriteria";
        }
        userService.updateUser(user);
        return "change-password";
    }

    // nyomot dari https://www.geeksforgeeks.org/check-if-a-string-contains-uppercase-lowercase-special-characters-and-numeric-values/
    public boolean isAllPresent(String str)
    {
        // ReGex to check if a string
        // contains uppercase, lowercase
        // special character & numeric value
        String regex = "^(?=.*[a-z])(?=."
                + "*[A-Z])(?=.*\\d)"
                + "(?=.*[-+_!@#$%^&*., ?]).+$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the string is empty
        // then return false
        if (str == null) {
            return false;
        }

        // Find match between given string
        // & regular expression
        Matcher m = p.matcher(str);

        // return true if string
        // matches ReGex
        if (m.matches())
            return true;
        else
            return false;
    }
}
