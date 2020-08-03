package cl.lherrera.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import cl.lherrera.model.entity.Usuario;


@Controller
public class WebSocketController {
    
    @MessageMapping("/ws-usuario")
    @SendTo("/intermedia/ws-usuario")
    public Usuario getUser(@Payload Usuario usuario) {
        // la contraseña llega encriptada, por que el payload hace el set
        // del Usuario y el set de la contrasenia, lo encripta
        return usuario;
    }
}
