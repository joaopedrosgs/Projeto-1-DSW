<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>

    <head>
        <%@ include file="../includes/head.html" %>
    </head>

    <body>
        <%@ include file="../includes/navbar.jsp" %>
        <section class="hero is-primary">
            <!-- Hero content: will be in the middle -->
            <div class=" hero-body">
                <div class="container has-text-centered">
                    <h1 class="title">
                        Criar/Alterar promocao</h1>
                </div>
            </div>
        </section>

        <section class="section">
            <div class="container">
                <%@ include file="../includes/message.jsp" %>

                <form action="/ingresso/update" method="post">
                    <input class="input" name="id" type="hidden"
                           value="<c:out value="${promocao.id}">-1</c:out>"/>

                    <div class="field is-horizontal">
                        <div class="field-label is-normal">
                            <label class="label">Nome</label>
                        </div>
                        <div class="field-body">
                            <div class="field">
                                <p class="control is-expanded ">
                                    <input class="input" name="nome" type="text"
                                           value="<c:out value="${promocao.nome}"/>"
                                           placeholder="Nome">


                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="field is-horizontal">
                        <div class="field-label is-normal">
                            <label class="label">Preco</label>
                        </div>
                        <div class="field-body">
                            <div class="field">
                                <p class="control is-expanded">
                                    <input class="input" name="preco" type="number" min="1" step="any"
                                           value="<c:out value="${promocao.preco}"/>"
                                           placeholder="0">
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="field is-horizontal">
                        <div class="field-label is-normal">
                            <label class="label">Dia</label>
                        </div>
                        <div class="field-body">
                            <div class="field">
                                <p class="control is-expanded ">
                                    <input name="dia" class="input" type="datetime-local" placeholder="yyyy-MM-ddThh:mm" >
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="field is-horizontal">
                        <div class="field-label is-normal">
                            <label class="label">Teatro</label>
                        </div>
                        <div class="field-body">
                            <div class="select">
                                <select name='teatro_id'>
                                    <jsp:useBean id="teatros" scope="request" type="java.util.List" />
                                    <option value="" disabled selected>Selecione um teatro</option>
                                    <c:forEach var="teatro" items="${teatros}">
                                        <option value="${teatro.id}">${teatro.nome}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="field is-horizontal">
                        <div class="field-label is-normal">
                            <label class="label">Site</label>
                        </div>
                        <div class="field-body">
                            <div class="select">
                                <select name='site_id'>
                                    <jsp:useBean id="sites" scope="request" type="java.util.List" />
                                    <option value="" disabled selected>Selecione um site</option>
                                    <c:forEach var="site" items="${sites}">
                                        <option value="${site.id}">${site.nome}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>

                    <button type="submit" class="button is-primary is-fullwidth ">Enviar</button>
                </form>
            </div>
        </section>
        <%@ include file="../includes/footer.html" %>
    </body>

</html>