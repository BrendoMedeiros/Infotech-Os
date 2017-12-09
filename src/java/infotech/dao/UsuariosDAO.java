package infotech.dao;

import infotech.base.ConnectionDAO;
import infotech.base.DAO;
import infotech.model.UsuariosModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO implements DAO {

    @Override
    public void atualizar(Object ob) throws Exception {

        UsuariosModel usuarios = (UsuariosModel) ob;

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            String SQL = "UPDATE `usuarios` SET `nome`= ?,`cpf`= ?,`endereco`= ?,`telefone`= ?,`email`= ?,`senha`= ?,`tipo`= ? WHERE `idUsu`= ?";
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement(SQL);

            ps.setString(1, usuarios.getNome());
            ps.setString(2, usuarios.getEndereco());
            ps.setString(3, usuarios.getTelefone());
            ps.setString(4, usuarios.getEmail());
            ps.setString(5, usuarios.getSenha());
            ps.setString(6, usuarios.getTipo());
            ps.setInt(7, usuarios.getIdUsu());

        } catch (Exception ex) {
            throw new Exception(ex);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    @Override
    public void excluir(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listaTodos() throws Exception {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<UsuariosModel> listaUsuarios = new ArrayList<>();
        try {
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement(" SELECT `idUsu`, `nome`, `cpf`, `endereco`, `telefone`, `email`, `senha`, `tipo` FROM `usuarios`");
            rs = ps.executeQuery();
            while (rs.next()) {
                listaUsuarios.add(new UsuariosModel(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8)));
            }

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return listaUsuarios;

    }

    @Override
    public List procura(Object ob) throws Exception {

        UsuariosModel usuarios = (UsuariosModel) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<UsuariosModel> listaUsuarios = new ArrayList<>();
        try {
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement("SELECT `idUsu`, `nome`, `cpf`, `endereco`, `telefone`, `email`, `senha`, `tipo` FROM `usuarios` WHERE `idUsu` = ? ");
            ps.setInt(1, usuarios.getIdUsu());

            rs = ps.executeQuery();
            while (rs.next()) {

                listaUsuarios.add(new UsuariosModel(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8)));
            }

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return listaUsuarios;

    }

    public List procuraUsuarioLogin(Object ob) throws Exception {

        UsuariosModel usuarios = (UsuariosModel) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<UsuariosModel> listaUsuarios = new ArrayList<>();
        try {
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement("SELECT `idUsu`, `nome`, `cpf`, `endereco`, `telefone`, `email`, `senha`, `tipo` FROM `usuarios` WHERE `email` = ? AND `senha`= ? ");
            ps.setString(1, usuarios.getEmail());
            ps.setString(2, usuarios.getSenha());

            rs = ps.executeQuery();
            while (rs.next()) {

                listaUsuarios.add(new UsuariosModel(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8)));
            }

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return listaUsuarios;

    }

    public int salvarUsuario(Object ob) throws Exception {

        UsuariosModel usuarios = (UsuariosModel) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement("select function_cadastraUsuarios(?,?,?,?,?,?,?)");
            ps.setString(1, usuarios.getNome());
            ps.setString(2, usuarios.getCpf());
            ps.setString(3, usuarios.getEndereco());
            ps.setString(4, usuarios.getTelefone());
            ps.setString(5, usuarios.getEmail());
            ps.setString(6, usuarios.getSenha());
            ps.setString(7, usuarios.getTipo());
            
            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException sqle) {
            String n = sqle.getMessage();
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
