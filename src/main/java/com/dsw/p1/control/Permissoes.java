package com.dsw.p1.control;

import com.dsw.p1.dao.UsuarioDAO;
import com.dsw.p1.model.Usuario;

import javax.servlet.http.HttpSession;

public class Permissoes {
    public static boolean isAdminSession(int id) {
        Usuario usuario = UsuarioDAO.get(id);

        return usuario.getAdmin();
    }

    public static boolean isAdminSession(HttpSession session) {
        Object user_id = session.getAttribute("user_id");
        if (user_id != null) {
            return  UsuarioDAO.get((Integer) user_id).getAdmin();
        }

        return false;
    }
    public static boolean userExists(HttpSession session) {
        Object user_id = session.getAttribute("user_id");
        if (user_id != null) {
            return UsuarioDAO.get((Integer) user_id) != null;
        }
        return false;
    }
}
