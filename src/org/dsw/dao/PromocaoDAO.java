package org.dsw.dao;

import org.dsw.model.Promocao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromocaoDAO extends GenericDAO {
    public static void create(Promocao promocao) {
        String sql = "INSERT INTO Promocao (site_id, teatro_id, nome, preco, dia_horario) VALUEs (?, ?, ?, ?, ?)";

        try {
            Connection conn = PromocaoDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, promocao.getSiteId());
            stat.setInt(2, promocao.getTeatroId());
            stat.setString(3, promocao.getNome());
            stat.setDouble(4, promocao.getPreco());
            stat.setInt(5, promocao.getDiaHorarioTimestamp());
            stat.executeUpdate();

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(Promocao promocao) {
        String sql = "DELETE FROM Promocao WHERE id=?";

        try {
            Connection conn = PromocaoDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, promocao.getId());
            stat.executeUpdate();

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(Promocao promocao) {
        String sql = "UPDATE Promocao SET id=?, site_id=?, teatro_id=?, nome=?, preco=?, dia_horario=? WHERE id=?";

        try {
            Connection conn = PromocaoDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, promocao.getId());
            stat.setInt(2, promocao.getSiteId());
            stat.setInt(3, promocao.getTeatroId());
            stat.setString(4, promocao.getNome());
            stat.setDouble(5, promocao.getPreco());
            stat.setInt(6, promocao.getDiaHorarioTimestamp());
            stat.setInt(7, promocao.getId());
            stat.executeUpdate();

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Promocao get(int id) {
        String sql = "SELECT * FROM Promocao WHERE id=?";
        Promocao promocao = null;

        try {
            Connection conn = PromocaoDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, id);
            ResultSet result = stat.executeQuery();

            if (result.next()) {
                int siteId = result.getInt("site_id");
                int teatroId = result.getInt("teatro_id");
                String nome = result.getString("nome");
                double preco = result.getDouble("preco");
                int diaHorario = result.getInt("dia_horario");

                promocao = new Promocao(id, siteId, teatroId, nome, preco, diaHorario);
            }

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return promocao;
    }

    public static List<Promocao> getAllFromSite(int siteId) {
        String sql = "SELECT * FROM Promocao WHERE site_id=?";
        List<Promocao> promocaoList = new ArrayList<>();

        try {
            Connection conn = PromocaoDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, siteId);
            ResultSet result = stat.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                int teatroId = result.getInt("teatro_id");
                String nome = result.getString("nome");
                double preco = result.getDouble("preco");
                int diaHorario = result.getInt("dia_horario");

                promocaoList.add(new Promocao(id, siteId, teatroId, nome, preco, diaHorario));
            }

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return promocaoList;
    }
    public static List<Promocao> getAll() {
        String sql = "SELECT * FROM Promocao";
        List<Promocao> promocaoList = new ArrayList<>();

        try {
            Connection conn = PromocaoDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            ResultSet result = stat.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                int siteId = result.getInt("site_id");
                int teatroId = result.getInt("teatro_id");
                String nome = result.getString("nome");
                double preco = result.getDouble("preco");
                int diaHorario = result.getInt("dia_horario");

                promocaoList.add(new Promocao(id, siteId, teatroId, nome, preco, diaHorario));
            }

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return promocaoList;
    }
    public static List<Promocao> getAllFromTeatro(int teatroId) {
        String sql = "SELECT * FROM Promocao WHERE teatro_id=?";
        List<Promocao> promocaoList = new ArrayList<>();

        try {
            Connection conn = PromocaoDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, teatroId);
            ResultSet result = stat.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                int siteId = result.getInt("site_id");
                String nome = result.getString("nome");
                double preco = result.getDouble("preco");
                int diaHorario = result.getInt("dia_horario");

                promocaoList.add(new Promocao(id, siteId, teatroId, nome, preco, diaHorario));
            }

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return promocaoList;
    }
}
