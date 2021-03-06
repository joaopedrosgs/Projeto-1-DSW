package com.dsw.p1.control.SiteVendas;

import com.dsw.p1.control.Permissoes;
import com.dsw.p1.dao.SiteVendasDAO;
import com.dsw.p1.model.SiteVendas;

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
        int id = -1;
        HttpSession session = request.getSession();
        int user_id = (Integer) session.getAttribute("user_id");
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        SiteVendas site = SiteVendasDAO.get(id);
        if ((id != user_id && !Permissoes.isAdminSession(session)) || site == null) {
            response.sendRedirect("/site/list?msg=Parametros ou permissão invalida");
            return;

        }

        SiteVendasDAO.delete(site);
        response.sendRedirect("/site/list");

    }

}
