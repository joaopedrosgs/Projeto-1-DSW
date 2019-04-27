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
                    <fmt:message key="login.fazer_login"/>
                </h1>
            </div>
        </div>
    </section>

    <section class="section">
        <div class="container">
            <%@ include file="../includes/message.jsp" %>
            <div class="columns  is-centered is-vcentered">

                <div class="column is-narrow">
                    <form method="post" action="/usuario/login">
                        <div class="field is-horizontal">
                            <div class="field-label is-normal">
                                <label class="label">
                                    <fmt:message key="login.usuario"/>
                                </label>
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
                                <label class="label">
                                    <fmt:message key="login.senha"/>
                                </label>
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
            <a href="/usuario/create">
                <fmt:message key="login.cadastrar"/>
            </a>
        </div>
    </section>
    <%@ include file="../includes/footer.jsp" %>
</body>

</html>