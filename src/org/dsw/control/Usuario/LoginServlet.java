package org.dsw.control.Usuario;

import org.dsw.control.Senha;
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

@WebServlet(name = "UsuarioLoginServlet", urlPatterns = "/usuario/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        HttpSession session = request.getSession();

        if (email == null || senha == null) {
            response.sendRedirect("/usuario/login?msg=Usuario ou senha vazios");
            return;

        }

        Senha senhaHash = new Senha(senha);
        Usuario usuario = UsuarioDAO.getByEmail(email);

        if (usuario == null || !senhaHash.compare(usuario.getSenha())) {
            response.sendRedirect("/usuario/login?msg=Usuario ou senha invalidos");
            return;

        }
        session.setAttribute("user_id", usuario.getId());
        session.setAttribute("user_email", usuario.getEmail());
        session.setAttribute("is_admin", usuario.getAdmin());

        response.sendRedirect("/");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/login.jsp").forward(request, response);

    }
}
