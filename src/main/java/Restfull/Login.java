package Restfull;


import Modelo.entidades.Ent_Usuario_Factory;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import modelo.logica.Usuario;

/**
 *
 * @author Vic
 */

@Path("/login")
@PermitAll
public class Login {
    @Context
    HttpServletRequest request;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public Usuario login(Usuario usuario) {  

            
            try {
                Usuario logged = Ent_Usuario_Factory.datosCorrectosUsuario(usuario.getId(), usuario.getClave());
                request.getSession(true).setAttribute("user", logged);
                return logged;
            } catch (Exception ex) {
                System.out.println(ex);
                throw new NotFoundException();
                
            }  
    }
    
    @DELETE 
    public void logout() {  
        HttpSession session = request.getSession(true);
        session.removeAttribute("user");           
        session.invalidate();
    }
    
}