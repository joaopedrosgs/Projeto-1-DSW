<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>

    <head>
        <%@ include file="../includes/head.jsp" %>
    </head>

    <body>
        <%@ include file="../includes/navbar.jsp" %>
        <section class="hero  is-primary ">
            <!-- Hero content: will be in the middle -->
            <div class=" hero-body">
                <div class="container has-text-centered">
                    <h1 class="title">
                        <fmt:message key="ingressos.promocoes"/>
                    </h1>
                    <h2 class="subtitle">
                        <fmt:message key="ingressos.ingressos"/>
                    </h2>

                </div>
            </div>
        </section>
        <section class="hero is-primary">
            <!-- Hero footer: will stick at the bottom -->
            <div class="hero-foot">
                <nav class="tabs is-boxed is-fullwidth">
                    <div class="container">
                        <ul>
                            <jsp:useBean id="por" scope="request" type="java.lang.String"/>
                            <li class="${por==" teatro" ? 'is-active' : '' }">
                                <a href="/ingresso/por-teatro">
                                    <fmt:message key="ingressos.por_teatro"/>
                                </a>
                            </li>
                            <li class="${por==" site" ? 'is-active' : '' }">
                                <a href="/ingresso/por-site">
                                    <fmt:message key="ingressos.por_site"/>
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </section>
        <section class="section">
            <div class="container">
                <%@ include file="../includes/message.jsp" %>


                <div class="field is-grouped">
                    <div class="control is-expanded">
                        <div class="select is-fullwidth">
                            <form method="post">
                                <select class="select is-fullwidth" name='escolha'
                                        onchange='if(this.value != 0) { this.form.submit(); }'>
                                    <jsp:useBean id="escolhas" scope="request" type="java.util.List"/>
                                    <option value="" disabled selected>
                                        <fmt:message key="ingressos.selecione_uma"/>
                                    </option>
                                    <option value="Todas">
                                        <fmt:message key="ingressos.todos"/>
                                    </option>

                                    <c:forEach var="escolha" items="${escolhas}">
                                        <option value="${escolha.id}">${escolha.nome}</option>
                                    </c:forEach>
                                </select>
                            </form>
                        </div>
                    </div>
                    <c:if test="${sessionScope.user_id != null}">

                        <div class="control">
                            <a href="/ingresso/update" class="button is-primary">
                                <span><fmt:message key="ingressos.criar_nova_promocao"/></span>
                                <span class="icon is-small">
                                    <i class="fas fa-plus"></i>
                                </span>
                            </a>
                        </div>
                    </c:if>

                </div>

            </div>
        </section>
        <section>

            <div class="container">
                <div class="columns is-3 is-multiline">
                    <jsp:useBean id="promocoes" scope="request" type="java.util.List<com.dsw.p1.model.Promocao>"/>
                    <c:forEach var="promocao" items="${promocoes}">
                        <c:set var="currentPromocao" value="${promocao}" scope="request"/>
                        <jsp:include page="../includes/card_promocao.jsp"/>
                    </c:forEach>


                </div>
            </div>
        </section>
        <%@ include file="../includes/footer.jsp" %>
    </body>

</html>