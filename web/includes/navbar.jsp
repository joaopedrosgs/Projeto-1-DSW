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
                            <fmt:message key="navbar.inicio"/>
                        </span>
                    </a>
                    <a class="navbar-item" href="/ingresso/list">
                        <span class="icon">
                            <i class="fas fa-ticket-alt"></i>
                        </span>
                        <span>
                            <fmt:message key="navbar.ingressos"/>
                        </span>
                    </a>
                    <a class="navbar-item" href="/teatro/list">
                        <span class="icon">
                            <i class="fas fa-theater-masks"></i>
                        </span>
                        <span>
                            <fmt:message key="navbar.teatros"/>
                        </span>
                    </a>
                    <c:if test="${sessionScope.is_admin != null && sessionScope.is_admin == true}">

                    <a class="navbar-item" href="/site/list">
                        <span class="icon">
                            <i class="fas fa-globe"></i>
                        </span>
                        <span>
                            <fmt:message key="navbar.sites"/>
                        </span>
                    </a>
                    </c:if>
                    <c:choose>
                        <c:when test="${sessionScope.user_id == null}">
                            <a class="navbar-item" href="/usuario/login">
                                <span class="icon">
                                    <i class="fas fa-sign-in-alt"></i>
                                </span>
                                <span>
                                    <fmt:message key="navbar.login"/>
                                </span>
                            </a>
                        </c:when>
                        <c:when test="${sessionScope.user_id != null}">
                            <span class="navbar-item">
                                <div class="tags has-addons">
                                    <span class="tag">
                                        <c:out value="${sessionScope.user_email}" />
                                    </span>
                                    <a href="/teatro/show" class="tag is-info">
                                        <fmt:message key="navbar.meu_teatro"/>
                                    </a>
                                </div>

                            </span>
                            <a class="navbar-item" href="/usuario/logout">
                                <span class="icon">
                                    <i class="fas fa-sign-out-alt"></i>
                                </span>
                                <span>
                                    <fmt:message key="navbar.logout"/>
                                </span>
                            </a>
                        </c:when>
                    </c:choose>

                </div>
            </div>
        </div>
    </nav>
</section>