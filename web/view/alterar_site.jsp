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
        <section class="hero is-primary">
            <!-- Hero content: will be in the middle -->
            <div class=" hero-body">
                <div class="container has-text-centered">
                    <h1 class="title">
                        <fmt:message key="alterar_site.criar_alterar_teatro"/>
                    </h1>
                </div>
            </div>
        </section>
        <section class="section">
            <div class="container">
                <%@ include file="../includes/message.jsp" %>

                </div>

            </div>
        </section>
        <section class="section">
            <div class="container">


                <form action="/site/update" method="post">
                    <input class="input" name="id" type="hidden"
                           value="<c:out value="${teatro.id}">-1</c:out>"/>

                    <div class="field is-horizontal">
                        <div class="field-label is-normal">
                            <label class="label">
                                <fmt:message key="alterar_site.nome"/>
                            </label>
                        </div>
                        <div class="field-body">
                            <div class="field">
                                <p class="control is-expanded has-icons-left">
                                    <input class="input" name="nome" type="text"
                                           placeholder="Nome"
                                           value="<c:out value="${site.nome}"/>">
                                    <span class="icon is-small is-left">
                                    <i class="fas fa-user"></i>
                                </span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="field is-horizontal">
                        <div class="field-label is-normal">
                            <label class="label"><fmt:message key="alterar_site.url"/></label>
                        </div>
                        <div class="field-body">
                            <div class="field">
                                <p class="control is-expanded has-icons-left">
                                    <input class="input" name="url" type="text" value="<c:out value="${site.url}"/>"
                                           placeholder="www.example.com">
                                    <span class="icon is-small is-left">
                                    <i class="fas fa-user"></i>
                                </span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="field is-horizontal">
                        <div class="field-label is-normal">
                            <label class="label">
                                <fmt:message key="alterar_site.telefone"/>
                            </label>
                        </div>
                        <div class="field-body">
                            <div class="field">
                                <p class="control is-expanded has-icons-left">
                                    <input class="input" name="telefone" type="text"
                                           value="<c:out value="${site.telefone}"/>"
                                           placeholder="1111-1111">
                                    <span class="icon is-small is-left">
                                    <i class="fas fa-globe"></i>
                                </span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="button is-primary is-fullwidth ">
                        <fmt:message key="alterar_site.enviar"/>
                    </button>
                </form>
            </div>
        </section>
        <%@ include file="../includes/footer.jsp" %>
    </body>

</html>