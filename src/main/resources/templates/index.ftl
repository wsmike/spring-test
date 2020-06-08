<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8" />
    <title></title>
</head>
<body>

<#list userList as user>
    第${user_index+1}个用户

    用户名：<#if user.username??>${user.username}</#if>

    时间：<#if user.birthday??>${user.birthday}</#if>

    性别：<#if user.sex??>${user.sex}</#if>

    地址：<#if user.address??>${user.address}</#if>
    <br>
</#list>


</body>
</html>