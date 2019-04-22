package org.dsw.control.Teatros;

import org.dsw.control.Permissoes;
import org.dsw.dao.TeatroDAO;
import org.dsw.model.Teatro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteTeatro", urlPatterns = "/teatro/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Redirecionamento para os casos de erro
        HttpSession session = request.getSession();

        if (Permissoes.isAdminSession(session)) {
            String id = request.getParameter("id");

            if (id != null) {
                Teatro teatro = TeatroDAO.get(Integer.parseInt(id));

                if (teatro != null) {
                    TeatroDAO.delete(teatro);
                }
            }
        }
    }
}
