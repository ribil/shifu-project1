<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<p>${message?ifExists}</p>
<@l.login "/login" false/>
</@c.page>
