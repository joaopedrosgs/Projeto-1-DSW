<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="i18n"/>


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
                        <fmt:message key="sites.sites_de_vendas"/>
                    </h1>


                </div>
            </div>
        </section>
        <section class="section">
            <div class="container">
                <%@ include file="../includes/message.jsp" %>


                <div class="field">
                    <c:if test="${sessionScope.user_id != null}">

                        <div class="control is-fullwidth">
                            <a href="/site/update" class="button is-primary is-fullwidth">
                                <span>
                                    <fmt:message key="sites.criar_novo_site"/>
                                </span>
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
                    <jsp:useBean id="sites" scope="request" type="java.util.List<org.dsw.model.Teatro>"/>
                    <c:forEach var="site" items="${sites}">
                        <c:set var="currentSite" value="${site}" scope="request"/>
                        <jsp:include page="../includes/card_site.jsp"/>
                    </c:forEach>


                </div>
            </div>
        </section>
        <%@ include file="../includes/footer.jsp" %>
    </body>

</html>