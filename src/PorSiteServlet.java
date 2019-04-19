import org.dsw.dao.PromocaoDAO;
import org.dsw.dao.SiteVendasDAO;
import org.dsw.model.Promocao;
import org.dsw.model.SiteVendas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PorSiteServlet", urlPatterns = "/ingressos/por-site")
@WebInitParam(name = "escolha", value = "Todos")
public class PorSiteServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Promocao> promocoes;
        List<SiteVendas> sites = SiteVendasDAO.getAll();

        promocoes = PromocaoDAO.getAll();

        request.setAttribute("escolhas", sites);
        request.setAttribute("promocoes", promocoes);
        request.setAttribute("por", "site");

        request.getRequestDispatcher("/ingressos.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Promocao> promocoes = null;
        String siteIdString = request.getParameter("escolha");
        List<SiteVendas> sites = SiteVendasDAO.getAll();


        int siteId = -1;
        if (!siteIdString.isEmpty()) {
            try {
                siteId = Integer.parseInt(siteIdString);
                promocoes = PromocaoDAO.getAllFromSite(siteId);

            } catch (NumberFormatException nfe) {
                //TODO
            }
        }
        if (siteId == -1) {
            promocoes = PromocaoDAO.getAll();
        }
        request.setAttribute("escolhas", sites);
        request.setAttribute("promocoes", promocoes);
        request.setAttribute("por", "site");

        request.getRequestDispatcher("/ingressos.jsp").forward(request, response);
    }
}
