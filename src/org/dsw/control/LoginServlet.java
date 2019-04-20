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

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        request.setAttribute("failed", false);

        if (email != null && senha != null) {
            Senha senhaHash = new Senha(senha);
            Usuario usuario = UsuarioDAO.getByEmail(email);

            if (usuario != null && senhaHash.compare(usuario.getSenha())) {
                HttpSession session = request.getSession();
                session.setAttribute("user_id", usuario.getId());
                session.setAttribute("user_email", usuario.getEmail());

                response.sendRedirect("/painel");

                return;
            } else {
                request.setAttribute("failed", true);
            }
        }

        // TODO: Redirecionar para a página de login com erros
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("failed", false);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
