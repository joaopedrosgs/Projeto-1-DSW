<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div
        class="column is-three-quarters-mobile is-two-thirds-tablet is-half-desktop is-one-third-widescreen is-one-quarter-fullhd">
    <div class="card">
        <header class="card-header">
            <p class="card-header-title">
                <c:if test="${sessionScope.user_id != null && sessionScope.user_id == currentSite.id}">

            <span class="tag is-white ">
    <span class="icon">
      <i class="fas fa-star"></i>
    </span>
                <span>
                    <fmt:message key="card_site.seu_site"/>
                </span>
            </span>
                </c:if>
                <span>${currentSite.nome}</span>


            </p>

        </header>
        <div class="card-content">
            <div class="content">
                <div class="tags has-addons">
                    <span class="tag is-light has-text-weight-semibold">
                        <fmt:message key="card_site.nome"/>
                    </span>
                    <span class="tag">${currentSite.nome}</span>
                </div>
                <div class="tags has-addons">
                    <span class="tag is-light has-text-weight-semibold">
                        <fmt:message key="card_site.url"/>
                    </span>
                    <a href="${currentSite.url}" class="tag">${currentSite.url}</a>
                </div>
                <div class="tags has-addons">
                    <span class="tag is-light has-text-weight-semibold">
                        <fmt:message key="card_site.telefone"/>
                    </span>
                    <span class="tag">${currentSite.telefone}</span>
                </div>


            </div>
        </div>
        <footer class="card-footer">

            <a class="card-footer-item">
                <form action="/ingresso/por-site" method="post">

                    <input type="text" name="escolha" value="${currentSite.id}" hidden>

                    <button class="button is-success" type="submit">
                        <fmt:message key="card_site.promocoes"/>
                    </button>
                </form>

            </a>

            <c:if test="${sessionScope.user_id == currentSite.id || sessionScope.is_admin}">
                <a href="/site/update?id=${currentSite.id}" class="card-footer-item">
                <span class="tag is-info is-medium">
                    <fmt:message key="card_site.editar"/>
                </span>
                </a>
                <a href="/site/delete?id=${currentSite.id}" class="card-footer-item">
                <span class="tag is-danger is-medium">
                    <fmt:message key="card_site.deletar"/>
                </span>
                </a>
            </c:if>

        </footer>
    </div>
</div>