package cl.lherrera.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.lherrera.model.dao.UsuarioDao;
import cl.lherrera.model.entity.Usuario;

@Service
public class WSocketService {
    
    @Autowired
    UsuarioDao dao;

    public Usuario insertaUsuario(Usuario usuario) {
        
        return dao.save(usuario);
    }
}
