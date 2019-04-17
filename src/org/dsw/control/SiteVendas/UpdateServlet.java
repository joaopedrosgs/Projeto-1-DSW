package org.dsw.control.SiteVendas;

import org.dsw.control.Permissoes;
import org.dsw.dao.SiteVendasDAO;
import org.dsw.model.SiteVendas;

import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateServlet", urlPatterns = "/site/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Redirecionamento para os casos de erro
        HttpSession session = request.getSession();
        if(Permissoes.isAdminSession(session)) {
            String userId = request.getParameter("user_id");
            String url = request.getParameter("url");
            String nome = request.getParameter("nome");
            String telefone = request.getParameter("telefone");

            if(userId != null) {
                SiteVendas site = SiteVendasDAO.get(Integer.parseInt(userId));

                if(site != null) {
                    if (url != null)
                        site.setUrl(url);

                    if (nome != null)
                        site.setNome(nome);

                    if (telefone != null)
                        site.setTelefone(telefone);

                    try {
                        SiteVendasDAO.update(site);
                    } catch (SQLException e) {
                        // Erro ao atualizar o site
                    }
                }
            }
        }
    }
}
