<#macro navbar path>
<div class="col-sm-12">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/"><#--Project 1--></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/">Главная</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/articles">Статьи</a>
            </li>
        </ul>
    </div>
</nav>
</div>
</#macro>