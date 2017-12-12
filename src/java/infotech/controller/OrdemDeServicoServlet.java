package infotech.controller;

import infotech.dao.OrdemDeServicoDAO;
import infotech.model.OrdemDeServicoModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            String idOs = null;
            String action = request.getParameter("action");

            String probConst = null;
            String produto = null;
            String marca = null;
            String modelo = null;
            String probInfor = null;
            String status = null;
            String data = null;

            if (action.equals("edit") || action.equals("registrar")) {
                idOs = request.getParameter("id");
                probConst = request.getParameter("probConst");
                produto = request.getParameter("prod");
                marca = request.getParameter("marca");
                modelo = request.getParameter("modelo");
                probInfor = request.getParameter("probInfor");
                status = request.getParameter("status");
                data = request.getParameter("data");
            } else {
                idOs = request.getParameter("id");

            }
            OrdemDeServicoDAO dao = new OrdemDeServicoDAO();
            JSONObject dados = new JSONObject();
            OrdemDeServicoModel os = null;
            switch (action) {
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
                case "delete":
                    dao = new OrdemDeServicoDAO();
                    dados = new JSONObject();
                    os = new OrdemDeServicoModel(Integer.parseInt(idOs), probConst, status);

                    try {

                        dao.excluir(os);

                    } catch (Exception e) {
                        dados.put("error", e.getMessage());
                    }
                    dados.put("resp", "ok");
                    break;

                case "edit":
                    dao = new OrdemDeServicoDAO();
                    dados = new JSONObject();
                    os = new OrdemDeServicoModel(Integer.parseInt(idOs), probConst, status);

                    try {

                        dao.atualizarOs(os);

                    } catch (Exception e) {
                        dados.put("error", e.getMessage());
                    }
                    dados.put("resp", "ok");
                    out.print(dados);
                    break;
                default:
                    request.getRequestDispatcher("./principalOs.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
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
                dados.put("nome", os.getUsuariosModel().getNome());
                dados.put("telefone", os.getUsuariosModel().getTelefone());
                filhos.add(dados);
            }

            pai.put("data", filhos);
            out.print(pai);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
