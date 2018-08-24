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
  		$("#myInput").on("keyup", function() {
    	var value = $(this).val().toLowerCase();
    	$("#myTable tr").filter(function() {
      	$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
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
    <input id="myInput" type="text" placeholder="Search..">
	<br><br>
    <table class="table table-hover">
        <tr>
	   		<th>Task Id</th>
            <th>Task Name</th>
            <th>Report Date</th>
            <th>Update Date</th>
            <th>Heading</th>
            <th>Description</th>
            <th>Status</th>
            <th>Linked With</th> 
            <th>Closed Date</th>
            <th>Issue Type</th>
            <th>Other details</th>
            <th>Comments</th>
        </tr>
         </thead>
        <tbody id="myTable">
        <#list tasks as task>
        <tr class="task-row" data-url="/task/edit?taskname=${task.issue_name}">
        	<td>${task.id}</td>
            <td>${task.issue_name}</td>
            <td>${task.issue_report_date}</td>
            <td>${task.issue_update_date}</td>
            <td>${task.issue_heading}</td>
            <td>${task.issue_description}</td>
            <td>${task.issue_status}</td>
            <td>${task.issue_linked_with}</td>  
            <td>${task.issue_closed}</td>  
            <td>${task.issue_type}</td>
            <td>${task.issue_others}</td>
            <td>${task.issue_comments}</td>
        </tr>
        </#list>
        </tbody>
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