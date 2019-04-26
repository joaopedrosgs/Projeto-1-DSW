<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 19/04/19
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="i18n"/>

<html>

<head>
    <%@ include file="../includes/head.html" %>
</head>

<body>
    <%@ include file="../includes/navbar.jsp" %>
    <section class="section">
        <div class="container">
            <div class="columns">
                <div class="column has-text-centered">
                    <i class="fas fa-8x fa-ticket-alt"></i>
                    <a href="/ingresso/list" class="button is-large is-fullwidth">Ingressos</a>
                </div>
                <div class="column has-text-centered">
                    <i class="fas fa-8x fa-theater-masks"></i>
                    <a href="/teatro/list" class="button is-large is-fullwidth">Teatros</a>
                </div>
                <div class="column has-text-centered">
                    <i class="fas fa-8x fa-theater-masks"></i>
                    <a href="/site/list" class="button is-large is-fullwidth">Sites</a>
                </div>
            </div>
        </div>


    </section>
    <%@ include file="../includes/footer.html" %>

</body>

</html>
