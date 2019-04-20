<%--
  Created by IntelliJ IDEA.
  User: bortinho
  Date: 15/04/19
  Time: 06:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <%@ include file="includes/head.html" %>
</head>
<body>
<%@ include file="includes/navbar.html" %>
<section class="hero  is-primary ">
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
<section class="hero is-primary">
    <!-- Hero footer: will stick at the bottom -->
    <div class="hero-foot">
        <nav class="tabs is-boxed is-fullwidth">
            <div class="container">
                <ul>
                    <jsp:useBean id="por" scope="request" type="java.lang.String"/>
                    <li class="${por=="teatro" ? 'is-active' : ''}"><a href="<%=request.getContextPath()%>/ingressos/por-teatro">Por teatro</a></li>
                    <li class="${por=="site" ? 'is-active' : ''}"><a href="<%=request.getContextPath()%>/ingressos/por-site">Por site</a></li>
                </ul>
            </div>
        </nav>
    </div>
</section>
<section class="section">
    <div class="container">
        <div class="control">
            <div class="select is-fullwidth">
                <form method="post">
                    <select name='escolha' onchange='if(this.value != 0) { this.form.submit(); }'>
                        <jsp:useBean id="escolhas" scope="request" type="java.util.List"/>
                        <option value="" disabled selected>Selecione um ${por}</option>
                        <option value="Todas" >Todos</option>

                        <c:forEach var="escolha" items="${escolhas}">
                            <option value="${escolha.id}">${escolha.nome}</option>
                        </c:forEach>
                    </select>
                </form>
            </div>
        </div>
    </div>
</section>
<section>

    <div class="container">
        <div class="columns is-3 is-multiline">
            <jsp:useBean id="promocoes" scope="request" type="java.util.List<org.dsw.model.Promocao>"/>
            <c:forEach var="promocao" items="${promocoes}">
                <c:set var="currentPromocao" value="${promocao}" scope="request" />
                <jsp:include page="includes/card_promocao.jsp" />
            </c:forEach>


        </div>
    </div>
</section>
<%@ include file="includes/footer.html" %>
</body>
</html>

