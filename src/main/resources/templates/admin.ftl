<#import "parts/common.ftl" as c>
<#import "parts/navbar.ftl" as n>

<@c.page>
    <div class="row">
           <@n.navbar "/navbar" />
        <div class="col-sm-8 col-md-6">
            <br>
            <h5>Dashboard</h5>
            <br>
            <p><a href="/user">Список пользователей</a> </p>

        </div><!--End col-sm-md-->
    </div><!--End row-->
</@c.page>