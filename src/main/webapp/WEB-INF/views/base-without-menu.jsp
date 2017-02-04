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
var hostName = "216.198.248.69";
var portNo="8080";
var contextPath="idlinkneurotech"
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

	$("input#u_name").focus(function() {
		 $('.display-none').hide();
	});
	
	$('input#u_name').keypress(function(e) {		
        if(e.which == 13) {
            return false;
        }
    });
});
</script>
</html>