/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Restfull;

import Modelo.logica.Universidad;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import modelo.logica.Usuario;
/**
 *
 * @author 
 */
@Path("/register")
public class Register {
  @Context
    HttpServletRequest request;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public void register(Usuario usuario) {  
            try {
                if(usuario == null) throw new Exception("Usuario no creado");
                Universidad.getInstance().agregarUsuario(usuario.getId(), usuario.getClave(), "ADM");
                System.out.println(usuario);
            } catch (Exception ex) {
                System.out.println(ex);
                throw new NotFoundException();
            }  
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/student")
    public void addStudent(Estudainte e) {
        try {
// No se como se llaman los metetodos del factory de estudiante pero la logica seria así
            /*if (Ent_Estudiante_Factory.estudianteExiste(e.getId())) {
                throw new Exception("Estudiante ya se encuentra registrado.");
            }
            Ent_Estudiante_Factory.agregarEstudiante(e);*/

        } catch (Exception ex) {
            throw new NotAcceptableException();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/profesor")
    public void addProfesor(Profesor e) {
        try {
// No se como se llaman los metetodos del factory de profesor pero la logica seria así, creo jajaja
            /*if (Ent_Profesor_Factory.profesorExiste(e.getId())) {
                throw new Exception("Profesor ya se encuentra registrado.");
            }
            Ent_Profesor_Factory.agregarProfesor(e);*/

        } catch (Exception ex) {
            throw new NotAcceptableException();
        }
    }

}
