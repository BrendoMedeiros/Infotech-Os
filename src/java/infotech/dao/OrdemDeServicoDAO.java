package infotech.dao;

import infotech.base.ConnectionDAO;
import infotech.base.DAO;
import infotech.model.OrdemDeServicoModel;
import infotech.model.UsuariosModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdemDeServicoDAO implements DAO {

    @Override
    public void atualizar(Object ob) throws Exception {

        OrdemDeServicoModel os = (OrdemDeServicoModel) ob;

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            String SQL = "UPDATE `ordemdeservico` SET `produto`= ?,`marca`= ?,`modelo`= ?,`probInfor`= ?,`status`= ?,`probConst`= ?,`data`= ?,`osIdUsu`= ? WHERE `idOs`= ?";
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement(SQL);

            ps.setString(1, os.getProduto());
            ps.setString(2, os.getMarca());
            ps.setString(3, os.getModelo());
            ps.setString(4, os.getProbInfor());
            ps.setString(5, os.getStatus());
            ps.setString(6, os.getProbConst());
            ps.setDate(7, Date.valueOf(os.getData()));
            ps.setInt(8, os.getOsIdUsu());
            ps.setInt(9, os.getIdOs());
            int resp = ps.executeUpdate();
            if (resp == 0) {
                throw new Exception("Ocorreu um erro! Nada foi feito!");
            }

        } catch (Exception ex) {
            throw new Exception("Erro ao alterar dados: \n" + ex);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }

    }

    public void atualizarOs(Object ob) throws Exception {

        OrdemDeServicoModel os = (OrdemDeServicoModel) ob;

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            String SQL = "UPDATE `ordemdeservico` SET `probConst`= ?, `status`= ? WHERE `idOs`= ?";
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement(SQL);

            ps.setString(1, os.getProbConst());
            ps.setString(2, os.getStatus());
            ps.setInt(3, os.getIdOs());

            int resp = ps.executeUpdate();
            if (resp == 0) {
                throw new Exception("Ocorreu um erro! Nada foi feito!");
            }

        } catch (Exception ex) {
            throw new Exception("Erro ao alterar dados: \n" + ex);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }

    }

    @Override
    public void excluir(Object ob) throws Exception {

        OrdemDeServicoModel os = (OrdemDeServicoModel) ob;

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            String SQL = "DELETE FROM `ordemdeservico` WHERE `idOs`= ?";
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, os.getIdOs());

            int resp = ps.executeUpdate();
            if (resp == 0) {
                throw new Exception("Ocorreu um erro! Nada foi feito!");
            }

        } catch (Exception ex) {
            throw new Exception("Erro ao alterar dados: \n" + ex);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }

    }

    @Override
    public List listaTodos() throws Exception {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<OrdemDeServicoModel> listaOs = new ArrayList<>();
        try {
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement(" SELECT `idOs`, `produto`, `marca`, `modelo`, `probInfor`, `status`, `probConst`, `data`, `osIdUsu` FROM `ordemdeservico` ");
            rs = ps.executeQuery();
            while (rs.next()) {
                listaOs.add(new OrdemDeServicoModel(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getDate(8).toLocalDate(), rs.getInt(9)));
            }

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return listaOs;

    }

    @Override
    public List procura(Object ob) throws Exception {

        OrdemDeServicoModel os = (OrdemDeServicoModel) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<OrdemDeServicoModel> listaOs = new ArrayList<>();
        try {
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement("SELECT `idOs`, `produto`, `marca`, `modelo`, `probInfor`, `status`, `probConst`, `data`, `osIdUsu`, `nome`, `telefone`\n"
                    + "   FROM `ordemdeservico` \n"
                    + "   INNER JOIN usuarios\n"
                    + "     ON usuarios.idUsu = ordemdeservico.osIdUsu \n"
                    + " ");
           
            rs = ps.executeQuery();
            while (rs.next()) {

                listaOs.add(new OrdemDeServicoModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8).toLocalDate(),
                        rs.getInt(9), 
                        new UsuariosModel(rs.getString(10), rs.getString(11))));
            }

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return listaOs;

    }

    /**
     *
     * @param ob
     * @return lista de todas OSs de todos clientes
     * @throws Exception
     */
    public List procuraTodos(Object ob) throws Exception {

        OrdemDeServicoModel os = (OrdemDeServicoModel) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<OrdemDeServicoModel> listaOs = new ArrayList<>();
        try {
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement("SELECT `idOs`, `produto`, `marca`, `modelo`, `probInfor`, `status`, `probConst`, `data`, `osIdUsu` FROM `ordemdeservico`");
            ps.setInt(1, os.getOsIdUsu());

            rs = ps.executeQuery();
            while (rs.next()) {

                listaOs.add(new OrdemDeServicoModel(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getDate(8).toLocalDate(), rs.getInt(9)));
            }

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return listaOs;

    }

    public int salvarOs(Object ob) throws Exception {

        OrdemDeServicoModel os = (OrdemDeServicoModel) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement("select function_cadastraOrdemDeServico(?,?,?,?,?,?,?,?)");
            ps.setString(1, os.getProduto());
            ps.setString(2, os.getMarca());
            ps.setString(3, os.getModelo());
            ps.setString(4, os.getProbInfor());
            ps.setString(5, os.getStatus());
            ps.setString(6, os.getProbConst());
            ps.setDate(7, Date.valueOf(os.getData()));
            ps.setInt(8, os.getOsIdUsu());

            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return -100;

    }

    @Override
    public void salvar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
