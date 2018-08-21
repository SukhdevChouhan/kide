<#-- @ftlvariable name="tasks" type="java.util.List<com.espark.adarsh.domain.Tasks>" -->
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css">
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    
    <script>
    	$(document).ready(function (){
    		$(".task-row").click(function(){
    			window.location=$(this).data("url");
    		});
    	});
    </script>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/task/create">Create Task</a></li>
    </ul>
    
</nav>

<div class="container">
    <h2>Task Information </h2>
    <p>task data for analysis </p>
    <table class="table table-hover">
        <tr>
	   		<th>S.No.</th>
	   		<th>Date</th>
	   		
        </tr>
        <#list inventory as task>
        <tr class="task-row">
        	<td>${task.id}</td>
        	<td>${task.InvDate}</td>
        </tr>
        </#list>
    </table>
</div>
<div id="navigate"></div>

<style>
table, th , td  {
  border: 1px solid grey;
  border-collapse: collapse;
  padding: 5px;
}
table tr:nth-child(odd) {
  background-color: #f1f1f1;
}
table tr:nth-child(even) {
  background-color: #ffffff;
}
</style>

</body>
</html>