<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="i18n"/>


<div
    class="column is-three-quarters-mobile is-two-thirds-tablet is-half-desktop is-one-third-widescreen is-one-quarter-fullhd">
    <div class="card">
        <header class="card-header">
            <p class="card-header-title">
                <c:if test="${sessionScope.user_id != null && sessionScope.user_id == currentTeatro.id}">

            <span class="tag is-white ">
    <span class="icon">
      <i class="fas fa-star"></i>
    </span>
                <span>
                    <fmt:message key="card_teatro.seu_teatro"/>
                </span>
            </span>
                </c:if>
                <span>${currentTeatro.nome}</span>


            </p>

        </header>
        <div class="card-content">
            <div class="content">
                <div class="tags has-addons">
                    <span class="tag is-light has-text-weight-semibold">
                        <fmt:message key="card_teatro.cidade"/>
                    </span>
                    <span class="tag">${currentTeatro.cidade}</span>
                </div>
                <div class="tags has-addons">
                    <span class="tag is-light has-text-weight-semibold">CPNJ</span>
                    <span class="tag">${currentTeatro.CNPJ}</span>
                </div>
            </div>
        </div>
        <footer class="card-footer">

            <a class="card-footer-item">
                <form action="/ingresso/por-teatro" method="post">

                <input type="text" name="escolha" value="${currentTeatro.id}" hidden>

                    <button class="button is-success" type="submit">
                        <fmt:message key="card_teatro.promocoes"/>
                    </button>
                </form>

            </a>


            <c:if test="${sessionScope.user_id == currentTeatro.id || sessionScope.is_admin}">
                    <a href="/teatro/update?id=${currentTeatro.id}" class="card-footer-item">
                <span class="tag is-info is-medium">
                    <fmt:message key="card_teatro.editar"/>
                </span>
                    </a>
                    <a href="/teatro/delete?id=${currentTeatro.id}" class="card-footer-item">
                <span class="tag is-danger is-medium">
                    <fmt:message key="card_teatro.deletar"/>
                </span>
                    </a>
                </c:if>

        </footer>
    </div>
</div>