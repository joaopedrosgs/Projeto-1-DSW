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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "UpdatePromocao", urlPatterns = "/promocao/update")
public class UpdateServlet extends HttpServlet {
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

            if(id != null) {
                Promocao promocao = PromocaoDAO.get(Integer.parseInt(id));

                if(site_id != null) {
                    promocao.setSiteId(Integer.parseInt(site_id));
                }

                if(teatro_id != null) {
                    promocao.setTeatroId(Integer.parseInt(teatro_id));
                }

                if(nome != null) {
                    promocao.setNome(nome);
                }

                if(preco != null) {
                    promocao.setPreco(Double.parseDouble(preco));
                }

                if(dia_horario != null) {
                    try {
                        promocao.setDiaHorario(new SimpleDateFormat("dd/MM/yyyy").parse(dia_horario));
                    }
                    catch (ParseException e) {
                        // TODO : retornar erro no formato de string
                    }
                }

                try {
                    PromocaoDAO.update(promocao);
                } catch (SQLException e) {
                    // Erro ao atualizar o site
                }
            }
        }
    }
}
