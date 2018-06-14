<%@ include file="/WEB-INF/layouts/include.jsp"%>
<body onload="setActiveLink('homeLink');">
	<div id="bodyContentTile" class="container">
		<!-- Provide Messages to the user when applicable  -->
		<%@include file="messages.jsp"%>
		<div class="row">
			<div id="marginContainer" class="col-sm-2">
				<%@include file="nav.jsp"%>
			</div>

			<div class="col-sm-8">
				<div class="row">
					<div class="col-sm-9">
						<h1>Intern Tracking</h1>
					</div>
					<div class="col-md-3">
						<div class="halftopmargin">
							<!-- "Extra Credit." Can you filter your table?  -->
							<input type="text" tabindex="0" id="searchBox" value=""
								placeholder="Filter" onkeypress="filterInterns();" />
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-12">
						<!-- Table goes here
							 The table should be responsive and striped
							 Check the course notes and/or the UI Guide
							 
							 The default table should contain 2 columns
							 	"Team Member ID"
							 	"Team Member"
							 	"Average"
							 	
							 The interns ID will be a hyperlink that takes you to 
							 editIntern.jsp 
							 
							 The default row (when no data is found) should be
							 "No Records Found" (colspan="3") 
						 -->
						<div class="table-responsive">
<!-- 							<table class="table table-striped">
								<thead>
									<tr>
										<th>Team MemberID</th>
										<th>Team Member</th>
										<th>Average</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td colspan="3">No Records Found</td>
									</tr>
								</tbody>
							</table> -->
							
							
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Team Member ID</th>
										<th>Team Member</th>
										<th>Average</th>
									</tr>
								</thead>
								<tbody id="myTbody">

								</tbody>
							</table>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	<script>
		require([
			'local/app/script',
			'dojo/ready'
		], function (script, ready) {
			//example.sayHello();
			script.sayGoodBye();
			ready(function(){
				loadInternTable();
			});
		});
	</script>
<!-- 	<script>initIndex();</script> -->