package com.dsw.p1.control.Usuario;

import com.dsw.p1.control.Permissoes;
import com.dsw.p1.control.Senha;
import com.dsw.p1.dao.UsuarioDAO;
import com.dsw.p1.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UsuarioLogoutServlet", urlPatterns = "/usuario/logout")
public class LogoutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.removeAttribute("user_id");
        session.removeAttribute("user_email");
        session.removeAttribute("is_admin");

        response.sendRedirect("/");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.removeAttribute("user_id");
        session.removeAttribute("user_email");
        session.removeAttribute("is_admin");

        response.sendRedirect("/");

    }

}
