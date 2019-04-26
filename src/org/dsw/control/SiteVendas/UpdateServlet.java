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

@WebServlet(name = "SiteUpdateServlet", urlPatterns = "/site/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = -1;
        try {
            userId = Integer.parseInt(request.getParameter("user_id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = request.getParameter("url");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");

        Usuario usuario = UsuarioDAO.get(userId);

        if (usuario == null) {
            response.sendRedirect("/site/list?msg=Usuario invalido");
        }

        try {
            SiteVendasDAO.update(new SiteVendas(userId, url, nome, telefone));
            response.sendRedirect("/site/list?msg=Acao bem sucedida");

        } catch (SQLException e) {
            response.sendRedirect("/site/list?msg=Erro interno");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_string = request.getParameter("id");
        int id = -1;

        if (id_string == null || id_string.isEmpty()) {
            return;
        }

        try {
            id = Integer.parseInt(id_string);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SiteVendas site = SiteVendasDAO.get(id);
        if(site != null) {
            request.setAttribute("site", site);
        }

        request.getRequestDispatcher("/view/alterar_promocao.jsp").forward(request, response);
    }
}

