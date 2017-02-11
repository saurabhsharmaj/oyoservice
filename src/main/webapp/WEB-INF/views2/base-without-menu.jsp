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
var selectedVtype = '';				
var selectedCity='';
</script>
<div id="wrapper" style="padding-bottom: 100px;">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
			<tiles:insertAttribute name="header" />
        </nav>   
        
        <div class="bs-example bs-example-padded-bottom">
    <!-- Button trigger modal -->
    <div class="container">
  
  <div class="bs-example bs-example-padded-bottom">
    <!-- Button trigger modal -->
    <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
      Short modal
    </button>
  </div>
  

  <!-- Modal -->
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false" >
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">set the preference</h4>
        </div>
        <form action="savepreferences" class="form-horizontal" onsubmit="return validatePreference();">
        <div class="modal-body">
        	<div class="form-group">
	        	<label for="selectUser" style="float:left;padding: 6px 12px 2px 12px;">Select Vechilcle Type:</label>
		        <select id="vtype1" name="vtype" class="vtype" style="width:auto;" class="form-control selectWidth" onchange="getManufacturer(this.value);">
		          <option class="">Select Vechilcle Type</option>
		        </select>
	      </div>	      
	      
	      <div class="form-group">
	        	<label for="cities" style="float:left;padding: 6px 12px 2px 12px;">Select City Type:</label>
		        <select id="cities" name="cities" style="width:auto;" class="form-control selectWidth">
		          <option class="">Select City</option>
		        </select>
	      </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Save Preferences</button>
        </div>
        </form>
      </div>
      <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
  </div>
  <!-- /.modal -->

</div>  
  </div>     
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
				 $(".vtype option").remove(); // Remove all <option> child tags.
				 $(".vtype").append( // Append an object to the inside of the select box
				            $("<option></option>") // Yes you can do this.
				                .text("Select Vechicle Type")
				                .val("-1")
				        );  
				 $.each(response, function(index, item) { // Iterates through a collection
				        $(".vtype").append( // Append an object to the inside of the select box
				            $("<option></option>") // Yes you can do this.
				                .text(item.vechicleName)
				                .val(item.id)
				        );
				    });
			});
			
			$.getJSON("rest/cities").done(function (response) {
				 $("#cities option").remove(); // Remove all <option> child tags.
				 $("#cities").append( // Append an object to the inside of the select box
				            $("<option></option>") // Yes you can do this.
				                .text("Select City")
				                .val("-1")
				        );  
				 $.each(response, function(index, item) { // Iterates through a collection
				        $("#cities").append( // Append an object to the inside of the select box
				            $("<option></option>") // Yes you can do this.
				                .text(item.cityName)
				                .val(item.cityId)
				        );
				    });
			});
			
			function setModalMaxHeight(element) {
				  this.$element     = $(element);  
				  this.$content     = this.$element.find('.modal-content');
				  var borderWidth   = this.$content.outerHeight() - this.$content.innerHeight();
				  var dialogMargin  = $(window).width() < 768 ? 20 : 60;
				  var contentHeight = $(window).height() - (dialogMargin + borderWidth);
				  var headerHeight  = this.$element.find('.modal-header').outerHeight() || 0;
				  var footerHeight  = this.$element.find('.modal-footer').outerHeight() || 0;
				  var maxHeight     = contentHeight - (headerHeight + footerHeight);

				  this.$content.css({
				      'overflow': 'hidden'
				  });
				  
				  this.$element
				    .find('.modal-body').css({
				      'max-height': maxHeight,
				      'overflow-y': 'auto'
				  });
				}

				$('.modal').on('show.bs.modal', function() {
				  $(this).show();
				  setModalMaxHeight(this);
				  
				});

				$(window).resize(function() {
				  if ($('.modal.in').length != 0) {
				    setModalMaxHeight($('.modal.in'));
				  }
				});
				 selectedVtype = readCookie("vtype");				
				 selectedCity=readCookie("city");
				
				 $('#selectedCity').text(selectedVtype);
				 $('#selectedVtype').text(selectedCity);
				if(selectedVtype==null||selectedVtype==''|| selectedCity==null|| selectedCity==''){
				 $('#myModal').modal('show');
				}
});

function readCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1, c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
    }
    return null;
}

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
	$.getJSON("rest/vechiclemodal/"+manufacturerId).done(function (response) {
		 $("#modal option").remove(); // Remove all <option> child tags.
		 $("#modal").append( // Append an object to the inside of the select box
		            $("<option></option>") // Yes you can do this.
		                .text("Select Manufacturer")
		                .val("-1")
		        );  
		 $.each(response, function(index, item) { // Iterates through a collection
		        $("#modal").append( // Append an object to the inside of the select box
		            $("<option></option>") // Yes you can do this.
		                .text(item.vechicleModal)
		                .val(item.id)
		        );
		    });
	});
}

function getVariants(modalId){
	$.getJSON("rest/vechiclevariants/"+modalId).done(function (response) {
		 $("#variant option").remove(); // Remove all <option> child tags.
		 $("#variant").append( // Append an object to the inside of the select box
		            $("<option></option>") // Yes you can do this.
		                .text("Select Variant Type")
		                .val("-1")
		        );  
		 $.each(response, function(index, item) { // Iterates through a collection
		        $("#variant").append( // Append an object to the inside of the select box
		            $("<option></option>") // Yes you can do this.
		                .text(item.variantName)
		                .val(item.id)
		        );
		    });
	});
}

function getVechicles(variantId){
	alert( "Final Seach");
}

function getCities(){
	$.getJSON("rest/cities/").done(function (response) {
		 $("#cities option").remove(); // Remove all <option> child tags.
		 $("#cities").append( // Append an object to the inside of the select box
		            $("<option></option>") // Yes you can do this.
		                .text("Select City")
		                .val("-1")
		        );  
		 $.each(response, function(index, item) { // Iterates through a collection
		        $("#cities").append( // Append an object to the inside of the select box
		            $("<option></option>") // Yes you can do this.
		                .text(item.cityname)
		                .val(item.cityId)
		        );
		    });
	});
}

function validatePreference(){
	var selectedVechicleType = $('.vtype :selected').val();
	var selectedCity = $('#cities :selected').val();
	console.log(selectedVechicleType + " - "+ selectedCity);
}
</script>
</html>