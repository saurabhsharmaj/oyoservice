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
	<div class="modal-dialog modal-sm">
<div class="modal-content">
                <div class="modal-header">                    
                    <h4 id="Login" class="modal-title">Customer login</h4>
                </div>
                <div class="modal-body">
			
					<div class="login-form">
						<c:url var="loginUrl" value="/login" />
						<form action="${loginUrl}" method="post" class="form-horizontal">
							<c:if test="${param.error != null}">
								<div class="alert alert-danger">
									<p>Invalid username and password.</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success">
									<p>You have been logged out successfully.</p>
								</div>
							</c:if>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
								<input type="text" class="form-control" id="username" name="ssoId" placeholder="Enter Username" required>
							</div>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
								<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
							</div>
							<div class="input-group input-sm">
                              <div class="checkbox">
                                <label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>  
                              </div>
                            </div>
							<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
								
							<div class="form-actions">
								<input type="submit"
									class="btn btn-block btn-primary btn-default" value="Log in">
							</div>
						</form>
					</div>
				
</div>
</div>
</div>        
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