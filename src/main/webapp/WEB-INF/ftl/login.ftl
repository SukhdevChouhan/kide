<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->

<!DOCTYPE html>
<html lang="en">
<body>


<div class="bs-example">


    <div class="alert alert-info">
    </div>

    <div class="container">
        <div class="jumbotron">


        <#if Session.SPRING_SECURITY_LAST_EXCEPTION?? && Session.SPRING_SECURITY_LAST_EXCEPTION.message?has_content>
            <div class="alert alert-danger">
                Invalid username and password.
            </div>
        </#if>


        <#if (request.getParameter("logout"))?? >
            <div class="alert alert-success">
                You have been logged out.
            </div>
        </#if>

            <form role="form" action="/login" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <div class="form-group">
                    <label for="username">UserName</label>
                    <input type="username" class="form-control" name="username" id="username" required autofocus
                           placeholder="username" value="sukhdev"/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" required class="form-control"
                           placeholder="Password" value="sukhdev"/>
                </div
                <div class="checkbox">
                    <label><input type="checkbox" name="remember-me" id="remember-me"> Remember me</label>
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
        </div>
</body>
</html>