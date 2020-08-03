package cl.lherrera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import cl.lherrera.model.entity.Usuario;
import cl.lherrera.service.WSocketService;


@Controller
public class WebSocketController {
    
    @Autowired
    WSocketService servicio;
    
    @MessageMapping("/ws-usuario")
    @SendTo("/intermedia/ws-usuario")
    public Usuario getUser(@Payload Usuario usuario) {
        
        // ahora retornamos el usuario ingresado
        return servicio.insertaUsuario(usuario);
    }
}
