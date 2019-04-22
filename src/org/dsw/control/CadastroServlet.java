package org.dsw.control;

import org.dsw.dao.UsuarioDAO;
import org.dsw.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CadastroServlet", urlPatterns = "/cadastro")
public class CadastroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("user_id") != null) {
            response.sendRedirect("/painel");
            return;
        }

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        request.setAttribute("failed", false);


        if (email == null || senha == null) {
            request.setAttribute("failed", true);
            request.getRequestDispatcher("/cadastro.jsp").forward(request, response);

        }

        Senha senhaHash = new Senha(senha);

        try {
            Usuario usuario = new Usuario(email, senhaHash.getHash(), true);
            UsuarioDAO.create(usuario);
            response.sendRedirect("/login");

        } catch (SQLException e) {
            request.setAttribute("failed", true);
            request.getRequestDispatcher("/cadastro.jsp").forward(request, response);

        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user_id") != null) {
            response.sendRedirect("/painel");
            return;
        }

        request.setAttribute("failed", false);
        request.getRequestDispatcher("/cadastro.jsp").forward(request, response);
    }

}
