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
		
	<title>
		<tiles:insertAttribute name="title" ignore="true" />
	</title>
  	<tiles:insertAttribute name="stylecss" />
		
</head>

<body>

<div id="login-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true" class="modal fade">
	<jsp:include page="login.jsp"></jsp:include>
</div>
    
<tiles:insertAttribute name="header" />
<tiles:insertAttribute name="body" />  
<tiles:insertAttribute name="footer" />
<tiles:insertAttribute name="scriptjs" />
    <!-- Javascript files-->
   <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>   
    <script type="text/javascript">
           $(window).load(function(){
                $('#onload').modal('show');
            });
    </script>
</body>
</html>