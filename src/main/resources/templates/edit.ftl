<#import "parts/common.ftl" as c>
<#import "parts/navbar.ftl" as n>

<@c.page>
    <div class="row">
            <@n.navbar "/navbar" />

        <div class="col-sm-8 col-md-6">


            <br>
            <h5>Редактировать статью</h5>
            <form method="post" action="/editArticle">
                <div class="input-group mb-3">
                    <input type="hidden" class="form-control" name="id"
                           value="${message.id}">
                    <input type="content" class="form-control" name="content"
                           value="${message.content}">
                    <input type="title" class="form-control" name="title"
                           value="${message.title}">
                    <input type="slug" class="form-control" name="slug"
                           value="${message.slug}">

                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <div class="input-group-append">
                        <button class="btn btn-dark" type="submit">Сохранить</button>
                    </div>

                </div>
            </form>
            <br>
            <br>

        </div><!--End col-sm-md-->
    </div><!--End row-->
</@c.page>