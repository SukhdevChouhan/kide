<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="com.espark.adarsh.domain.UserCreateForm" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>

<html lang="en">
<head>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/inventory">My Inventories</a></li>
    </ul>
</nav>

<div class="container">
    <div class="jumbotron">
        <center>   <h3>INVENTORY CREATION FORM</h3></center>
    </div>
    <form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div>
            <label for="invDate">Inventory Date</label>
            <input type="text" class="form-control" name="invDate" id="invDate" 
                    autofocus placeholder="purchase date" value="${createInv.setCurrentDateInv()}"/>
        </div>
         <div>
            <label for="inventory_uiid">Inventory uiid</label>
            <input type="text" class="form-control" name="inventory_uiid" id="inventory_uiid" 
                    autofocus placeholder="ddmmyyyyxxxxx" value="${createInv.setCurrentDateUiid()}"/>
        </div>
        <div>
            <label for="item">Item Buy</label>
            <input type="text" name="item" id="item"  placeholder="item Buy"/>
        </div>
        
        <div>
            <label for="price">Item total Price</label>
            <input type="text" name="price" id="price" 
                   autofocus placeholder="Item total Price"/>
        </div>
        
        <div>
            <label for="quantity">quantity</label>
            <input type="text" name="quantity" id="quantity"  autofocus placeholder="quantity"/>
        </div>
        
        
        
        <#-- <div>
            <label for="uom">Unit of measurement</label>
            <input type="text" name="uom" id="uom"  autofocus placeholder="uom"/>
        </div> -->
        
        <div>
            <label for="uom">Unit of measurement</label>
            <select name="uom" id="uom">
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
        
       <#--  <div>
            <label for="catagory">Item catagory</label>
            <input type="text" name="catagory" id="catagory"  autofocus placeholder="catagory"/>
        </div> -->
        
        <div>
            <label for="catagory">Item catagory</label>
            <select name="catagory" id="catagory">
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
            <label for="unit_Price">unit Price or MRP</label>
            <input type="text"  name="unit_Price" id="unit_Price"  placeholder="unit Price"/>
        </div>
        
        <div>
            <label for="brand">brand if any</label>
            <input type="text"  name="brand" id="brand" placeholder="brand if any"/>
        </div>
        
         <div>
            <label for="shop_from">purchase from</label>
            <input type="text"  name="shop_from" id="shop_from" placeholder="purchase from"/>
        </div>

        <button type="submit">Save</button>
    </form>
</div>
</body>
</html>