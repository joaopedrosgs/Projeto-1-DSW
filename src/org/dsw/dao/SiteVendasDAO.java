package org.dsw.dao;

import org.dsw.model.SiteVendas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SiteVendasDAO {

    protected static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:~/.intellij/db/projeto-1-dsw.sqlite");
    }

    public static void create(SiteVendas site) {
        String sql = "INSERT INTO SiteVendas (email, senha, url, nome, telefone) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = SiteVendasDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString(1, site.getEmail());
            stat.setString(2, site.getSenha());
            stat.setString(3, site.getUrl());
            stat.setString(4, site.getNome());
            stat.setString(5, site.getTelefone());
            stat.executeUpdate();

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(SiteVendas site) {
        String sql = "DELETE FROM SiteVendas WHERE id=?";

        try {
            Connection conn = SiteVendasDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, site.getId());
            stat.executeUpdate();

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(SiteVendas site) {
        String sql = "UPDATE SiteVendas SET id=?, email=?, senha=?, url=?, nome=?, telefone=?";

        try {
            Connection conn = SiteVendasDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, site.getId());
            stat.setString(2, site.getEmail());
            stat.setString(3, site.getSenha());
            stat.setString(4, site.getUrl());
            stat.setString(5, site.getNome());
            stat.setString(6, site.getTelefone());
            stat.executeUpdate();

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static SiteVendas get(int id) {
        String sql = "SELECT * FROM SiteVendas WHERE id=?";
        SiteVendas site = null;

        try {
            Connection conn = SiteVendasDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, id);

            ResultSet result = stat.executeQuery();
            if(result.next()) {
                String email = result.getString("email");
                String senha = result.getString("senha");
                String url = result.getString("url");
                String nome = result.getString("nome");
                String telefone = result.getString("telefone");

                site = new SiteVendas(id, email, senha, url, nome, telefone);
            }

            result.close();
            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return site;
    }

    public static List<SiteVendas> getAll() {
        List<SiteVendas> listaSites = new ArrayList<SiteVendas>();
        String sql = "SELECT * FROM SiteVendas";

        try {
            Connection conn = SiteVendasDAO.getConnection();
            Statement stat = conn.createStatement();

            ResultSet result = stat.executeQuery(sql);
            while(result.next()) {
                int id = result.getInt("id");
                String email = result.getString("email");
                String senha = result.getString("senha");
                String url = result.getString("url");
                String nome = result.getString("nome");
                String telefone = result.getString("telefone");

                listaSites.add(new SiteVendas(id, email, senha, url, nome, telefone));
            }

            result.close();
            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaSites;
    }
}
