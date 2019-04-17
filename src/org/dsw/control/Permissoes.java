package org.dsw.control;

import org.dsw.dao.UsuarioDAO;
import org.dsw.model.Usuario;

import javax.servlet.http.HttpSession;

public class Permissoes {
    public static boolean isAdminSession(int id) {
        Usuario usuario = UsuarioDAO.get(id);

        return usuario.getAdmin();
    }

    public static boolean isAdminSession(HttpSession session) {
        Object user_id = session.getAttribute("user_id");
        if (user_id != null) {
            return Permissoes.isAdminSession((int) user_id);
        }

        return false;
    }
}
