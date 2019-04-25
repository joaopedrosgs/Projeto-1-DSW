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

@WebServlet(name = "DeletePromocao", urlPatterns = "/promocao/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Redirecionamento para os casos de erro
        HttpSession session = request.getSession();

        if(Permissoes.isAdminSession(session)) {
            String id = request.getParameter("id");

            if(id != null) {
                Promocao promocao = PromocaoDAO.get(Integer.parseInt(id));

                if(promocao != null) {
                    PromocaoDAO.delete(promocao);
                }
            }
        }
    }
}
