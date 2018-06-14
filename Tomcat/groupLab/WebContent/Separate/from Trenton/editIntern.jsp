<!doctype html>
<html>
<head>
	<%@include file="head.jsp"%>
</head>
<body>
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
						<h1>Ben High (12345)</h1>
					</div>
				</div>
				
				<div class="col-sm-6 no-padding">
				
					<!-- Need to add a well here
					     You will also need a form-group container with a width of 100%
					     You will need a drop down to hold the available milestones
					     Finally you will need a label and a form-control input for the score achieved
					-->
					<div class="well">
						<div class="row" id="title">
							<div class="form-group col-sm-12">
								<label class="control-label" for="titleOfMilestone">Milestones</label>
								<select class="form-control" id="milestone">
								</select> 
							</div>
							<div class="form-group col-sm-12">
								<label class="control-label" for="descriptionOfMilestone">Score</label>
								<input class="form-control" type="text" id="descriptionOfMilestone" placeholder="Milestone Score" />
							</div>
							<div class="form-group col-sm-12">
								<p class="center-text">
									<button type="button" id="saveScore" class="btn btn-primary">Add Milestone</button>
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
						 	"Milestone"
						 	"Score"
						 	"Max Score"
					 -->
					<div class="table-responsive">						
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Milestone</th>
									<th>Score</th>
									<th>Max Score</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
				
			</div>
			
		</div>
	</div>
	<script src="./resources/JS/script.js"></script>
    <script>initEditInterns();</script>
</body>

</html>