<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<p>Add new user</p>
<p>${message?ifExists}</p>
<@l.login "/registration" true />
</@c.page>
