package cl.lherrera.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import cl.lherrera.service.AuthServiceImpl;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    private UserDetailsService servicioDetallesDeUsuario;
    private AuthenticationSuccessHandler manejadorDeAutentificacion;
    
    @Autowired
    public WebSecurityConfig(
        AuthServiceImpl servicioDetallesDeUsuario, 
        ManejadorDeAutentificacionPersonalizado manejadorDeAutentificacion) {
    
       this.servicioDetallesDeUsuario = servicioDetallesDeUsuario;
       this.manejadorDeAutentificacion = manejadorDeAutentificacion;
    }
    
    /**
     * este método que será desechado más adelante
     * se encarga de crear usuarios por defecto
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        // acá se usa nuestro (AuthServiceImpl), para personalizar.
        // el inicio de sesión o la carga del usuario prinsipal User.
        auth.userDetailsService(servicioDetallesDeUsuario)
        .passwordEncoder(EncoderUtils.passwordEncoder());
//        String adminUsername = "admin@mail.cl";
//        String adminPassword = EncoderUtils.passwordEncoder().encode("1234");
//        String adminRole = "ADMIN";
//
//        String userUsername = "user@mail.cl";
//        String userPassword = EncoderUtils.passwordEncoder().encode("1234");
//        String userRole = "USER";
//
//        auth.inMemoryAuthentication()
//        .withUser(adminUsername).password(adminPassword).roles(adminRole)
//        .and()
//        .withUser(userUsername).password(userPassword).roles(userRole);
    }

    /**
     * Acá irá la configuración principal
     * Las reglas serán impuestas en este
     * método.
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // csrf - desactivamos por seguridad
        http.csrf().disable()
        // configurar los request autorizados
        .authorizeRequests()
        //acceso a direcctorios
        .antMatchers("/admin/**").hasRole("ADMIN") // no es ROLE_ADMIN ni ROLE_USER (sin el ROLE_)
        .antMatchers("/login").permitAll()
        // permite el uso de los recursos estáticos
        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
        // para todo el resto de peticiones, permite, si está logeado
        .anyRequest().authenticated()
        // indicar el login personalizado
        .and().formLogin().loginPage("/login")
        // ocupamos nuestra clase personalizada
        // ManejadorDeAutentificacionPersonalizado
        .successHandler(manejadorDeAutentificacion)
        // indicar en caso de fallo, donde ir y con qué
        .failureUrl("/login?error=true")
        // indicar campos name en los imput
        // de usuario y contraseña
        .usernameParameter("correo").passwordParameter("contrasenia")
        // indicamos la url de éxito
//        .defaultSuccessUrl("/")
        // manejamos el recurso no permitido
        .and().exceptionHandling().accessDeniedPage("/recurso-prohibido");

    }
    
}
