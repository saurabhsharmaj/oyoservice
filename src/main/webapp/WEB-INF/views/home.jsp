<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Use @RequestParam to fetch HTTP GET parameter</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<form id="myForm" class="navbar-form navbar-left" data-keyboard="false" role="search">
				<div class="form-group">
					<input id='search' type="text" class="form-control" placeholder="Search">
				</div>
				<button id="btn-query" type="button" class="btn btn-default">Search</button>
			</form>
		</div>

		<div class="row">
			<table id="table-data" class="table table-hover">
				<thead>
					<tr>		
						<th>ID</th>
						<th>Name</th>
						<th>House No</th>
						<th>City</th>
						<th>State</th>
						<th>Pincode</th>
						<th>MobileNo</th>
					</tr>
				</thead>
				<tbody id='tbody'>
				</tbody>
			</table>
		</div>

		<div class="text-center">
			<div id="page-selection" class="pagination-sm"></div>
		</div>
		
		<div class="form-group">
        <label for="selectUser" style="float:left;padding: 6px 12px 2px 12px;">Select Vechilcle Type:</label>
	        <select id="vtype" style="width:auto;" class="form-control selectWidth" onchange="getManufacturer(this.value);">
	          <option class="">Select Vechilcle Type</option>
	        </select>
	      </div>
	      
	      <div class="form-group">
        <label for="selectUser" style="float:left;padding: 6px 12px 2px 12px;">Select ManuFacturer Type:</label>
	        <select id="manufacturer" style="width:auto;" class="form-control selectWidth" onchange="getModals(this.value);">
	          <option class="">Select ManuFacturer Type</option>
	        </select>
	      </div>
	      
	      <div class="form-group">
        <label for="selectUser" style="float:left;padding: 6px 12px 2px 12px;">Select Modal Type:</label>
	        <select id="modal" style="width:auto;" class="form-control selectWidth" onchange="getVariants(this.value);">
	          <option class="">Select Modal Type</option>
	        </select>
	      </div>
      
      <div class="form-group">
        <label for="selectUser" style="float:left;padding: 6px 12px 2px 12px;">Select Variant Type:</label>
	        <select id="variant" style="width:auto;" class="form-control selectWidth" onchange="getVechicles(this.value);">
	          <option class="">Select Variant Type</option>
	        </select>
	      </div>
      
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->

	<script src="./resources/js/jquery.bootpag.js"></script>
	<script>
		$(function() {
			$('#btn-query').on('click', function(){
				var query = $('#search').val();
				$('#page-selection').bootpag({'page': '1'});
				refreshTable(query, 1);
			});
			
			$('#page-selection').bootpag({
				total : 10,
				visiblePages : 10
			}).on("page", function(event, num) {
				var query = $('#search').val();
				refreshTable(query, num);
			});
			
			var refreshTable = function(query, page) {
			    $.ajax({
			        url: '${url}?query=' + query + '&page=' + (page - 1),
			        type: "GET",
			        dataType: 'json'
			      }).success(function(data) {
					var content = data.content;
			    	  
					var array = [];
										
					content.forEach(function(entry){
						array.push('<tr><td>' + entry.id + '</td><td>' + entry.name + '</td><td>' + entry.houseno + '</td><td>' + entry.city
								+ '</td><td>' + entry.state + '</td><td>' + '</td><td>' + entry.pincode + '</td><td>' + '</td><td>' + entry.mobileno + '</td><td>' +  '</td></tr>');
					});

					$('#tbody').html(array.join (''));
					$('#page-selection').bootpag({total: data.totalPages, visiblePages: data.totalPages > 10 ? 10 : data.totalPages});
			      }).error(function(error){
			    	  alert(error);
			      });
			}
			
			$('#myForm').bind('keydown', function(e) {
			    if (e.keyCode == 13) {
			        e.preventDefault();
			        $('#btn-query').click();
			    }
			});
			
			refreshTable('', 1);
		});
	</script>
</body>

</html>
