package org.dsw.control;

import org.dsw.dao.UsuarioDAO;
import org.dsw.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegistroServlet", urlPatterns = "/usuario/create")
public class RegistroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            if (email != null && senha != null) {
                Senha senhaHash = new Senha(senha);

                UsuarioDAO.create(new Usuario(email, senhaHash.getHash()));
                // TODO: Redirecionar para a página de login
            }

            response.sendRedirect("/");
        } catch (SQLException e) {
            // TODO: Redirecionar para a página de registro, mas com erros
            response.sendRedirect("/");
        }
    }
}
