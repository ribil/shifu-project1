<#import "parts/common.ftl" as c>
<#import "parts/navbar.ftl" as n>

<@c.page>
    <div class="row">
            <@n.navbar "/navbar" />

        <div class="col-sm-8 col-md-6">


            <br>
            <h5>Редактировать статью</h5>
            <form method="post" action="edit">
                <div class="input-group mb-3">

                    <input type="content" class="form-control" name="content"
                           value="${message.content}" aria-describedby="basic-addon2">
                    <input type="title" class="form-control" name="title"
                           value="${message.title}" aria-describedby="basic-addon2">
                    <input type="slug" class="form-control" name="slug"
                           value="${message.slug}" aria-describedby="basic-addon2">
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