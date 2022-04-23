package Modelo.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.logica.Usuario;


/**
 *
 * @author Vic
 */
@WebServlet(name = "Controller", urlPatterns = {"/loadMovies"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        try {
            String viewURL = "index.html";
            switch (request.getServletPath()) {
                /*case "/registerRoom":
                    viewURL = this.registerRoom(request, response);
                    break;
                case "/searchMovies":
                    viewURL = this.searchMovies(request, response);
                    break;*/
                case "/loadMovies":
                    viewURL = this.loadMovies(request, response);
                    break;
                default:
                    viewURL = "index.html";
                    break;
            }
            request.getRequestDispatcher(viewURL).forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("index.html").forward(request, response);
        }
    }
    public String loadMovies(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        Usuario user = (Usuario) session.getAttribute("user");
        
        return "index.html";
    }

/*
    public String searchMovies(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cinema.getInstance().updateModel();
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        String searchCriteria = request.getParameter("searchCriteria");
        session.setAttribute("moviesResult", Cinema.getInstance().searchMovies(user, searchCriteria));
        return "movieSearch.jsp";
    }

    public String registerRoom(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, Exception {
        try {
            String id = request.getParameter("room_id");
            if (id.isEmpty()) {
                throw new IOException("Ninguno "
                        + "de los campos debe estar vacios.");
            }
            //Cinema.getInstance().insertRoom(new Room(id));
        } catch (Exception e) {
            request.getRequestDispatcher("mainPage.jsp").forward(request, response);
            throw e;
        }
        return "mainPage.jsp";
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
