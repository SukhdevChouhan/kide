<#-- @ftlvariable name="users" type="java.util.List<com.espark.adarsh.domain.User>" -->
<!DOCTYPE html>

<html lang="en">
<head>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/user/create">Create a new user</a></li>
    </ul>
</nav>


<div class="container">
    <h2>User Information </h2>
    <p>user data for analysis </p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>User First Name</th>
            <th>User Last Name</th>
            <th>User Email</th>
            <th>Role</th>
            <th>User Password</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td><a href="/user/${user.id}">${user.userEmail}</a></td>
            <td>
                <#list user.userRoles as role>
                ${role.name} &nbsp;
                </#list>
            </td>
            <td>${user.userPwd}</td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>