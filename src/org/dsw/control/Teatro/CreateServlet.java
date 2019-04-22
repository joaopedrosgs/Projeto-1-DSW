package org.dsw.control.Teatros;

import org.dsw.control.Permissoes;
import org.dsw.dao.TeatroDAO;
import org.dsw.dao.UsuarioDAO;
import org.dsw.model.Teatro;
import org.dsw.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CreateTeatro", urlPatterns = "/teatro/create")
public class CreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Redirecionamento para os casos de erro
        HttpSession session = request.getSession();

        if (Permissoes.isAdminSession(session)) {
            String id = request.getParameter("id");
            String cnpj = request.getParameter("cnpj");
            String nome = request.getParameter("nome");
            String cidade = request.getParameter("cidade");

            if (id != null && cnpj != null && nome != null && cidade  != null) {
                Usuario usuario = UsuarioDAO.get(Integer.parseInt(id));

                if (usuario != null) {
                    try {
                        TeatroDAO.create(new Teatro(Integer.parseInt(id), cnpj, nome, cidade));

                        return;
                    } catch (SQLException e) {
                        // Usuário já existe
                    }
                }
            }
        }
    }
}
