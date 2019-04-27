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
    <%@ include file="../includes/head.jsp" %>
</head>

<body>
    <%@ include file="../includes/navbar.jsp" %>
    <section class="section">
        <div class="container">
            <%@ include file="../includes/message.jsp" %>

            <div class="columns">
                <div class="column has-text-centered">
                    <i class="fas fa-8x fa-ticket-alt"></i>
                    <a href="/ingresso/list" class="button is-large is-fullwidth">
                        <fmt:message key="index.ingressos"></fmt:message>
                    </a>
                </div>
                <div class="column has-text-centered">
                    <i class="fas fa-8x fa-theater-masks"></i>
                    <a href="/teatro/list" class="button is-large is-fullwidth">
                        <fmt:message key="index.teatros"></fmt:message>
                    </a>
                </div>
                <c:if test="${sessionScope.is_admin != null && sessionScope.is_admin == true}">
                <div class="column has-text-centered">
                    <i class="fas fa-8x fa-globe"></i>
                    <a href="/site/list" class="button is-large is-fullwidth">
                        <fmt:message key="index.sites"></fmt:message>
                    </a>
                </div>
                </c:if>
            </div>
        </div>


    </section>
    <%@ include file="../includes/footer.jsp" %>

</body>

</html>
