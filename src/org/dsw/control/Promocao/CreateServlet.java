package org.dsw.control.Promocao;

import org.dsw.control.Permissoes;
import org.dsw.dao.PromocaoDAO;
import org.dsw.dao.UsuarioDAO;
import org.dsw.model.Promocao;
import org.dsw.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "CreatePromocao", urlPatterns = "/promocao/create")
public class CreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Redirecionamento para os casos de erro
        HttpSession session = request.getSession();

        if (Permissoes.isAdminSession(session)) {
            String id = request.getParameter("id");
            String site_id = request.getParameter("site_id");
            String teatro_id = request.getParameter("teatro_id");
            String nome = request.getParameter("nome");
            String preco = request.getParameter("preco");
            String dia_horario = request.getParameter("dia_horario");

            if(id != null && site_id != null && teatro_id != null && nome != null && preco != null && dia_horario != null) {
                Usuario usuario = UsuarioDAO.get(Integer.parseInt(id));

                if(usuario != null) {

                    try {
                        PromocaoDAO.create( new Promocao(Integer.parseInt(id), Integer.parseInt(site_id), Integer.parseInt(teatro_id), nome, Double.parseDouble(preco), new SimpleDateFormat("dd/MM/yyyy").parse(dia_horario)));

                        return;
                    } catch (ParseException | SQLException e) {
                        // TODO
                    }
                }
            }
        }
    }
}
