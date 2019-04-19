<%--
  Created by IntelliJ IDEA.
  User: bortinho
  Date: 15/04/19
  Time: 06:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hello Bulma!</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.4/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>
<section>
    <!-- Hero head: will stick at the top -->
    <nav class="navbar is-success" role="navigation" aria-label="main navigation">
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

                    <a class="navbar-item is-active" href="index.html">
                                <span class="icon">
                                    <i class="fas fa-home"></i>
                                </span>
                        <span>
                                    Inicio
                                </span>
                    </a>
                    <a class="navbar-item" href="login.html">
                                <span class="icon">
                                    <i class="fas fa-sign-in-alt"></i>
                                </span>
                        <span>
                                    Login
                                </span>
                    </a>
                    <a class="navbar-item" href="admin.html">
                                <span class="icon">
                                    <i class="fas fa-sign-in-alt"></i>
                                </span>
                        <span>
                                    Painel
                                </span>
                    </a>

                    <div class="navbar-item  has-dropdown is-hoverable">
                        <a class="navbar-link">
                            <div class="button is-light">
                                Português
                            </div>
                        </a>

                        <div class="navbar-dropdown">
                            <a class="navbar-item">
                                Português
                            </a>
                            <a class="navbar-item">
                                Ingles
                            </a>


                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</section>
<section class="hero is-success">
    <!-- Hero content: will be in the middle -->
    <div class=" hero-body">
        <div class="container has-text-centered">
            <h1 class="title">
                Promoções
            </h1>
            <h2 class="subtitle">
                Ingressos
            </h2>

        </div>
    </div>
</section>
<section class="hero is-success">
    <!-- Hero footer: will stick at the bottom -->
    <div class="hero-foot">
        <nav class="tabs is-boxed is-fullwidth">
            <div class="container">
                <ul>
                    <li class="is-active"><a>Por teatro</a></li>
                    <li><a>Por site</a></li>
                    <li><a>Por cidade</a></li>
                </ul>
            </div>
        </nav>
    </div>
</section>
<section class="section">
    <div class="container">
        <div class="control">
            <div class="select is-fullwidth">
                <select>
                    <option>Teatro 1</option>
                    <option>Teatro 2</option>
                </select>
            </div>
        </div>
    </div>
</section>
<section>

    <div class="container">
        <div class="columns is-3 is-multiline">
            <jsp:useBean id="promocoes" scope="request" type="java.util.List<org.dsw.model.Promocao>"/>
            <c:forEach var="promocao" items="${promocoes}">
                <div class="column is-three-quarters-mobile is-two-thirds-tablet is-half-desktop is-one-third-widescreen is-one-quarter-fullhd">
                    <div class="card">
                        <header class="card-header">
                            <p class="card-header-title">
                                    ${promocao.nome}
                            </p>

                        </header>
                        <div class="card-content">
                            <div class="content">
                                <div class="tags has-addons">
                                    <span class="tag is-light has-text-weight-semibold">Teatro</span>
                                    <span class="tag">${promocao.teatroName}</span>
                                </div>
                                <div class="tags has-addons">
                                    <span class="tag is-light has-text-weight-semibold">Data</span>
                                    <span class="tag"><fmt:formatDate value="${promocao.diaHorario}"
                                                                                 pattern="HH:mm - dd/MM/yyyy"/></span>
                                </div>
                            </div>
                        </div>
                        <footer class="card-footer">

                        <span class="card-footer-item">
                            <span class="tag is-medium">
                                <fmt:formatNumber value="${promocao.preco}" type="currency"/>
                            </span>
                        </span>
                            <a href="#" class="card-footer-item">
                                <span class="tag is-success is-medium">
                               Comprar
                            </span>
                            </a>

                        </footer>
                    </div>
                </div>
            </c:forEach>


        </div>
    </div>
</section>
<footer class="footer">
    <div class="content has-text-centered">
        <p>
            <strong>Promoções de ingressos</strong>
        </p>
        Trabalho 1 da disciplina de Desenvolvimento de Software para Web

    </div>
</footer>
</body>
</html>

