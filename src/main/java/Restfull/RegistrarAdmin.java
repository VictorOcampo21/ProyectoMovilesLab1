package Restfull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataParam;
/**
 *
 * @author Vic
 */
@Path("/registerAdmin")
@PermitAll
public class RegistrarAdmin {

    String location = "C:/AAA/movies/";

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(Usuario e) {
        try {
            if (Ent_Usuario_Factory.usuarioExiste(String.valueOf(e.getId()))) {
                throw new Exception("persona ya existe");
            }
            Ent_Usuario_Factory.agregarUsuarios(e);

        } catch (Exception ex) {
            throw new NotAcceptableException();
        }
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("{id}/imagen")
    @RolesAllowed({"Administrador"})
    public void addImage(@PathParam("id") String id, @FormDataParam("imagen") InputStream imagenStream) {
        try {
            int read = 0;
            byte[] bytes = new byte[1024];

            OutputStream out = new FileOutputStream(new File(location + id));
            while ((read = imagenStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (Exception ex) {
            throw new NotAcceptableException();
        }
    }

    @GET
    @Path("{id}/imagen")
    @Produces("image/png")
    public Response getImage(@PathParam("id") String id) throws IOException {
        File file = new File(location + id);
        Response.ResponseBuilder response = Response.ok((Object) file);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/cliente")
    public void addClient(Cliente e) {
        try {
            Ent_Cliente_Factory.agregarCliente(e);
        } catch (Exception ex) {
            throw new NotAcceptableException();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/movie")
    @RolesAllowed({"Administrador"})
    public void addPelicula(Pelicula e) {
        try {
            if (Ent_Pelicula_Factory.PeliculaExiste(e.getId())) {
                throw new Exception("Id de pelicula ya existe.");
            }
            Ent_Pelicula_Factory.agregarPelicula(e);

        } catch (Exception ex) {
            throw new NotAcceptableException();
        }
    }
}
