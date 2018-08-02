<%@ include file="/WEB-INF/layouts/include.jsp"%>

<div class="row">
	<h1 class="underline col-sm-12">Last.FM Monitor</h1>
</div>
	
<div class="row well">
	<h2 class="col-sm-3">Description</h2>
    <p class="col-sm-12">
        This Last.FM monitor service will track the recently "loved" tracks for Opticronius 
        record them to the database. The most recent loved track has been retrieved from
        the account and listed below in the table. A scheduler will monitor the inbox for new
        E-mails every 10 seconds. As a new email comes in, the table will be updated. Select
        the check-boxes below, enter a valid cell phone number ###-###-####, press the "send" button,
         and then receive the loved songs below as an SMS message. Once the SMS message has been sent
         successfully, the event is flagged as "sent" and the check-box is removed.
    </p>
</div>	

<form action="" class="form" data-dojo-type="dijit/form/Form" id="basicDialogForm">
	<div class="row"> 		
		<div class="form-group col-sm-3">
			<label for="" class="control-label">Send Via SMS</label> 
			<input type="text" class="form-control"
				   placeholder="Ex. 417-429-7123" name="phone" id="phone"
				   data-dojo-id="phone" 
				   data-dojo-type="dijit/form/TextBox"
				   data-dojo-props="required: false">								   			  
		</div>
		<div class="form-group col-sm-2">
			<button id="basicFormSubmitBtn" class="btn btn-primary btn-form"
					type="submit" 
					data-dojo-type="oreilly/types/form/Button"
					data-dojo-props="spinOnClick: true">Send
			</button>
		</div>		
	</div>
</form>
	
<div class="row mt10">
	<div class="col-sm-12">
		<div class="table-responsive">
			<!-- Declare the memory store -->
			<div data-dojo-id="carPartStore" 
				 data-dojo-type="dojo/store/Memory"
				 data-dojo-props="data: [], idProperty: 'eventId'">
			</div>
			<!-- Build the table (head only) -->
			<div id="table-container4" class="span12">
				<table id="carParts" class="table table-striped table-bordered"
					   data-dojo-type="oreilly/types/dgrid/PagingGridCheckBox" 
					   data-dojo-props="store: carPartStore, loadDataOnStartup: true">
					<thead>
						<tr>
							<th class="hyperlink"
								data-dgrid-column='{field: "eventId",name: "eventId"}'>Event Id</th>
							<th class="hyperlink"
								data-dgrid-column='{field: "eventDate", name: "eventDate"}'>Event Date</th>
							<th class="hyperlink"
								data-dgrid-column='{field: "lovedDate", name: "LovedDate"}'>Loved Date</th>
							<th class="hyperlink"
								data-dgrid-column='{field: "trackName", name: "trackName"}'>Track Name</th>
							<th class="hyperlink"
								data-dgrid-column='{field: "artistName", name: "artistName"}'>Artist Name</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</div>

<div class="row hidden"></div>

<script type="text/javascript">
	require([ 'dojo/request', 'dijit/registry', 'dojo/ready' ], function(
			request, registry, ready) {
		ready(function() {
			var grid = registry.byId("carParts");
			var store = registry.byId("carPartStore");
			request('<c:url value="/lastFm/getLastFm" />').then(function(data) {
				grid.store.setData(JSON.parse(data));
				grid.refresh();
			}, function(err) {
				console.log("Error: " + err);
			});
			grid.refresh();
		});
	});
</script>