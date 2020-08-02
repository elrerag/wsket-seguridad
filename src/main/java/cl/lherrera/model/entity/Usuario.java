package cl.lherrera.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import cl.lherrera.config.EncoderUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter @Getter private Integer id;
    @Setter @Getter private String nombre;
    @Setter @Getter private String correo;
    @Getter private String contrasenia;
    @Setter @Getter private Rol rol;
    
    public void setContrasenia(String contrasenia) {
        this.contrasenia = EncoderUtils.passwordEncoder().encode(contrasenia);
    }
    
    
}
