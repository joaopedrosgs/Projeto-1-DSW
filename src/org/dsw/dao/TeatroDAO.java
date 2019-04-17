package org.dsw.dao;

import org.dsw.model.Teatro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeatroDAO extends GenericDAO {
    public static void create(Teatro teatro) {
        String sql = "INSERT INTO Teatro (id, cnpj, nome, cidade) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = TeatroDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, teatro.getId());
            stat.setString(2, teatro.getCNPJ());
            stat.setString(3, teatro.getNome());
            stat.setString(4, teatro.getCidade());
            stat.executeUpdate();

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(Teatro teatro) {
        String sql = "DELETE FROM Teatro WHERE id=?";

        try {
            Connection conn = TeatroDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, teatro.getId());
            stat.executeUpdate();

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(Teatro teatro) {
        String sql = "UPDATE Teatro SET id=?, cnpj=?, nome=?, cidade=? WHERE id=?";

        try {
            Connection conn = TeatroDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, teatro.getId());
            stat.setString(2, teatro.getCNPJ());
            stat.setString(3, teatro.getNome());
            stat.setString(4, teatro.getCidade());
            stat.executeUpdate();

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Teatro get(int id) {
        String sql = "SELECT * FROM Teatro WHERE id=?";
        Teatro teatro = null;

        try {
            Connection conn = TeatroDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, id);
            ResultSet result = stat.executeQuery();

            if (result.next()) {
                String cnpj = result.getString("cnpj");
                String nome = result.getString("nome");
                String cidade = result.getString("cidade");

                teatro = new Teatro(id, cnpj, nome, cidade);
            }

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return teatro;
    }

    public static List<Teatro> getAll() {
        String sql = "SELECT * FROM Teatro";
        List<Teatro> teatroList = new ArrayList<>();

        try {
            Connection conn = TeatroDAO.getConnection();
            Statement stat = conn.createStatement();

            ResultSet result = stat.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("id");
                String cnpj = result.getString("cnpj");
                String nome = result.getString("nome");
                String cidade = result.getString("cidade");

                teatroList.add(new Teatro(id, cnpj, nome, cidade));
            }

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return teatroList;
    }

    public static List<Teatro> getAllFromCidade(String cidade) {
        String sql = "SELECT * FROM Teatro WHERE cidade=?";
        List<Teatro> teatroList = new ArrayList<>();

        try {
            Connection conn = TeatroDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            ResultSet result = stat.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String cnpj = result.getString("cnpj");
                String nome = result.getString("nome");

                teatroList.add(new Teatro(id, cnpj, nome, cidade));
            }

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return teatroList;
    }
}
