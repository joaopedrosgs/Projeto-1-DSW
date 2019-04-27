package com.dsw.p1.control.Promocao;

import com.dsw.p1.dao.PromocaoDAO;
import com.dsw.p1.dao.SiteVendasDAO;
import com.dsw.p1.model.Promocao;
import com.dsw.p1.model.SiteVendas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "IngressosPorSiteListServlet", urlPatterns = "/ingresso/por-site")
@WebInitParam(name = "escolha", value = "Todos")
public class ListPorSiteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Promocao> promocoes;
        List<SiteVendas> sites = SiteVendasDAO.getAll();

        promocoes = PromocaoDAO.getAll();

        request.setAttribute("escolhas", sites);
        request.setAttribute("promocoes", promocoes);
        request.setAttribute("por", "site");

        request.getRequestDispatcher("/view/ingressos.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Promocao> promocoes = null;
        String siteIdString = request.getParameter("escolha");
        List<SiteVendas> sites = SiteVendasDAO.getAll();

        int siteId = -1;
        if (!siteIdString.isEmpty()) {
            try {
                siteId = Integer.parseInt(siteIdString);
                promocoes = PromocaoDAO.getAllFromSite(siteId);

            } catch (NumberFormatException nfe) {
                //TODO
            }
        }
        if (siteId == -1) {
            promocoes = PromocaoDAO.getAll();
        }
        request.setAttribute("escolhas", sites);
        request.setAttribute("promocoes", promocoes);
        request.setAttribute("por", "site");

        request.getRequestDispatcher("/view/ingressos.jsp").forward(request, response);
    }
}
