package org.dsw.control.Teatro;

import org.dsw.control.Permissoes;
import org.dsw.dao.SiteVendasDAO;
import org.dsw.dao.TeatroDAO;
import org.dsw.dao.UsuarioDAO;
import org.dsw.model.SiteVendas;
import org.dsw.model.Teatro;
import org.dsw.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TeatroUpdateServlet", urlPatterns = "/teatro/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = -1;
        String cnpj, nome, cidade;
        HttpSession session = request.getSession();
        int user_id = (int) session.getAttribute("user_id");

        cnpj = request.getParameter("cnpj");
        nome = request.getParameter("nome");
        cidade = request.getParameter("cidade");

        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
            response.sendRedirect("/teatro/list?msg=Informacoes invalidas");
            e.printStackTrace();
            return;
        }
        if(id==-1) {
         id=user_id;
        }
        if (id != user_id && !Permissoes.isAdminSession(session)) {
            response.sendRedirect("/teatro/list?msg=Id invalido");
            return;
        }

        try {
            Teatro teatro = new Teatro(id,cnpj, nome, cidade);
            if(TeatroDAO.get(id)==null) {
                TeatroDAO.create(teatro);
            } else {
                TeatroDAO.update(teatro);
            }

            response.sendRedirect("/teatro/list?msg=Acao bem sucedida");


        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("/teatro/list?msg=Erro interno");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_string = request.getParameter("id");
        HttpSession session = request.getSession();

        int id = -1;
        int user_id = (int) session.getAttribute("user_id");


        if (id_string == null || id_string.isEmpty()) {
            request.getRequestDispatcher("/view/alterar_teatro.jsp").forward(request, response);
            return;
        }

        try {
            id = Integer.parseInt(id_string);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Teatro teatro =TeatroDAO.get(id);
        if ((id == user_id || Permissoes.isAdminSession(session)) && teatro != null) {
            request.setAttribute("teatro", teatro);
        }

        request.getRequestDispatcher("/view/alterar_teatro.jsp").forward(request, response);
    }
}