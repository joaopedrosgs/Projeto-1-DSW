package com.dsw.p1.control.Promocao;

import com.dsw.p1.dao.PromocaoDAO;
import com.dsw.p1.dao.TeatroDAO;
import com.dsw.p1.model.Promocao;
import com.dsw.p1.model.Teatro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "IngressosPorTeatroListServlet", urlPatterns = {"/ingresso/list", "/ingresso/por-teatro"})
@WebInitParam(name = "escolha", value = "Todas")
public class ListPorTeatroServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Promocao> promocoes = PromocaoDAO.getAll();
        List<Teatro> teatros = TeatroDAO.getAll();
        request.setAttribute("escolhas", teatros);
        request.setAttribute("promocoes", promocoes);
        request.setAttribute("por", "teatro");

        request.getRequestDispatcher("/view/ingressos.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Promocao> promocoes = null;
        String teatro_id = request.getParameter("escolha");
        List<Teatro> teatros = TeatroDAO.getAll();

        int teatro_id_int=-1;
        if (teatro_id != null && !teatro_id.isEmpty()) {
            try {
                teatro_id_int = Integer.parseInt(teatro_id);
                promocoes = PromocaoDAO.getAllFromTeatro(teatro_id_int);

            } catch (NumberFormatException nfe) {
                //TODO
            }
        }
        if(teatro_id_int == -1) {
            promocoes = PromocaoDAO.getAll();

        }

        request.setAttribute("escolhas", teatros);
        request.setAttribute("promocoes", promocoes);
        request.setAttribute("por", "teatro");

        request.getRequestDispatcher("/view/ingressos.jsp").forward(request, response);
    }
}
