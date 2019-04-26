package org.dsw.control.Promocao;

import org.dsw.control.Permissoes;
import org.dsw.dao.PromocaoDAO;
import org.dsw.model.Promocao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PromocaoDeleteServlet", urlPatterns = "/ingresso/delete")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        if (id == null) {
            response.sendRedirect("/ingresso/list?msg=ID invalido");
            return;

        }

        Promocao promocao = PromocaoDAO.get(Integer.parseInt(id));
        if (promocao == null) {
            response.sendRedirect("/ingresso/list?msg=Id invalido");
            return;
        }

        PromocaoDAO.delete(promocao);
        response.sendRedirect("/ingresso/list?msg=Deletado com Sucesso");

    }

}
