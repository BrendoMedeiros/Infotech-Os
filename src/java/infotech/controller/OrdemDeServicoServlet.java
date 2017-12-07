package infotech.controller;

import infotech.dao.OrdemDeServicoDAO;
import infotech.model.OrdemDeServicoModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.JsonArray;

@WebServlet(name = "OrdemDeServicoServlet", urlPatterns = {"/os"})
public class OrdemDeServicoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String idSessao = session.getAttribute("idUsuario").toString();

            if (idSessao.equals("")) {
                request.getRequestDispatcher("./index.jsp").forward(request, response);
            }
            String cmd = request.getParameter("cmd");
            String produto = request.getParameter("prod");
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            String probInfor = request.getParameter("probInfor");
            String status = request.getParameter("status");
            String data = request.getParameter("data");

            switch (cmd) {
                case "registrar":
                    try {
                        Integer id = (Integer) request.getSession().getAttribute("idUsuario");
                        OrdemDeServicoDAO osDao = new OrdemDeServicoDAO();
                        osDao.salvarOs(new OrdemDeServicoModel(produto, marca, modelo, probInfor, status, "", LocalDate.parse(data), id));
                        request.setAttribute("sucesso", "OS Cadastrada com sucesso");
                        request.getRequestDispatcher("./principalOs.jsp").forward(request, response);
                    } catch (Exception e) {
                        request.setAttribute("erro", "Erro ao cadastrar OS:<br>" + e.getMessage());
                        request.getRequestDispatcher("./principalOs.jsp").forward(request, response);
                    }
                    break;

                case "listaCadastroDeServico":
                    this.buscaCadastroDeOs(request, response);
                    break;
                default:
                    request.getRequestDispatcher("./principalOs.jsp").forward(request, response);
            }
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

    private void buscaCadastroDeOs(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            JSONObject dados = new JSONObject();
            ArrayList<OrdemDeServicoModel> ordens = new ArrayList<>();
            try {
                Integer id = (Integer) request.getSession().getAttribute("idUsuario");
                OrdemDeServicoDAO osDao = new OrdemDeServicoDAO();
                ordens = (ArrayList<OrdemDeServicoModel>) osDao.procura(new OrdemDeServicoModel(id));
            } catch (Exception e) {

            }

            JSONObject pai = new JSONObject();
            JsonArray filhos = new JsonArray();

            for (OrdemDeServicoModel os : ordens) {
                dados = new JSONObject();
                dados.put("idOs", os.getIdOs());
                dados.put("produto", os.getProduto());
                dados.put("marca", os.getMarca());
                dados.put("modelo", os.getModelo());
                dados.put("problema", os.getProbInfor());
                dados.put("status", os.getStatus());
                dados.put("data", os.getData().format(DateTimeFormatter.ISO_LOCAL_DATE));
                dados.put("probConst", os.getProbConst());
                filhos.add(dados);
            }

            pai.put("data", filhos);
            out.print(pai);
        }
    }
}
