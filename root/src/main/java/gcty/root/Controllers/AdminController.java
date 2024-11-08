package gcty.root.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/admin")
public class AdminController {
    
    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        
        return "admin-dashboard";
    }

}
