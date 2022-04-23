package Modelo.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Vic
 */
@WebServlet(name = "Controller", urlPatterns = {"/registerRoom", "/loadMovies", "/schedule",
    "/PutIn", "/GetOff", "/searchMovies", "/print", "/seePurchases", "/pdf"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        try {
            String viewURL = "mainPage.jsp";
            switch (request.getServletPath()) {
                case "/registerRoom":
                    viewURL = this.registerRoom(request, response);
                    break;
                case "/searchMovies":
                    viewURL = this.searchMovies(request, response);
                    break;
                default:
                    viewURL = "mainPage.jsp";
                    break;
            }
            request.getRequestDispatcher(viewURL).forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("mainPage.jsp").forward(request, response);
        }
    }


    public String searchMovies(HttpServletRequest request, HttpServletResponse response) throws Exception {
        /*Cinema.getInstance().updateModel();
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        String searchCriteria = request.getParameter("searchCriteria");
        session.setAttribute("moviesResult", Cinema.getInstance().searchMovies(user, searchCriteria));*/
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
    }

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
