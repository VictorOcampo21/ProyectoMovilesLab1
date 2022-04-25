package Restfull;

import Modelo.entidades.Ent_Estudiante_Factory;
import Modelo.entidades.Ent_Profesor_Factory;
import Modelo.entidades.Ent_Usuario_Factory;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import modelo.logica.Estudiante;
import modelo.logica.Profesor;
import modelo.logica.Usuario;

/**
 *
 * @author
 */
@Path("/registerAdmin")
public class Register {

    @Context
    HttpServletRequest request;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void register(Usuario usuario) {
        try {
            if (usuario == null) {
                throw new Exception("Usuario no creado");
            }
            Ent_Usuario_Factory.agregarUsuarios(usuario);
            System.out.println(usuario);
        } catch (Exception ex) {
            System.out.println(ex);
            throw new NotFoundException();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registerEstu")
    public void addStudent(Usuario usuario, Estudiante e) {
        try {
            if (usuario == null) {
                throw new Exception("Usuario no creado");
            }
            if (Ent_Estudiante_Factory.estudianteExiste(e.getId())) {
                throw new Exception("Estudiante ya se encuentra registrado.");
            }
            Ent_Usuario_Factory.agregarUsuarios(usuario);
            Ent_Estudiante_Factory.agregarEstudiante(e);
            System.out.println(usuario);
            System.out.println(e);
        } catch (Exception ex) {
            throw new NotAcceptableException();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registerProfesor")
    public void addProfesor(Usuario usuario, Profesor e) {
        try {
            if (usuario == null) {
                throw new Exception("Usuario no creado");
            }
            if (Ent_Profesor_Factory.profesorExiste(e.getId())) {
                throw new Exception("Profesor ya se encuentra registrado.");
            }
            Ent_Usuario_Factory.agregarUsuarios(usuario);
            Ent_Profesor_Factory.agregarProfesor(e);
            System.out.println(usuario);
            System.out.println(e);
        } catch (Exception ex) {
            throw new NotAcceptableException();
        }
    }

}
