package cl.lherrera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.lherrera.model.dto.UsuarioDto;
import cl.lherrera.model.entity.Usuario;
import cl.lherrera.service.UsuarioService;

@Controller
@RequestMapping("admin")
public class AdminController {
    
    @Autowired
    private UsuarioService servicio;
    
    @GetMapping
    public String admin(ModelMap modelo) {
        // capturo el nombre de usuario
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String name = auth.getName();
        modelo.addAttribute("username", name);

        return "admin/index";
    }
    
    @PostMapping
    public String usuario( @ModelAttribute Usuario usuario) {
        UsuarioDto usuarioDto = servicio.registrarUsuario(usuario);
        if(usuarioDto.getUsuario() == null)
            return "admin";

        return "redirect:home";
    }
}
