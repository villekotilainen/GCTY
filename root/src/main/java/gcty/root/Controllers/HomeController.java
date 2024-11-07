package gcty.root.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gcty.root.Entities.User;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/index")
public class HomeController {
    
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    } 

    // KÄYTTÄJÄN LUONTI:

    @GetMapping("/signup")
    public String showSignUpFormm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/signup")
    public String submitSignUpForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user-form";
        }
        else {
            return "redirect:/index";
        }
    }

}
