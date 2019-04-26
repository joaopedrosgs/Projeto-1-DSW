package org.dsw.control.SiteVendas;

import org.dsw.control.Permissoes;
import org.dsw.dao.SiteVendasDAO;
import org.dsw.model.SiteVendas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SiteDeleteServlet", urlPatterns = "/site/delete")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("user_id"));
        SiteVendas site = SiteVendasDAO.get(userId);
        if (site == null) {
            response.sendRedirect("/site/list?msg=Voce nao possui um site");
        }

        SiteVendasDAO.delete(site);
        response.sendRedirect("/site/list");


    }

}
