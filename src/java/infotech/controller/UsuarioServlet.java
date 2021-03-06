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

//            HttpSession session = request.getSession();
//            String idSessao = session.getAttribute("idUsuario").toString();
//
//            if (idSessao.equals("")) {
//                request.getRequestDispatcher("./index.jsp").forward(request, response);
//            }

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

            switch (acao) {
                case "cadastrarAdm":
                    try {
                        UsuariosDAO usuDao = new UsuariosDAO();
                        int idUsuario = usuDao.salvarUsuario(new UsuariosModel(nome, cpf, end, tel, email, senha, "A"));
                        if (idUsuario > 0) {
                            request.getSession().setAttribute("idUsuario", idUsuario);
                            request.getRequestDispatcher("./hist.jsp").forward(request, response);
                        }

                    } catch (Exception e) {
                         System.out.println("\n\n\nErro:"+e.getMessage());
                        request.getRequestDispatcher("./index.jsp").forward(request, response);
                    }
                default:
                    request.getRequestDispatcher("./index.jsp").forward(request, response);
            }

        }catch(Exception e){
            System.out.println("\n\n\nErro:"+e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
