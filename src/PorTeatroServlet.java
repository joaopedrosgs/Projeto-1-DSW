import org.dsw.dao.PromocaoDAO;
import org.dsw.dao.TeatroDAO;
import org.dsw.model.Promocao;
import org.dsw.model.Teatro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PorTeatroServlet", urlPatterns = {"/ingressos", "/ingressos/por-teatro"})
@WebInitParam(name = "escolha", value = "Todas")

public class PorTeatroServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Promocao> promocoes = PromocaoDAO.getAll();
        List<Teatro> teatros = TeatroDAO.getAll();
        request.setAttribute("escolhas", teatros);
        request.setAttribute("promocoes", promocoes);
        request.setAttribute("por", "teatro");

        request.getRequestDispatcher("/ingressos.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Promocao> promocoes = null;
        String teatro_id = request.getParameter("escolha");
        List<Teatro> teatros = TeatroDAO.getAll();

        int teatro_id_int=-1;
        if (!teatro_id.isEmpty()) {
            try {
                teatro_id_int = Integer.parseInt(teatro_id);
                promocoes = PromocaoDAO.getAllFromTeatro(teatro_id_int);



            } catch (NumberFormatException nfe) {
                //TODO
            }
        }
        if(teatro_id_int == -1) {
            promocoes = PromocaoDAO.getAll();

        }

        request.setAttribute("escolhas", teatros);
        request.setAttribute("promocoes", promocoes);
        request.setAttribute("por", "teatro");

        request.getRequestDispatcher("/ingressos.jsp").forward(request, response);
    }
}
