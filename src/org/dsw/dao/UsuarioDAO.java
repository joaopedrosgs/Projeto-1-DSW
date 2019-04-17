package org.dsw.dao;

import org.dsw.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends GenericDAO {
    public static void create(Usuario usuario) {
        String sql = "INSERT INTO Usuario (email, senha, admin) VALUES (?, ?, ?)";

        try {
            Connection conn = UsuarioDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString(1, usuario.getEmail());
            stat.setString(2, usuario.getSenha());
            stat.setBoolean(3, usuario.getAdmin());
            stat.executeUpdate();

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(Usuario usuario) {
        String sql = "DELETE FROM Usuario WHERE id=?";

        try {
            Connection conn = UsuarioDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, usuario.getId());
            stat.executeUpdate();

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(Usuario usuario) {
        String sql = "UPDATE Usuario SET id=?, email=?, senha=?, admin=? WHERE id=?";

        try {
            Connection conn = UsuarioDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, usuario.getId());
            stat.setString(2, usuario.getEmail());
            stat.setString(3, usuario.getSenha());
            stat.setBoolean(4, usuario.getAdmin());
            stat.setInt(5, usuario.getId());
            stat.executeUpdate();

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Usuario get(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE id=?";

        try {
            Connection conn = UsuarioDAO.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setInt(1, id);

            ResultSet result = stat.executeQuery();
            if(result.next()) {
                String email = result.getString("email");
                String senha = result.getString("senha");
                boolean admin = result.getBoolean("admin");

                usuario = new Usuario(id, email, senha, admin);
            }

            stat.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return usuario;
    }
}
