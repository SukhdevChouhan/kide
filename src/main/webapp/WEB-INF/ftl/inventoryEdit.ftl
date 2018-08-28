<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="com.espark.adarsh.domain.UserCreateForm" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>

<html lang="en">
<head>Edit Inventory</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<div class="container">
    <div class="jumbotron">
    </div>
    <form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
   		
    	 <div>
            <label for="id">inventory id</label>
            <input type="number" class="form-control" name="id" id="id" value="${inventory.id}" readonly="readonly"/>
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
            <option value = "Household">Household</option>
            <option value = "Maintainance">Maintainance</option>
            <option value = "Snacks">Hotel and Snacks</option>
            <option value = "basicFood">Milk, dairy,fruits and Vegetables</option>
            <option value = "Office">Office activities</option>
            <option value = "Travel">Travel and tour</option>
            <option value = "Clothings">Clothings</option>
            <option value = "Medical">Medical</option>
            <option value = "Studies">Studies</option>
            <option value = "Premium">Premium</option>
            <option value = "Bike">Bike</option>
            <option value = "leisure">leisure</option>
            <option value = "Health">Health</option>
            <option value = "other">other surpresis</option>
            <option value = "charity_lost_stolen_forget">charity or lost or stolen or forget</option>
         </select>
        </div>
        
		<div>
            <label for="unit_Price">unit Price</label>
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
