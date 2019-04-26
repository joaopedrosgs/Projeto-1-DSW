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
                        Criar/Alterar teatro</h1>
                </div>
            </div>
        </section>

        <section class="section">
            <div class="container">
                <%@ include file="../includes/message.jsp" %>

                <form action="/teatro/update" method="post">
                    <input class="input" name="id" type="hidden"
                           value="<c:out value="${teatro.id}">-1</c:out>"/>

                    <div class="field is-horizontal">
                        <div class="field-label is-normal">
                            <label class="label">Nome</label>
                        </div>
                        <div class="field-body">
                            <div class="field">
                                <p class="control is-expanded has-icons-left">
                                    <input class="input" name="nome" type="text"
                                           placeholder="Nome"
                                    value="<c:out value="${teatro.nome}"/>">
                                    <span class="icon is-small is-left">
                                    <i class="fas fa-user"></i>
                                </span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="field is-horizontal">
                        <div class="field-label is-normal">
                            <label class="label">CPNJ</label>
                        </div>
                        <div class="field-body">
                            <div class="field">
                                <p class="control is-expanded has-icons-left">
                                    <input class="input" name="cnpj" type="text" value="<c:out value="${teatro.CNPJ}"/>"
                                           placeholder="CNPJ">
                                    <span class="icon is-small is-left">
                                    <i class="fas fa-user"></i>
                                </span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="field is-horizontal">
                        <div class="field-label is-normal">
                            <label class="label">Cidade</label>
                        </div>
                        <div class="field-body">
                            <div class="field">
                                <p class="control is-expanded has-icons-left">
                                    <input class="input" name="cidade" type="text"
                                           value="<c:out value="${teatro.cidade}"/>"
                                    placeholder="Cidade">
                                    <span class="icon is-small is-left">
                                    <i class="fas fa-globe"></i>
                                </span>
                                </p>
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