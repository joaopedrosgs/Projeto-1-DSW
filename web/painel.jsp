<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>

<head>
    <%@ include file="includes/head.html" %>
</head>

<body>
    <%@ include file="includes/navbar.jsp" %>

    <section class="hero is-primary">
        <!-- Hero content: will be in the middle -->
        <div class=" hero-body">
            <div class="container has-text-centered">
                <h1 class="title">
                    Painel de administrador </h1>
            </div>
        </div>
    </section>

    <section class="section">
        <div class="container">
            <div class="columns">
                <div class="column is-one-quarter">
                    <aside class="menu">
                        <p class="menu-label">
                            Sites
                        </p>
                        <ul class="menu-list">
                            <li><a>Adicionar</a></li>
                            <li><a>Listar</a></li>
                        </ul>
                        <p class="menu-label">
                            Teatros
                        </p>
                        <ul class="menu-list">
                            <li><a>Adicionar</a></li>
                            <li><a>Listar</a></li>
                        </ul>

                        <p class="menu-label">
                            Promoções
                        </p>
                        <ul class="menu-list">
                            <li><a>Adicionar</a></li>
                            <li><a>Listas</a></li>
                        </ul>

                    </aside>
                </div>
                <div class="column is-three-quarters">
                    <table class="table is-fullwidth">
                        <thead>
                            <tr>
                                <th><abbr title="Id">Id</abbr></th>
                                <th>Nome</th>
                                <th><abbr title="Endereço">End</abbr></th>
                                <th>CNPJ</th>
                                <th>Preço</th>
                                <th>Dia</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Nome qualquer</td>
                                <td>Endereço</td>
                                <td>123123123123</td>
                                <td>123</td>
                                <td>21/02</td>
                                <td>Acoes</td>

                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Nome qualquer</td>
                                <td>Endereço</td>
                                <td>123123123123</td>
                                <td>123</td>
                                <td>21/02</td>
                                <td>Acoes</td>

                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Nome qualquer</td>
                                <td>Endereço</td>
                                <td>123123123123</td>
                                <td>123</td>
                                <td>21/02</td>
                                <td>Acoes</td>

                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Nome qualquer</td>
                                <td>Endereço</td>
                                <td>123123123123</td>
                                <td>123</td>
                                <td>21/02</td>
                                <td>Acoes</td>

                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Nome qualquer</td>
                                <td>Endereço</td>
                                <td>123123123123</td>
                                <td>123</td>
                                <td>21/02</td>
                                <td>Acoes</td>

                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Nome qualquer</td>
                                <td>Endereço</td>
                                <td>123123123123</td>
                                <td>123</td>
                                <td>21/02</td>
                                <td>Acoes</td>

                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Nome qualquer</td>
                                <td>Endereço</td>
                                <td>123123123123</td>
                                <td>123</td>
                                <td>21/02</td>
                                <td>Acoes</td>

                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Nome qualquer</td>
                                <td>Endereço</td>
                                <td>123123123123</td>
                                <td>123</td>
                                <td>21/02</td>
                                <td>Acoes</td>

                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Nome qualquer</td>
                                <td>Endereço</td>
                                <td>123123123123</td>
                                <td>123</td>
                                <td>21/02</td>
                                <td>Acoes</td>

                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Nome qualquer</td>
                                <td>Endereço</td>
                                <td>123123123123</td>
                                <td>123</td>
                                <td>21/02</th>
                                <th>Acoes</th>

                            </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>

    <%@ include file="includes/footer.html" %>
</body>

</html>