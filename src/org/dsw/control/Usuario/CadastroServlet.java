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

@WebServlet(name = "UsuarioCadastroServlet", urlPatterns = "/usuario/create")
public class CadastroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if (email == null || senha == null) {
            response.sendRedirect("/usuario/create?msg=Usuario ou senha vazios");
            return;

        }

        Senha senhaHash = new Senha(senha);

        try {
            Usuario usuario = new Usuario(email, senhaHash.getHash(), true);
            UsuarioDAO.create(usuario);
            response.sendRedirect("/");

        } catch (SQLException e) {
            response.sendRedirect("/usuario/create?msg=Falha interna ao criar o usuario");

        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/cadastro.jsp").forward(request, response);
    }

}
