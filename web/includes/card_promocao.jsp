<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div
    class="column is-three-quarters-mobile is-two-thirds-tablet is-half-desktop is-one-third-widescreen is-one-quarter-fullhd">
    <div class="card">
        <header class="card-header">
            <p class="card-header-title">
                ${currentPromocao.nome}
            </p>

        </header>
        <div class="card-content">
            <div class="content">
                <div class="tags has-addons">
                    <span class="tag is-light has-text-weight-semibold">Teatro</span>
                    <span class="tag">${currentPromocao.teatroName}</span>
                </div>
                <div class="tags has-addons">
                    <span class="tag is-light has-text-weight-semibold">Data</span>
                    <span class="tag">
                        <fmt:formatDate value="${currentPromocao.diaHorario}" pattern="HH:mm - dd/MM/yyyy" /></span>
                </div>
                <div class="tags has-addons">
                    <span class="tag is-light has-text-weight-semibold">Site</span>
                    <span class="tag">${currentPromocao.siteName}</span>
                </div>
            </div>
        </div>
        <footer class="card-footer">
            <span class="card-footer-item">
                <span class="tag is-medium">
                    <fmt:formatNumber value="${currentPromocao.preco}" type="currency" />
                </span>
            </span>
            <a href="#" class="card-footer-item">
                <span class="tag is-success is-medium">
                    Comprar
                </span>
            </a>

        </footer>
    </div>
</div>