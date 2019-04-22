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
import java.sql.SQLException;

@WebServlet(name = "UpdateTeatro", urlPatterns = "/teatro/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Redirecionamento para os casos de erro
        HttpSession session = request.getSession();

        if (Permissoes.isAdminSession(session)) {
            String id = request.getParameter("id");
            String cnpj = request.getParameter("cnpj");
            String nome = request.getParameter("nome");
            String cidade = request.getParameter("cidade");

            if (id != null) {
                Teatro teatro = TeatroDAO.get(Integer.parseInt(id));

                if (teatro != null) {
                    if (cnpj != null)
                        teatro.setCNPJ(cnpj);

                    if (nome != null)
                        teatro.setNome(nome);

                    if (cidade != null)
                        teatro.setCidade(cidade);

                    try {
                        TeatroDAO.update(teatro);
                    } catch (SQLException e) {
                        // Erro ao atualizar o site
                    }
                }
            }
        }
    }
}
