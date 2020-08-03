package cl.lherrera.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import cl.lherrera.model.entity.Rol;
import cl.lherrera.model.entity.Usuario;


@EnableScheduling
@Configuration
public class SchedulerConfig {

    @Autowired
    SimpMessagingTemplate template;

    @Scheduled(fixedDelay = 3000)
    public void sendAdhocMessages() {
        Usuario usuario = new Usuario();
        usuario.setNombre("usuario");
        usuario.setCorreo("user@mail.cl");
        usuario.setContrasenia("1234");
        usuario.setRol(Rol.ROLE_USER);
        
//        template.convertAndSend("/intermedia/ws-usuario", usuario);
    }
}
