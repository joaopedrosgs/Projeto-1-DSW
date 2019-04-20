<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div
    class="column is-three-quarters-mobile is-two-thirds-tablet is-half-desktop is-one-third-widescreen is-one-quarter-fullhd">
    <div class="card">
        <header class="card-header">
            <p class="card-header-title">
                ${currentTeatro.nome}
            </p>

        </header>
        <div class="card-content">
            <div class="content">
                <div class="tags has-addons">
                    <span class="tag is-light has-text-weight-semibold">Cidade</span>
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
                <form action="<%=request.getContextPath()%>/ingressos/por-teatro" method="post">
                    <input type="text" name="escolha" value="${currentTeatro.id}" hidden>

                    <button class="button is-success is-medium" type="submit">Ver Promo��es</button>
                </form>
            </a>

        </footer>
    </div>
</div>