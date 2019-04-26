package org.dsw.control.Filters;

import org.dsw.control.Permissoes;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "IsLoggedInFilter", urlPatterns={"/ingresso/por-site","/site/delete", "/site/update", "/ingresso/delete", "/ingresso/update", "/teatro/delete", "/teatro/update"})
public class IsLoggedInFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();
        if (!Permissoes.userExists(session)) {
            session.removeAttribute("user_id");
            session.removeAttribute("user_email");
            session.removeAttribute("is_admin");
            response.sendRedirect("/usuario/login?msg=Voce precisa estar logado para realizar essa acao");
            return;
        }
        chain.doFilter(req, resp);


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
