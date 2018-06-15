				
<!-- 
   Build a nav 
   You will want a div with the certain attributes for it to display properly
   Check out the UI Guide for details.
   
   The NAV should contain: 
        An unordered list with child list items
        Each list item should contain an anchor that points to a page.
   		Page=Home 		    Anchor points to index.jsp.        Set li class="navLink" and li id="homeLink"
   		Page=Enroll Intern  Anchor points to enrollIntern.jsp. Set li class="navLink" and li id="enrollInternLink"
   		Page=Milestones     Anchor points to milestones.jsp.   Set li class="navLink" and id="milestoneLink"
   		
-->
<!-- Nav goes here -->
				<div class="well well-nav sidebar affix-top">
					<ul class="nav nav-list">
						<li class="navLink" id="homeLink">
							<a href="<c:url value = '/app' />">Home</a>
						</li>
						<li class="navLink" id="enrollInternLink">
							<a href="<c:url value = '/app/enrollIntern' />">Enroll Intern</a>
						</li>
						<li class="navLink" id="milestoneLink">
							<a href="<c:url value = '/app/milestones' />">Milestones</a>
						</li>
					</ul>
				</div>