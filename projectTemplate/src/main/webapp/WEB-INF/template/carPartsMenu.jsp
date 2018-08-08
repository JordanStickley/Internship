<%@ include file="/WEB-INF/layouts/include.jsp"%>
<!-- nav with 2 links -->
<div class="well well-nav sidebar affix-top lp5 rp5 navTop">
    <ul class="nav nav-list">
        <li class="${activeHome}"><a href="<c:url value='/carParts/' />" class="strong">Home</a>
 
        <li class="${activeAddCarParts}"><a href="https://www.last.fm/tag/news" class="strong">Car Parts News</a></li>
        
        <li class="${activeCarPartsSales}"><a href="<c:url value='/carParts/carPartsSales' />" class="strong">Car Parts checkout</a></li>
    </ul>
</div>