<#import "parts/common.ftl" as c>
<#import "parts/navbar.ftl" as n>
<#import "parts/addform.ftl" as a>

<@c.page>
    <div class="row">
            <@n.navbar "/navbar" />

        <div class="col-sm-8 col-md-6">

            <br>
            <br>
            <@a.addform "/addform" />
            <br>
            <br>

        </div><!--End col-sm-md-->
    </div><!--End row-->
</@c.page>