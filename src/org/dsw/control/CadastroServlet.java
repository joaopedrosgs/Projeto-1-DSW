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

@WebServlet(name = "CadastroServlet", urlPatterns = "/cadastro")
public class CadastroServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        if (email != null && senha != null) {
        	Senha senhaHash = new Senha(senha);

        	try {
        		UsuarioDAO.create(new Usuario(email, senhaHash.getHash()));

                    return;
                } catch (SQLException e) {
                    // Erro ao cadastrar usuário
                }
        }
	}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/cadastro.jsp").forward(request, response);
    }
}
