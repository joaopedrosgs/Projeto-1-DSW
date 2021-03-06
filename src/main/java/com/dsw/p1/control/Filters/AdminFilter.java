package com.dsw.p1.control.Filters;

import com.dsw.p1.control.Permissoes;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter", urlPatterns = {"/site/update", "/site/list", "/site/delete"})
public class AdminFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();
        if (!Permissoes.isAdminSession(session)) {
            session.removeAttribute("user_id");
            session.removeAttribute("user_email");
            session.removeAttribute("is_admin");

            response.sendRedirect("/?msg=Voce precisa ser admin para realizar essa acao");
            return;
        }
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
