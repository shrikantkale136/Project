
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="index.jsp">
			<img src="images/logo.png" width="35px">
			Project
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item">
					<form action="${pageContext.request.contextPath}/LoginPage">
						<button class="navLink" type="submit">Login</button>
					</form>
				</li>
<%--				<li class="nav-item">--%>
<%--					<form action="signUp">--%>
<%--						<button class="navLink" type="submit">SignUp</button>--%>
<%--					</form>--%>
<%--				</li>--%>

			</ul>
		</div>
	</div>
</nav>