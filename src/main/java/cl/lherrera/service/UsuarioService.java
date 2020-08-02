package cl.lherrera.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.lherrera.model.dao.UsuarioDao;
import cl.lherrera.model.dto.UsuarioDto;
import cl.lherrera.model.entity.Usuario;

@Service
public class UsuarioService {
    
    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
    
    @Autowired
    private UsuarioDao dao;

    public UsuarioDto registrarUsuario(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        
        Usuario usuarioEnBase = dao.findByCorreo(usuario.getCorreo()).orElse(null);
        
        if(usuarioEnBase != null) {
            usuarioDto.setUsuario(usuarioEnBase);
            logger.warn("El usuario que desea ingresar ya existe");
        }else {
            usuarioDto.setUsuario(dao.save(usuario));
        }
        
        return usuarioDto;
    }
    
    public UsuarioDto llenarUsuarios() {
        UsuarioDto usuarioDto = new UsuarioDto(new Usuario(), dao.findAll());

        return usuarioDto;
    }
    
    
}




















