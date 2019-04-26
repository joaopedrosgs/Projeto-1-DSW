package org.dsw.control.SiteVendas;

import org.dsw.dao.SiteVendasDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SiteListDeVendas", urlPatterns = {"/site/list"})
public class ListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("sites", SiteVendasDAO.getAll());
        request.getRequestDispatcher("/view/sites.jsp").forward(request, response);

    }
}
