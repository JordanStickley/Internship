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
			<table class="table table-striped">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>
						<th>Start Date</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody id="myTbody">
					<c:forEach items="${empList}" var="entry">
						<tr>
							<td>${entry.firstName}</
							<td>
							<td>${entry.lastName}</
							<td>
							<td>${entry.age}</
							<td>
							<td>${entry.startDate}</
							<td>
							<td>${entry.active}</
							<td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<h1>Yahoo Table</h1>
<div class="row">
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
						data-dgrid-column='{field: "firstName",name: "firstName"}'>First
						Name</th>
					<th class="hyperlink"
						data-dgrid-column='{field: "lastName", name: "lastName"}'>Last
						Name</th>
					<th class="hyperlink"
						data-dgrid-column='{field: "age", name: "age"}'>Age</th>
					<th class="hyperlink"
						data-dgrid-column='{field: "startDate", name: "startDate"}'>
						Date</th>
					<th class="hyperlink"
						data-dgrid-column='{field: "active", name: "active"}'>Status</th>
				</tr>
			</thead>
		</table>
	</div>
</div>
<div class="row hidden"></div>

<script type="text/javascript">
	require([ 'dojo/request', 'dijit/registry', 'dojo/ready' ], function(request, registry, ready) {
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