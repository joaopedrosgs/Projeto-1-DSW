<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section>
    <nav class="navbar  is-primary " role="navigation" aria-label="main navigation">
        <div class="container">
            <div class="navbar-brand">
                <span class="navbar-item">
                    <span class="icon">
                        <i class="fas fa-2x fa-money-bill-wave"></i></span>
                </span>
                <span class="navbar-burger burger" data-target="navbarMenuHeroC">
                    <span></span>
                    <span></span>
                    <span></span>
                </span>
            </div>
            <div id="navbarMenuHeroC" class="navbar-menu">
                <div class="navbar-end">
                    <a class="navbar-item" href="/">
                        <span class="icon">
                            <i class="fas fa-home"></i>
                        </span>
                        <span>
                            Inicio
                        </span>
                    </a>
                    <a class="navbar-item" href="/ingresso/list">
                        <span class="icon">
                            <i class="fas fa-ticket-alt"></i>
                        </span>
                        <span>
                            Ingressos
                        </span>
                    </a>
                    <a class="navbar-item" href="/teatro/list">
                        <span class="icon">
                            <i class="fas fa-theater-masks"></i>
                        </span>
                        <span>
                            Teatros
                        </span>
                    </a>
                    <a class="navbar-item" href="/site/list">
                        <span class="icon">
                            <i class="fas fa-globe"></i>
                        </span>
                        <span>
                            Sites
                        </span>
                    </a>
                    <c:choose>
                        <c:when test="${sessionScope.user_id == null}">
                            <a class="navbar-item" href="/usuario/login">
                                <span class="icon">
                                    <i class="fas fa-sign-in-alt"></i>
                                </span>
                                <span>
                                    Login
                                </span>
                            </a>
                        </c:when>
                        <c:when test="${sessionScope.user_id != null}">
                            <span class="navbar-item">
                                <div class="tags has-addons">
                                    <span class="tag">
                                        <c:out value="${sessionScope.user_email}" />
                                    </span>
                                    <a href="/teatro/show" class="tag is-info">Meu teatro
                                    </a>
                                </div>

                            </span>
                            <a class="navbar-item" href="/usuario/logout">
                                <span class="icon">
                                    <i class="fas fa-sign-out-alt"></i>
                                </span>
                                <span>
                                    Logout
                                </span>
                            </a>
                        </c:when>
                    </c:choose>

                </div>
            </div>
        </div>
    </nav>
</section>