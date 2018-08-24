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
    	$(document).ready(function(){
  		$("#myInput").on("keyup", function() {
    	var value = $(this).val().toLowerCase();
    	$("#myTable tr").filter(function() {
      	$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	  $(".inventory-row").click(function(){
    			window.location=$(this).data("url");
    		});
	});
    </script>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
    
</nav>


<div class="container">
    <h2>Inventory Information </h2>
    <p>Items data for analysis </p>
	<input id="myInput" type="text" placeholder="Search..">
	<br><br>
    <table class="table table-hover">
        <thead>
        <tr>
	   		<th>S.No.</th>
	   		<th>Date</th>
	   		<th>Item Buy</th>
	   		<th>Price</th>
	   		<th>Catagory</th>
	   		<th>Quantity</th>
	   		<th>UoM</th>
	   		<th>Unit Price</th>
	   		<th>Brand</th>
	   		<th>Purchase from</th>
        </tr>
        </thead>
        <tbody id="myTable">
        <#list inventory as inv>
        <tr class="inventory-row">
        	<td>${inv.id}</td>
        	<td>${inv.invDate}</td>
        	<td>${inv.item}</td>
        	<td>${inv.price}</td>
        	<td>${inv.catagory}</td>
        	<td>${inv.quantity}</td>
        	<td>${inv.uom}</td>
        	<td>${inv.unit_Price}</td>
        	<td>${inv.brand}</td>
        	<td>${inv.shop_from}</td>
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