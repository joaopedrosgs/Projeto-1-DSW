import org.dsw.control.Permissoes;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "NotLoggedInFilter", urlPatterns = {"/login", "/cadastro"})
public class NotLoggedInFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();

        if (session.getAttribute("user_id") != null) {
            response.sendRedirect("/painel");
            return;
        }

        chain.doFilter(req, resp);


    }
    public void init(FilterConfig config) throws ServletException {

    }

}
