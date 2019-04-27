package com.dsw.p1.control.Promocao;

import com.dsw.p1.dao.PromocaoDAO;
import com.dsw.p1.dao.SiteVendasDAO;
import com.dsw.p1.dao.TeatroDAO;
import com.dsw.p1.model.Promocao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "PromocaoUpdateServlet", urlPatterns = "/ingresso/update")
public class UpdateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = -1;
        int teatro_id;
        int site_id;
        float preco;
        Date dia_horario;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            teatro_id = Integer.parseInt(request.getParameter("teatro_id"));
            site_id = Integer.parseInt(request.getParameter("site_id"));
            preco = Float.parseFloat(request.getParameter("preco"));
            String dia = request.getParameter("dia");
            dia_horario = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(dia);

        } catch (Exception e) {
            response.sendRedirect("/ingresso/list?msg=Parametros invalidos");
            return;

        }
        String nome = request.getParameter("nome");
        Promocao promocao = new Promocao(id, site_id, teatro_id, nome, preco, dia_horario);
        try {
            if (id == -1) {
                PromocaoDAO.create(promocao);
            } else {
                PromocaoDAO.update(promocao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("/ingresso/list?msg=Erro interno ao adicionar no banco de dados, talvez por conflito de horario");
            return;
        }

        response.sendRedirect("/ingresso/list?msg=Acao bem sucedida");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_string = request.getParameter("id");
        int id = -1;

        request.setAttribute("sites", SiteVendasDAO.getAll());
        request.setAttribute("teatros", TeatroDAO.getAll());

        if (id_string == null || id_string.isEmpty()) {
            request.getRequestDispatcher("/view/alterar_promocao.jsp").forward(request, response);
            return;
        }

        try {
            id = Integer.parseInt(id_string);
        } catch (Exception e) {
            request.getRequestDispatcher("/view/alterar_promocao.jsp").forward(request, response);
            e.printStackTrace();
            return;
        }

        Promocao promocao = PromocaoDAO.get(id);
        if (promocao != null) {
            request.setAttribute("promocao", promocao);
        }

        request.getRequestDispatcher("/view/alterar_promocao.jsp").forward(request, response);
    }
}
