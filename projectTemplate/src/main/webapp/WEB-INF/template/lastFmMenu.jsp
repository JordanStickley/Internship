<%@ include file="/WEB-INF/layouts/include.jsp"%>
<!-- nav with 2 links -->
<div class="well well-nav sidebar affix-top lp5 rp5 navTop">
    <ul class="nav nav-list">
        <li class="${activeHome}"><a href="<c:url value='/lastFm/' />" class="strong">Home</a>
 
        <li class="${activeAddLastFm}"><a href="https://www.last.fm/tag/news" class="strong">Last.FM News</a></li>
    </ul>
</div>