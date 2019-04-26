package org.dsw.control.Teatro;

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

@WebServlet(name = "TeatroDeleteServlet", urlPatterns = "/teatro/delete")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Redirecionamento para os casos de erro
        HttpSession session = request.getSession();
        int id = -1;
        int user_id = (int) session.getAttribute("user_id");
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
            response.sendRedirect("/teatro/list?msg=Id invalido");
            return;

        }
        Teatro teatro = TeatroDAO.get(id);

        if ((id != user_id && !Permissoes.isAdminSession(session)) || teatro == null) {
            response.sendRedirect("/teatro/list?msg=Teatro invalido");
            return;

        }
        TeatroDAO.delete(teatro);
        response.sendRedirect("/teatro/list?msg=Acao bem sucedida");


    }

}

