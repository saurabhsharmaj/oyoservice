<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header"> <a class="navbar-brand" href="${pageContext.request.contextPath}/home"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt=""></a> </div>
  </div>
  <div class="authbar">
		
		 <sec:authorize  access="isAnonymous()">
        	<span class="floatRight"><a href="login">login</a></span> | <span class="floatRight"><a href="newuser">sign up</a></span>
   		 </sec:authorize>
	    <sec:authorize  access="isAuthenticated()">
	        <span>Dear <strong>${loggedinuser}</strong>, Welcome to CrazyUsers.</span> <span class="floatRight"><a href="logout">Logout</a></span>
	    </sec:authorize>
    
	</div>
</nav>