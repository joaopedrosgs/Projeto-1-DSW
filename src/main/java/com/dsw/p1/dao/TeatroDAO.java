package com.dsw.p1.dao;

import com.dsw.p1.model.Promocao;
import com.dsw.p1.model.Teatro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeatroDAO extends GenericDAO {

    public static void create(Teatro teatro) throws SQLException {
        String sql = "INSERT INTO Teatro (id, cnpj, nome, cidade) VALUES (?, ?, ?, ?)";

        Connection conn = TeatroDAO.getConnection();
        try {
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, teatro.getId());
            stat.setString(2, teatro.getCNPJ());
            stat.setString(3, teatro.getNome());
            stat.setString(4, teatro.getCidade());
            stat.executeUpdate();

            stat.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
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

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<Promocao> promocoes = PromocaoDAO.getAllFromTeatro(teatro.getId());
        for (Promocao promocao : promocoes) {
            PromocaoDAO.delete(promocao);
        }
    }

    public static void update(Teatro teatro) throws SQLException {
        String sql = "UPDATE Teatro SET cnpj=?, nome=?, cidade=? WHERE id=?";

        Connection conn = TeatroDAO.getConnection();
        try {
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString(1, teatro.getCNPJ());
            stat.setString(2, teatro.getNome());
            stat.setString(3, teatro.getCidade());
            stat.setInt(4, teatro.getId());
            stat.executeUpdate();

            stat.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
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
            stat.setString(1, cidade);

            ResultSet result = stat.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String cnpj = result.getString("cnpj");
                String nome = result.getString("nome");

                teatroList.add(new Teatro(id, cnpj, nome, cidade));
            }

            stat.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return teatroList;
    }
}
