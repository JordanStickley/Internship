<!doctype html>
<html>
<head>
	<%@include file="head.jsp"%>
</head>
<body onload="setActiveLink('milestoneLink');">
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
						<h1>Milestones</h1>
					</div>
				</div>
				
				<div class="col-sm-6 no-padding">
				
					<!-- Need to add a well here
					     You will also need a form-group container with a width of 100%
					     Finally you will need a label and a form-control input for each of the 
					     milestone fields (title, description, and max points)
					-->
					<div class="well">
						<div class="row" id="title">
							<div class="form-group col-sm-12">
								<label class="control-label" for="titleOfMilestone">Title</label>
								<input class="form-control" type="text" id="titleOfMilestone" placeholder="Milestone Title" />
							</div>
							<div class="form-group col-sm-12">
								<label class="control-label" for="descriptionOfMilestone">Description</label>
								<input class="form-control" type="text" id="descriptionOfMilestone" placeholder="Milestone Description" />
							</div>
							<div class="form-group col-sm-12">
								<label class="control-label" for="milestoneMaxPoints">Max Points</label>
								<input class="form-control" type="text" id="milestoneMaxPoints" placeholder="Milestone Max Points" />
							</div>
							<div class="form-group col-sm-12">
								<p class="center-text">
									<button type="button" class="btn btn-primary">Add Milestone</button>
								</p>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col-sm-6">
					<!-- Table goes here
						 The table should be responsive and striped
						 Check the course notes and/or the UI Guide
						 
						 The default table should contain 3 columns
						 	"Title"
						 	"Description"
						 	"Max Points"
						 	
						 The default row (when no data is found) should be
						 "No Records Found" (colspan="3") 
					 -->
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Title</th>
									<th>Description</th>
									<th>Max Points</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td colspan="3">No Records Found</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			
		</div>
	</div>

	<script src="script.js"></script>
</body>

</html>