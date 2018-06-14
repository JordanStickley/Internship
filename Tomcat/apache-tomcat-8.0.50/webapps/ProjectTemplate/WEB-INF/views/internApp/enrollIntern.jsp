<%@ include file="/WEB-INF/layouts/include.jsp"%>
	<div id="bodyContentTile" class="container">
		<!-- Provide Messages to the user when applicable  -->
		<%@include file="messages.jsp"%>
		<div id="myAlerts"></div>
		<div class="row">

			<div id="marginContainer" class="col-sm-2">
				<%@include file="nav.jsp"%>
			</div>

			<div class="col-sm-8">
				<div class="row">
					<div class="col-sm-9">
						<h1>Enroll Intern</h1>
					</div>
				</div>
				
				<div class="col-sm-12 no-padding">
					<!-- Need to add a well here
					     You will also need a form-group container with a width of 50%
					     Finally you will need a label and a form-control input.
					     Set the id on the input to teamMemberName  
					-->
					<div class="well">
						<div class="row" id="memberInfo">
							<div class="form-group col-sm-6">
								<label class="control-label" for="internNumber">Team Member</label>
								<input class="form-control" type="text" id="myInput" placeholder="Team Member Full Name" />
							</div>
						</div>
					</div>
					
					<!--  Add a centered button here with an onclick event that calls "enrollInter();" -->
					<p class="text-center">
						<button class="btn btn-primary" type="button">Enroll</button>
					</p>
								
				</div>
			</div>
			
		</div>
	</div>

	<script>
		require([
			'local/app/script',
			'dojo/request',
			'dijit/registry',
			'dojo/ready',
			'dojo/query', 
			'dojo/dom',
			'dojo/_base/array',
			'dojo/domReady!',
			'dojo/dom-construct',
			'dojo/NodeList-manipulate',
			'dojo/dom-prop',
			'dojo/dom-attr',
			'dojo/on',
			'dojo/_base/window',
			'dijit/focus',
			'dojo/store/Memory',
			'oreilly/types/store/MemoryStoreFromJson',
			'local/app/internsAppStore'
		], function (script, request, registry, ready, query, dom, array, domReady, domConstruct, NodeListManipulate, domProp, attr, on, win, focusUtil, memory, MemoryStoreFromJson, internsApp) {
			//example.sayHello();
			script.sayGoodBye();
			query('.btn').on('click', script.enrollIntern);
		});
	</script>