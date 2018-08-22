<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="com.espark.adarsh.web.security.UserDetailsImpl" -->
<!DOCTYPE html>

<html lang="en">
<head>
</head>
<body>

<div bgcolor="#add8e6">
    <nav role="navigation">
        <ul>
        <#if !currentUser??>
            <li><a href="/login">Log in</a></li>
        </#if>

        <#if currentUser?? >
            <li>
                <form action="/logout" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit">Log out</button>
                </form>
            </li>
        </#if>
        <#if currentUser?? && currentUser.role == "ROLE_SUPERADMIN">
            <li><a href="/user/create">Create a new user</a></li>
            <li><a href="/users">View all users</a></li>
            <li><a href="/tasks">My Tasks</a></li>
            <li><a href="/inventory">Inventory</a></li>
        </#if>
        </ul>
    </nav>
    <div class="bs-example">
        <div class="container">
            <div class="jumbotron">
                <div class="alert alert-info">
                </div>
            </div>


            <div class="alert alert-info">
              
            </div>

        </div>
    </div>
</div>
</body>
</html>