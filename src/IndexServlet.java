import org.dsw.dao.PromocaoDAO;
import org.dsw.model.Promocao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = "/")
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       PromocaoDAO.create(new Promocao(1,1,"teste", 2f, new java.util.Date()));
        List<Promocao> promocoes = PromocaoDAO.getAll();
        request.setAttribute("promocoes", promocoes);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
