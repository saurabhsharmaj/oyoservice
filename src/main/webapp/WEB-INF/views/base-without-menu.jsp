<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="author" content="Saurabh Sharma" />
        <meta name="company" content="IdLink" />
        <meta name="abstract" content="Face Deteaction." />
		
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
  	<tiles:insertAttribute name="stylecss" />
		
</head>

<body> 
<script>
var scheme="http";
var hostName = "localhost";
var portNo="8080";
var contextPath="oyoservice"
</script>
<div id="wrapper" style="padding-bottom: 100px;">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
			<tiles:insertAttribute name="header" />
        </nav>        
        <tiles:insertAttribute name="body" /> 
                 
</div>
    <!-- /#wrapper -->

<!-- Custom Theme JavaScript -->
<tiles:insertAttribute name="footer" />
<tiles:insertAttribute name="scriptjs" />
<input type="hidden" id="main-error" name="main-error">
</body>
<script>
$( document ).ready(function() {	
			$.getJSON("rest/vechicletypes").done(function (response) {
				 $("#vtype option").remove(); // Remove all <option> child tags.
				 $("#vtype").append( // Append an object to the inside of the select box
				            $("<option></option>") // Yes you can do this.
				                .text("Select Vechicle Type")
				                .val("-1")
				        );  
				 $.each(response, function(index, item) { // Iterates through a collection
				        $("#vtype").append( // Append an object to the inside of the select box
				            $("<option></option>") // Yes you can do this.
				                .text(item.vechicleName)
				                .val(item.id)
				        );
				    });
			});
});

function getManufacturer(vechicleType){
	$.getJSON("rest/manufacturertype/"+vechicleType).done(function (response) {
		 $("#manufacturer option").remove(); // Remove all <option> child tags.
		 $("#manufacturer").append( // Append an object to the inside of the select box
		            $("<option></option>") // Yes you can do this.
		                .text("Select Manufacturer")
		                .val("-1")
		        );  
		 $.each(response, function(index, item) { // Iterates through a collection
		        $("#manufacturer").append( // Append an object to the inside of the select box
		            $("<option></option>") // Yes you can do this.
		                .text(item.name)
		                .val(item.id)
		        );
		    });
	});
}

function getModals(manufacturerId){
	$.getJSON("rest/modal/"+manufacturerId).done(function (response) {
		 $("#modal option").remove(); // Remove all <option> child tags.
		 $("#modal").append( // Append an object to the inside of the select box
		            $("<option></option>") // Yes you can do this.
		                .text("Select Manufacturer")
		                .val("-1")
		        );  
		 $.each(response, function(index, item) { // Iterates through a collection
		        $("#modal").append( // Append an object to the inside of the select box
		            $("<option></option>") // Yes you can do this.
		                .text(item.vechicleName)
		                .val(item.id)
		        );
		    });
	});
}

function getVariants(modalId){
	$.getJSON("rest/vechiclevariant/"+modalId).done(function (response) {
		 $("#variant option").remove(); // Remove all <option> child tags.
		 $("#variant").append( // Append an object to the inside of the select box
		            $("<option></option>") // Yes you can do this.
		                .text("Select Variant Type")
		                .val("-1")
		        );  
		 $.each(response, function(index, item) { // Iterates through a collection
		        $("#variant").append( // Append an object to the inside of the select box
		            $("<option></option>") // Yes you can do this.
		                .text(item.vechicleName)
		                .val(item.id)
		        );
		    });
	});
}

function getVechicles(variantId){
	alert( "Final Seach");
}
</script>
</html>