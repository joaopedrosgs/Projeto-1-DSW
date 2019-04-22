import org.dsw.control.Permissoes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PainelServlet", urlPatterns = "/painel")
public class PainelServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (!Permissoes.isAdminSession(session)) {
            session.removeAttribute("user_id");
            session.removeAttribute("user_email");
            response.sendRedirect("/login");
            return;
        }

        request.getRequestDispatcher("/painel.jsp").forward(request, response);

    }
}
