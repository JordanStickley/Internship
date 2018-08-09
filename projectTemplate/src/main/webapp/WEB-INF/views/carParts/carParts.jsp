<%@ include file="/WEB-INF/layouts/include.jsp"%>
<div id="bam" 
    data-dojo-id="bam" 
    data-dojo-type="oreilly/types/ui/AlertManager"
    data-dojo-props="scroll:true">    
</div>


<div class="row">
	<h1 class="underline col-sm-10">Last.FM Monitor</h1>
	<form action="<c:url value='/logout'/>" method="POST" class="form" data-dojo-type="dijit/form/Form"
					id="loginForm" name="loginForm">
		<!-- Log out button -->
		<div class="form-group col-sm-2">
			<button id="basicLogoutBtn" class="btn btn-default form-btn"
				type="submit" data-dojo-type="oreilly/types/form/Button"
				data-dojo-props="spinOnClick: false">Logout
			</button>
		</div>	
	</form>
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
		<!-- div to add warning too -->
		<div id="messages"></div> 		
		<!-- input area for the sms messages -->
		<div class="form-group col-sm-3">
			<label for="" class="control-label">Send Via SMS</label> 
			<input type="text" class="form-control"
				   placeholder="Ex. 417-429-7123" name="phone" id="phone"
				   data-dojo-id="phone" 
				   data-dojo-type="dijit/form/TextBox"
				   data-dojo-props="required: false">								   			  
		</div>
		<!-- button for sending the sms message -->
		<div class="form-group col-sm-2">
			<button id="basicSmsSubmitBtn" class="btn btn-primary btn-form"
					type="button" 
					data-dojo-type="oreilly/types/form/Button"
					data-dojo-props="spinOnClick: true">Send
			</button>
		</div>		
	</div>
</form>
	
<div class="row mt10">
	<div class="col-sm-12">
		<div class="table-responsive">			
			<div data-dojo-id="carPartStore" 
				 data-dojo-type="dojo/store/Memory"
				 data-dojo-props="data: [], idProperty: 'eventId'">
			</div>
			<!-- Build the table head by default, only inserting the tbody once there's actual data -->
			<div id="table-container4" class="span12">
				<table id="carParts" class="table table-striped table-bordered"
					   data-dojo-type="oreilly/types/dgrid/PagingGridCheckBox" 
					   data-dojo-props="store: carPartStore, loadDataOnStartup: true">
					<thead>
						<tr>
							<th class="hyperlink"
								data-dgrid-column='{field: "partNumber",name: "partNumber"}'>Part Number</th>
							<th class="hyperlink"
								data-dgrid-column='{field: "title", name: "title"}'>Title</th>
							<th class="hyperlink"
								data-dgrid-column='{field: "line", name: "line"}'>Line</th>
							<th class="hyperlink"
								data-dgrid-column='{field: "price", name: "price"}'>Price</th>
							<th class="hyperlink"
								data-dgrid-column='{field: "qtyOnHand", name: "qtyOnHand"}'>Quantity On Hand</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</div>

<div class="row hidden"></div>

<script type="text/javascript">

require([ 'dojo/request', 'dijit/registry', 'dojo/ready', 'dojo/dom-style', 'dojox/timing'], function(
		request, registry, ready, domStyle) {
	ready(function() {
		var grid = registry.byId("carParts");
		
		
		var t = new dojox.timing.Timer(5000);
		t.onTick = function(){			
			request('<c:url value="/carParts/getCarParts" />').then(function(data) {
				var carPartsData = JSON.parse(data);
				grid.store.setData(carPartsData);
				grid.refresh();
				
				for(var i = 0; i < carPartsData.length; i++) {
					var obj = carPartsData[i];
					if (obj.smsSent) {
						domStyle.set(registry.byId('oap-checkbox-'+obj.eventId+'carParts').domNode, 'display', 'none');
					}
				}
			}, function(err) {
				console.log("Error: " + err);
			});
		}
		t.start();
		
		grid.refresh();

		var button = document.querySelector('#basicSmsSubmitBtn');

		button.addEventListener('click', function() {
			var checkedArray = grid.getChecked();
			var input = document.querySelector('#phone');
			var bam = registry.byId('bam');
			
			//display success message with 1 second delay to showcase spinners
			var url = '<c:url value="/carParts/validatePhone/' +  input.value + '" />';
			request(url).then(function(data) {
				for (var i = 0; i < checkedArray.length; i++) {
					var url = '<c:url value="/carParts/sendSms/' + checkedArray[i].eventId + '/' +  input.value + '" />';
					request(url).then(function(data) {
						setTimeout(function(){ 
							bam.addSuccess({
								message : "Your Loved song(s) have been sent!",
								title : "Success!",
								cssClass : 'myclass',
								position : 'messages'
							});
							registry.byId('basicSmsSubmitBtn').stopSpinner();
						}, 1000);
						
						//display error for non-whitelisted phone numbers
					}, function(err) {
						bam.addError({
							message : "Message not sent: Opticronius is a cheap-skate and doesn't pay for Twilio.",
							title : "Error!",
							cssClass : 'myclass',
							position : 'messages'
						});
						registry.byId('basicSmsSubmitBtn').stopSpinner();
					});
				}
				//display error for non-mobile/voIP phone numbers with 1 second delay to showcase spinners
			}, function(err) {					
				bam.addError({
					
					message : "Please enter a valid mobile/VoIP phone number only",
					title : "Error!",
					cssClass : 'myclass',
					position : 'messages'
				});
				setTimeout(function(){
					registry.byId('basicSmsSubmitBtn').stopSpinner();
				}, 1000);
			});
		})
	});
});
</script>