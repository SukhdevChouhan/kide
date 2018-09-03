<!DOCTYPE html>
<html>
<head>	
	
	<link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css">
	<script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" class="init">
	
		$(document).ready(function() {
			$(".inventory-row").click(function(){
    			window.location=$(this).data("url");
    			});
			
			$('#myTable').DataTable( {
				"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
				});
			});
			
	</script>
</head>
	
	<body>
	<div>
			<div>			
				<table id="myTable">
					<thead>
						<tr>
							<th>S.No.</th>
					   		<th>Date</th>
					   		<th>Uiid</th>
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
					<tbody>
					<#list inventory as inventory>
						<tr class="inventory-row" data-url="/inventory/edit?inventory_uiid=${inventory.inventory_uiid}">
						<td>${inventory.id}</td>
			        	<td>${inventory.invDate}</td>
			        	<td>${inventory.inventory_uiid}</td>
			        	<td>${inventory.item}</td>
			        	<td>${inventory.price}</td>
			        	<td>${inventory.catagory}</td>
			        	<td>${inventory.quantity}</td>
			        	<td>${inventory.uom}</td>
			        	<td>${inventory.unit_Price}</td>
			        	<td>${inventory.brand}</td>
			        	<td>${inventory.shop_from}</td>
			        	</tr>
			        </#list>
					</tbody>
				</table>
			</div>	
			</div>		
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