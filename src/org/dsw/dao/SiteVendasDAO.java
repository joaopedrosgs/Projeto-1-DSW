package org.dsw.dao;

import org.dsw.model.SiteVendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("Duplicates")
public class SiteVendasDAO extends GenericDAO {
    public static void create(SiteVendas site) {
        String sql = "INSERT INTO SiteVendas (id, url, nome, telefone) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = SiteVendasDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, site.getId());
            stat.setString(2, site.getUrl());
            stat.setString(3, site.getNome());
            stat.setString(4, site.getTelefone());
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
        String sql = "UPDATE SiteVendas SET id=?, url=?, nome=?, telefone=? WHERE id=?";

        try {
            Connection conn = SiteVendasDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, site.getId());
            stat.setString(2, site.getUrl());
            stat.setString(3, site.getNome());
            stat.setString(4, site.getTelefone());
            stat.setInt(5, site.getId());
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
                String url = result.getString("url");
                String nome = result.getString("nome");
                String telefone = result.getString("telefone");

                site = new SiteVendas(id, url, nome, telefone);
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
        List<SiteVendas> listaSites = new ArrayList<>();
        String sql = "SELECT * FROM SiteVendas";

        try {
            Connection conn = SiteVendasDAO.getConnection();
            Statement stat = conn.createStatement();

            ResultSet result = stat.executeQuery(sql);
            while(result.next()) {
                int id = result.getInt("id");
                String url = result.getString("url");
                String nome = result.getString("nome");
                String telefone = result.getString("telefone");

                listaSites.add(new SiteVendas(id, url, nome, telefone));
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
