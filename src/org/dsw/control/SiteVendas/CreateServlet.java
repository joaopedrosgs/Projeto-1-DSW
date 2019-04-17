package org.dsw.control.SiteVendas;

import org.dsw.control.Permissoes;
import org.dsw.dao.SiteVendasDAO;
import org.dsw.dao.UsuarioDAO;
import org.dsw.model.SiteVendas;
import org.dsw.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CreateServlet", urlPatterns = "/site/create")
public class CreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Redirecionamento para os casos de erro
        HttpSession session = request.getSession();

        if (Permissoes.isAdminSession(session)) {
            String userId = request.getParameter("user_id");
            String url = request.getParameter("url");
            String nome = request.getParameter("nome");
            String telefone = request.getParameter("telefone");

            if (userId != null && url != null && nome != null && telefone != null) {
                Usuario usuario = UsuarioDAO.get(Integer.parseInt(userId));

                if (usuario != null) {
                    try {
                        SiteVendasDAO.create(new SiteVendas(Integer.parseInt(userId), url, nome, telefone));

                        return;
                    } catch (SQLException e) {
                        // Usuário já existe
                    }
                }
            }
        }
    }
}
