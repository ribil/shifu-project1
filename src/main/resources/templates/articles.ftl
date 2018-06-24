<#import "parts/common.ftl" as c>
<#import "parts/navbar.ftl" as n>

<@c.page>
    <div class="row">
            <@n.navbar "/navbar" />

        <div class="col-sm-8 col-md-6">

            <br>
            <br>
            <a class="btn btn-primary" href="/admin/articles/add" role="button">Добавить статью</a>
            <br>
            <br>
            <h5>Все статьи</h5>
            <ul class="list-group">

                <#list messages as message>
                    <li class="list-group-item">${message.content}, ${message.title}, ${message.slug}
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="btn btn-danger btn-sm" href="/delete/${message.slug}"
                           role="button">Удалить</a>
                        <a class="btn btn-primary btn-sm" href="/admin/articles/edit/${message.id}"
                           role="button">Редактировать</a>
                        <a class="btn btn-success btn-sm" href="/admin/articles/${message.slug}">Просмотреть</a>

                    </li>
                <#else>
                    <p>No content</p>
                </#list>
            </ul>
            <br>
            <br>

        </div><!--End col-sm-md-->
    </div><!--End row-->
</@c.page>