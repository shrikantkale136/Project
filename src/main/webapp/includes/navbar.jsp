<%@ page import="com.cis.app.project.model.UserLogin" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="index.jsp">
			<img src="images/logo.png" width="35px">
			UCM Blogs
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<%
					boolean isAuth = false;
					if (request.getSession().getAttribute("authenticated") != null) {
						isAuth = (Boolean) request.getSession().getAttribute("authenticated");
					}
					if (!isAuth) {
				%>

				<li class="nav-item">
					<form action="${pageContext.request.contextPath}/LoginPage">
						<button class="navLink" type="submit"> <i class="fa fa-lock pr-1"></i> Login</button>
					</form>
				</li>
				<%
				} else {

				%>
				<li class="nav-item">
					<form action="userProfile">
						<input hidden id="userName" name="userName" value="<%=session.getAttribute("userName")%>"/>
						<button class="navLink" type="submit">
							<i class="fa fa-user pr-1"></i>Profile
						</button>
					</form>
				</li>
				<li class="nav-item">
					<form action="log-out">
						<button class="navLink" type="submit">
							<i class="fa fa-sign-out pr-1"></i>Logout</button>
					</form>
				</li>
				<%
					}

				%>

			</ul>
		</div>
	</div>
</nav>