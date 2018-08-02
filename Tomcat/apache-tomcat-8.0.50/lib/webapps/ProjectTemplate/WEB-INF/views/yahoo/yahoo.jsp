<%@ include file="/WEB-INF/layouts/include.jsp"%>

<div class="row">
	<div class="col-sm-9">
		<h1>Yahoo Monitor</h1>
	</div>
	<div class="col-md-3">
		<div class="halftopmargin">
			<input type="text" tabindex="0" id="searchBox" value=""
				placeholder="Filter" onkeypress="filterYahoo();" />
		</div>
	</div>
</div>

<div class="row">
	<div class="col-sm-12">
		<div class="table-responsive">
			<!-- Declare the memory store -->
			<div data-dojo-id="carPartStore" data-dojo-type="dojo/store/Memory"
				data-dojo-props="data: [], idProperty: 'partNumber'"></div>
			<!-- Build the table (head only) -->
			<div id="table-container4" class="span12">
				<table id="carParts" class="table table-striped table-bordered"
					data-dojo-type="oreilly/types/dgrid/PagingGrid"
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
			request('<c:url value="/yahoo/getYahoo" />').then(function(data) {
				grid.store.setData(JSON.parse(data));
				grid.refresh();
			}, function(err) {
				console.log("Error: " + err);
			});
			grid.refresh();
		});
	});
</script>