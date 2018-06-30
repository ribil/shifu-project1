<#import "parts/common.ftl" as c>
<#import "parts/navbar.ftl" as n>
<#import "parts/login.ftl" as l>

<@c.page>
    <div class="row">
           <@n.navbar "/navbar" />


        <div class="col-sm-8 col-md-6">
    <p><@l.logout /></p>



       <#-- <div class="col-sm-8 col-md-6">
            <form action="/logout" method="post">
                <input type="submit" value="Sign Out"/>
            </form>-->
            <br>
            <h5>Все статьи</h5>
            <ul class="list-group">

                <#list messages as message>
                    <li class="list-group-item"><a href="/admin/articles/${message.slug}">${message.title}</a>
                    </li>
                <#else>
                    <p>Список пуст</p>
                </#list>
            </ul>
        </div><!--End col-sm-md-->
    </div><!--End row-->
</@c.page>