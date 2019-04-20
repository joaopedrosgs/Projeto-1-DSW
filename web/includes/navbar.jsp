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
                    <a class="navbar-item" href="/ingressos">
                        <span class="icon">
                            <i class="fas fa-ticket-alt"></i>
                        </span>
                        <span>
                            Ingressos
                        </span>
                    </a>
                    <a class="navbar-item" href="/teatros">
                        <span class="icon">
                            <i class="fas fa-theater-masks"></i>
                        </span>
                        <span>
                            Teatros
                        </span>
                    </a>
                    <c:choose>
                        <c:when test="${sessionScope.user_id == null}">
                            <a class="navbar-item" href="/login">
                                <span class="icon">
                                    <i class="fas fa-sign-in-alt"></i>
                                </span>
                                <span>
                                    Login
                                </span>
                            </a>
                        </c:when>
                        <c:when test="${sessionScope.user_id != null}">
                            <a class="navbar-item" href="/painel">
                                <span class="icon">
                                    <i class="fas fa-sign-in-alt"></i>
                                </span>
                                <span>
                                    Painel
                                </span>
                            </a>
                            <span class="navbar-item">
                                <div class="tags has-addons">
                                    <span class="tag">
                                        <c:out value="${sessionScope.user_email}" />
                                    </span>
                                    <span class="tag is-info"> <i class="fas fa-user"></i>
                                    </span>
                                </div>

                            </span>
                        </c:when>
                    </c:choose>

                </div>
            </div>
        </div>
    </nav>
</section>