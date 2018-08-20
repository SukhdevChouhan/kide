<!DOCTYPE html>
<html>
<body>

<h2>Use the XMLHttpRequest to get the content of a file.</h2>
<p>The content is written in JSON format, and can easily be converted into a JavaScript object.</p>

${inventory}

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<body>

<table id="headerTable" style="width:100%"><tr></tr></table>
<p id="demo"></p>

<script>
	var text, fLen, i, j, k, m,mTemp, text1;
	var arrMainRow =[20];
	var arrTem =[1]
	var arrTempRow =[10];
    var strOrg = "${inventory}";
    var strlen = strOrg.length;
    str = strOrg.slice(1,strlen-1);
    var arr = str.split("],");
    
    arrTem[0]= arr[0].substring(1);
    	console.log("header "+[0]+" = "+arrTem[0]);
    	mTemp = arrTem[0].split(",");
    	for(m=0;m<mTemp.length;m++){
    	console.log("Header length : "+mTemp.length+", Headers = "+mTemp[0])
    	}
    	text1 = "<tr>";
		for (j = 0; j < mTemp.length; j++) {
	    text1 += "<th>" + mTemp[j] + "</th>";
	}
	text1 += "</ul>";
	document.getElementById("headerTable").innerHTML = text1;
    
    for(i=1;i<arr.length;i++){
    	arrMainRow[i]= arr[i].substring(2);
    	console.log("in main "+[i]+" = "+arrMainRow[i]);
    	}
    	if(arr[arr.length-1].charAt(arr.length-1)==="["){
    		arr[arr.length].slice(arr.length);
    		}
	console.log("in 2 = "+arrMainRow[0]);
    
    text = "<ul>";
	for (j = 1; j < arr.length; j++) {
	    text += "<li>" + arrMainRow[j] + "</li>";
	}
	text += "</ul>";
	document.getElementById("demo").innerHTML = text;
</script>
</body>
</html>
