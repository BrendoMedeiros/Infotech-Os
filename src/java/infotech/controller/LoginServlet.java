package infotech.controller;

import infotech.dao.UsuariosDAO;
import infotech.model.UsuariosModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                  
            String acao = request.getParameter("acao");
            String email = request.getParameter("email");
            String senha = request.getParameter("pwd");

            switch (acao) {
                case "entrar":
                    try {
                        UsuariosDAO usuDao = new UsuariosDAO();
                        ArrayList<UsuariosModel> usuario = (ArrayList<UsuariosModel>) usuDao.procuraUsuarioLogin(new UsuariosModel(0, email, senha));
                        if (usuario.size() > 0) {
                            request.getSession().setAttribute("idUsuario", usuario.get(0).getIdUsu());
                            request.getRequestDispatcher("./os.jsp").forward(request, response);
                        } else {
                            request.getRequestDispatcher("./principalOs.jsp").forward(request, response);
                        }
                    } catch (Exception e) {
                        request.getRequestDispatcher("./principalOs.jsp").forward(request, response);
                    }
                    break;
                default:
                    request.getRequestDispatcher("./index.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
