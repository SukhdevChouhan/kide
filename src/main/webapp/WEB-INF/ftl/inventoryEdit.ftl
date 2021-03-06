<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="com.espark.adarsh.domain.UserCreateForm" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>

<html lang="en">
<head>Edit Inventory <!-- for ${inventory.id?long?c} -->
<style> 
input[type=text], select {
  width: 100%;
  padding: 1px 2px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 0px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  margin: 0px 0;
  border: none;
  border-radius: 1px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 0px;
}
</style>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<div class="container">
    <div class="jumbotron">
    </div>
    <form role="form" name="form" action="" method="post" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
   		
    	 <div>
            <label for="id">inventory id</label>
            <input type="number" class="form-control" name="id" id="id" value="${inventory.id?long?c}" readonly	/>
        </div>
        
    	 <div>
            <label for="invDate">Inventory Date</label>
            <input type="text" class="form-control" name="invDate" id="invDate" value="${inventory.invDate}"/>
        </div>
        
        <div>
            <label for="item">Item Buy</label>
            <input type="text" name="item" id="item"  value="${inventory.item}"/>
        </div>
        
        <div>
            <label for="price">Item total Price</label>
            <input type="text" name="price" id="price" value="${inventory.price}"/>
        </div>
        
        <div>
            <label for="quantity">quantity</label>
            <input type="text" name="quantity" id="quantity"  value="${inventory.quantity}"/>
        </div>
        
        <div>
            <label for="uom">Unit of measurement</label>
            <select name="uom" id="uom">
            <option value = "${inventory.uom}">${inventory.uom}</option>
            <option value = "notapplicable">NA</option>
            <option value = "no_of_pieces">no. of pieces</option>
            <option value = "kilograms">kg</option>
            <option value = "grams">grams</option>
            <option value = "milliliters">ml</option>
            <option value = "liters">Liters</option>
            <option value = "pounds">pounds</option>
            <option value = "others">others</option>
            </select>
        </div>
        
        <div>
            <label for="catagory">Item catagory</label>
            <select name="catagory" id="catagory">
            <option value = "${inventory.catagory}">${inventory.catagory}</option>
            <option value = "dairy">milk and Dairy</option>
            <option value = "vegetables">vegetables and fruits</option>
            <option value = "Grocessories">pulses and Grocessories</option>
            <option value = "alcohol">Alcohol</option>
            <option value = "household">Household items</option>
            <option value = "Maintainance">Maintainance</option>
            <option value = "Snacks">Hotel and Snacks</option>
            <option value = "Studies">Studies</option>
            <option value = "Office">Office activities</option>
            <option value = "Bike">Bike</option>
            <option value = "Travel">Travelling</option>
            <option value = "Clothings">Clothings</option>
            <option value = "Health">fitness and health</option>
            <option value = "cosmatics">beauty and cosmatics</option>
            <option value = "Medical">Medicines and hospital</option>
            <option value = "Premium">Premium</option>
            <option value = "leisure">leisure</option>
            <option value = "other">other surpresis</option>
            <option value = "hobby">Hobbies</option>
            <option value = "charity_lost_stolen_forget">charity or lost or stolen or forget</option>
         </select>
        </div>
        
		<div>
            <label for="unit_Price">unit/MRP Price</label>
            <input type="text"  name="unit_Price" id="unit_Price"  value="${inventory.unit_Price}"/>
        </div>
        
        <div>
            <label for="brand">brand if any</label>
            <input type="text"  name="brand" id="brand" value="${inventory.brand}"/>
        </div>
        
         <div>
            <label for="shop_from">purchase from</label>
            <input type="text"  name="shop_from" id="shop_from" value="${inventory.shop_from}"/>
        </div>

        <button type="submit">Save</button>
    </form>
</div>
</body>
</html>
