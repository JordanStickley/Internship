<%@ include file="/WEB-INF/layouts/include.jsp"%>
<div class="contaienr">
	<h1>JavaScript Training</h1>
</div>
<script>
	require([
		'local/app/example'
	], function (example) {
		//example.sayHello();
		example.sayGoodBye();
	});
</script>