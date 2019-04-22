<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<html>

<head>
    <%@ include file="includes/head.html" %>
</head>

<body>
    <%@ include file="includes/navbar.jsp" %>
    <section class="hero is-primary">
        <!-- Hero content: will be in the middle -->
        <div class=" hero-body">
            <div class="container has-text-centered">
                <h1 class="title">
                    Fazer login </h1>
            </div>
        </div>
    </section>

    <section class="section">
        <div class="container">
            <fmt:message key="label.welcome" />
            <jsp:useBean id="failed" scope="request" type="java.lang.Boolean" />
            <c:if test="${failed == true}">
                <div class="notification is-danger">
                    <button class="delete"></button>
                    Você digitou a senha ou usuário inválido, tente novamente!
                </div>
            </c:if>

            <div class="columns  is-centered is-vcentered">

                <div class="column is-narrow">
                    <form method="post" action="/login">
                        <div class="field is-horizontal">
                            <div class="field-label is-normal">
                                <label class="label">Usuário</label>
                            </div>
                            <div class="field-body">
                                <div class="field">
                                    <div class="control">
                                        <input name="email" class="input" type="email" placeholder="Login" minlength=8
                                            required>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="field is-horizontal has-addons">
                            <div class="field-label is-normal">
                                <label class="label">Senha</label>
                            </div>
                            <div class="field-body">
                                <p class="control is-expanded">
                                    <input name="senha" class="input" type="password" placeholder="senha" minlength=8
                                        required>
                                </p>
                                <div class="control">
                                    <button type="submit" class="button is-success">
                                        <i class="fas fa-arrow-right"></i>
                                    </button>
                                </div>
                            </div>

                        </div>
                    </form>

                </div>
            </div>
        </div>
        <div style="text-align: center">
            <a href="cadastro">Cadastrar</a>
        </div>
    </section>
    <%@ include file="includes/footer.html" %>
</body>

</html>