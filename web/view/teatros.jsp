<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>

    <head>
        <%@ include file="../includes/head.html" %>
    </head>

    <body>
        <%@ include file="../includes/navbar.jsp" %>
        <section class="hero  is-primary ">
            <!-- Hero content: will be in the middle -->
            <div class=" hero-body">
                <div class="container has-text-centered">
                    <h1 class="title">
                        Teatros
                    </h1>


                </div>
            </div>
        </section>
        <section class="section">
            <div class="container">
                <%@ include file="../includes/message.jsp" %>
                <div class="field is-grouped">
                    <div class="control is-expanded">
                        <div class="select is-fullwidth">
                            <form method="post">
                                <select name='cidade' onchange='if(this.value != 0) { this.form.submit(); }'>
                                    <jsp:useBean id="cidades" scope="request" type="java.util.List<java.lang.String>"/>
                                    <option value="" disabled selected>Selecione uma cidade</option>
                                    <option>Todas</option>
                                    <c:forEach var="cidade" items="${cidades}">
                                        <option>${cidade}</option>
                                    </c:forEach>
                                </select>
                            </form>
                        </div>
                    </div>
                    <c:if test="${sessionScope.user_id != null}">

                    <div class="control">
                        <a href="/teatro/update" class="button is-primary"><span>Criar novo teatro</span> <span
                                class="icon is-small">
      <i class="fas fa-plus"></i>
    </span></a>
                    </div>
                    </c:if>
                </div>
            </div>
        </section>
        <section>

            <div class="container">
                <div class="columns is-3 is-multiline">
                    <jsp:useBean id="teatros" scope="request" type="java.util.List<org.dsw.model.Teatro>"/>
                    <c:forEach var="teatro" items="${teatros}">
                        <c:set var="currentTeatro" value="${teatro}" scope="request"/>
                        <jsp:include page="../includes/card_teatro.jsp"/>
                    </c:forEach>


                </div>
            </div>
        </section>
        <%@ include file="../includes/footer.html" %>
    </body>

</html>