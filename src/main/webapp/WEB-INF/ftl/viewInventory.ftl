<!DOCTYPE html>
<html>
<head>	
	<center><b>View Inventory</b></center>
	 <a href="/inventory/create">Create Inventory</a>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
	<style type="text/css" class="init"></style>
	
	<script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" class="init">
	
		$(document).ready(function() {
			$(".inventory-row").click(function(){
    			window.location=$(this).data("url");
    			});
			
			$('#myTable').DataTable( {
				"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
				 "order": [[ 0, 'desc' ]]
				});
			
				
				
			});
			
	</script>
	<style>body{background-color:#d3ffd8}</style>
</head>
	
	<body>
	<div>
			<div>			
				<table id="myTable" class="display" style="width:100%">
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
	</body>
</html>