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

@WebServlet(name = "LoginServlet", urlPatterns = "/usuario/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if (email != null && senha != null) {
            Senha senhaHash = new Senha(senha);
            Usuario usuario = UsuarioDAO.getByEmail(email);

            if (usuario != null && senhaHash.compare(usuario.getSenha())) {
                HttpSession session = request.getSession();
                session.setAttribute("user_id", usuario.getId());

                response.sendRedirect("/");

                return;
            } else {
                // TODO: Redirecionar para página de login, mas com erros
            }
        }

        // TODO: Redirecionar para a página de login com erros
        response.sendRedirect("/");
    }
}
