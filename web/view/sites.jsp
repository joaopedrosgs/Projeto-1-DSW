<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
                        Sites de vendas
                    </h1>


                </div>
            </div>
        </section>
        <section class="section">
            <div class="container">
                <%@ include file="../includes/message.jsp" %>
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