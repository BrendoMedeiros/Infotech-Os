package infotech.controller;

import infotech.dao.OrdemDeServicoDAO;
import infotech.dao.UsuariosDAO;
import infotech.model.OrdemDeServicoModel;
import infotech.model.UsuariosModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/usuario"})
public class UsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            String idSessao = session.getAttribute("idUsuario").toString();

            if (idSessao.equals("")) {
                request.getRequestDispatcher("./index.jsp").forward(request, response);
            }

            String acao = request.getParameter("acao");
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String tel = request.getParameter("tel");
            String end = request.getParameter("end");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            switch (acao) {
                case "cadastrar":
                    try {
                        UsuariosDAO usuDao = new UsuariosDAO();
                        int idUsuario = usuDao.salvarUsuario(new UsuariosModel(nome, cpf, end, tel, email, senha, "C"));
                        if (idUsuario > 0) {
                            request.getSession().setAttribute("idUsuario", idUsuario);
                            request.getRequestDispatcher("./os.jsp").forward(request, response);
                        }

                    } catch (Exception e) {
                        request.getRequestDispatcher("./index.jsp").forward(request, response);
                    }
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
