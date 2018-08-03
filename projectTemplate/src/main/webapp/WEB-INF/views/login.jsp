<%@ include file="/WEB-INF/layouts/include.jsp" %>


<body class="tundra">
	<div id="bodyContentTile" class="container">
		<div class="container-fluid">
			<div class="row">
				<h1 class="underline col-sm-12">Welcome to Last.FM Login!</h1>
			</div>
			<div class="well">
				<form action="<c:url value='/loginProcess'/>" method="POST" class="form" data-dojo-type="dijit/form/Form"
					id="loginForm" name="loginForm">
					<div class="row">		
						<!-- username input -->			
						<div class="form-group col-sm-5">
							<label for="" class="control-label">Username: </label> 
							<input type="text" class="form-control" placeholder="username"
								   name="username" id="username" data-dojo-id="username"
								   data-dojo-type="dijit/form/TextBox"
								   data-dojo-props="required: true">
						</div>		
						<!-- password input -->	
						<div class="form-group col-sm-5">
							<label for="" class="control-label">Password: </label> 
							<input type="password" class="form-control" placeholder="password"
								   name="password" id="password" data-dojo-id="password"
								   data-dojo-type="dijit/form/TextBox"
								   data-dojo-props="required: true">
						</div>
						<!-- login button -->
						<div class="form-group col-sm-2">
							<button id="basicLoginBtn" class="btn btn-primary btn-form"
								type="submit" data-dojo-type="oreilly/types/form/Button"
								data-dojo-props="spinOnClick: false">Login
							</button>
						</div>							
					</div>							
				</form>
			</div>
		</div>
	</div>
</body>
