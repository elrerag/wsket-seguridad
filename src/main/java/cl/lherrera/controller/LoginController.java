package cl.lherrera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/")
    public String main() {
        
        System.out.println("pasé!!!");
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(ModelMap modelo,
        @RequestParam(name = "error", required = false) String error) {
        if (error != null)
            modelo.put("error", true);

        return "auth/login";

    }
    
    @GetMapping("/recurso-prohibido")
    public String prohibido() {
        return "error/403";
    }
}
