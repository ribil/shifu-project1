<#import "parts/common.ftl" as c>
<#import "parts/addform.ftl" as a>

<@c.page>
    <div class="row">
        <div class="col-sm-8 col-md-6">
            <br>
            <br>
<@a.addform "/addform" />

            <!-- <form method="post">
                 <div class="form-group">
                     <label for="AddContent">Add content</label>
                     <input type="content" class="form-control" name="content"/>
                 </div>
                 <button type="submit" class="btn btn-primary">Add</button>
             </form>-->

            <br>
            <br>

            <h5>Content list:</h5>
            <ul class="list-group">

                <#list messages as message>
                <li class="list-group-item">${message.content}, ${message.title}, ${message.slug}
                    <a href="element/${message.slug}">See</a></li>
                <#else>
                    <p>No content</p>
                </#list>
            </ul>


        </div><!--End col-sm-md-->
    </div><!--End row-->
</@c.page>