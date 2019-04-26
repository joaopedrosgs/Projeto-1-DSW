package org.dsw.control.Promocao;

import org.dsw.control.Permissoes;
import org.dsw.dao.PromocaoDAO;
import org.dsw.model.Promocao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "PromocaoDeleteServlet", urlPatterns = "/ingresso/delete")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int user_id = (int) session.getAttribute("user_id");
        int id=-1;

        try {
            id = Integer.parseInt(request.getParameter("id"));
        }catch (Exception e) {
            response.sendRedirect("/ingresso/list?msg=Id invalido");
            e.printStackTrace();
        }


        Promocao promocao = PromocaoDAO.get(id);
        if (promocao == null) {
            response.sendRedirect("/ingresso/list?msg=Id invalido");
            return;
        }
        if ((promocao.getTeatroId() != user_id && !Permissoes.isAdminSession(session)) || promocao == null) {
            response.sendRedirect("/ingresso/list?msg=Parametros ou permissão invalida");
            return;

        }


        PromocaoDAO.delete(promocao);
        response.sendRedirect("/ingresso/list?msg=Deletado com Sucesso");

    }

}
