<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

	<div class="container">
		<div class="row">
			<form id="myForm" class="navbar-form navbar-left" data-keyboard="false" role="search">
				<div class="form-group">
					<input id='search' type="text" class="form-control" placeholder="Search">
				</div>
				<button id="btn-query" type="button" class="btn btn-default">Message Query</button>
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
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
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

