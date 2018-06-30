<#import "parts/common.ftl" as c>
<#import "parts/navbar.ftl" as n>


<@c.page>
    <div class="row">
            <@n.navbar "/navbar" />

        <div class="col-sm-8 col-md-6">

            <h3>Hello, user</h3>
            <a href="/index">Main page</a>
            <br>
            <br>

            <br>
            <br>

        </div><!--End col-sm-md-->
    </div><!--End row-->
</@c.page>