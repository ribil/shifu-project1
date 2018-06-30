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


<#--Field error in object 'message' on field 'author': rejected value [user1];
codes [typeMismatch.message.author,typeMismatch.author,
typeMismatch.User,typeMismatch];
arguments [org.springframework.context.support.DefaultMessageSourceResolvable:
codes [message.author,author]; arguments []; default message [author]];
default message [Failed to convert property value of type 'java.lang.String'
to required type 'User' for property 'author';
nested exception is org.springframework.core.convert.ConversionFailedException:
Failed to convert from type [java.lang.String] to type [java.lang.Long]
for value 'user1'; nested exception is java.lang.NumberFormatException:
For input string: "user1"]-->
