<%@ include file="/WEB-INF/layouts/include.jsp"%>

<div class="well">
	<h1>Add Yahoo</h1>
	<div class="row">
		<div class="col-sm-7">
			<form class="form-group" method="post" action="<%=request.getContextPath()%>/yahoo/addYahoo" >
				<label class="control-label">Name</label> 
				<input class="form-control"
					   type="text" 
					   name="name"
				/>
				
				<label class="control-label mt10">Description</label> 
				<input class="form-control"
					   type="text" name="description"
					   
				/>
				
				<label class="control-label mt10">Size</label> 
				<input class="form-control"
					   type="text" name="size"
						
				/>
				
				<label class="control-label mt10">Vendor</label> 
				<input class="form-control"
					   type="text" name="vendor"
				/>
				
				<button class="btn btn-primary mt10" 
						id="prim" 
						data-dojo-type="oreilly/types/form/Button" 
						data-dojo-props="spinOnClick: true"
						type="submit"						
				>Submit</button>
				
			</form>
		</div>
	</div>
</div>