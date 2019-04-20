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

@WebServlet(name = "TeatrosServlet", urlPatterns="/teatros")
@WebInitParam(name="cidade", value = "Todos")
public class TeatrosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Teatro> teatros = TeatroDAO.getAll();
        List<String> cidades = new ArrayList<>();
        teatros.forEach(teatro -> {cidades.add(teatro.getCidade());});
        request.setAttribute("cidades", cidades);
        request.setAttribute("teatros", teatros);
        request.getRequestDispatcher("/teatros.jsp").forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teatro> teatros = TeatroDAO.getAll();
        String cidade = request.getParameter("cidade");
        List<String> cidades = new ArrayList<>();

        teatros.forEach(teatro -> {cidades.add(teatro.getCidade());});
        if(!cidade.isEmpty() && !cidade.equals("Todas")) {
            teatros = TeatroDAO.getAllFromCidade(cidade);
        }

        request.setAttribute("teatros", teatros);
        request.setAttribute("cidades", cidades);

        request.getRequestDispatcher("/teatros.jsp").forward(request, response);
    }
}
