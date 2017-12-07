package infotech.dao;

import infotech.base.ConnectionDAO;
import infotech.base.DAO;
import infotech.model.ImagensModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImagensDAO implements DAO {

    @Override
    public void atualizar(Object ob) throws Exception {

        ImagensModel imagens = (ImagensModel) ob;

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            String SQL = "UPDATE `imagens` SET `url`= ?,`tipo`= ?,`ImIdOs`= ? WHERE `idImagens`= ?";
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement(SQL);

            ps.setString(1, imagens.getUrl());
            ps.setInt(2, imagens.getTipo());
            ps.setInt(3, imagens.getImIdOs());

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
        List<ImagensModel> listaImagens = new ArrayList<>();
        try {
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement(" SELECT `idImagens`, `url`, `tipo`, `ImIdOs` FROM `imagens`");
            rs = ps.executeQuery();
            while (rs.next()) {
                listaImagens.add(new ImagensModel(rs.getInt(1),
                        rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return listaImagens;

    }

    @Override
    public List procura(Object ob) throws Exception {
    
        ImagensModel imagens = (ImagensModel) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<ImagensModel> listaImagens = new ArrayList<>();
        try {
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement(" SELECT `idImagens`, `url`, `tipo`, `ImIdOs` FROM `imagens` WHERE `idImagens` = ? ");
            ps.setInt(1, imagens.getIdImagens());
           
            rs = ps.executeQuery();
            while (rs.next()) {

                listaImagens.add(new ImagensModel(rs.getInt(1),
                        rs.getString(2), rs.getInt(3),
                        rs.getInt(4)));
            }

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return listaImagens;
        
    }

    public int salvarImagens(Object ob) throws Exception {
    
        ImagensModel imagens = (ImagensModel) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement("select function_cadastraImagens(?,?,?)");
            ps.setString(1, imagens.getUrl());
            ps.setInt(2, imagens.getTipo());
            ps.setInt(3, imagens.getImIdOs());

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
