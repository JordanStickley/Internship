let interns = JSON.parse(localStorage.getItem("interns"));
if (interns == null) {
	interns = [];
}

function initIndex() {
	let body = document.querySelector("body");
	body.addEventListener("load", loadInternTable);
}
/**
 * Set the selected intern into local storage so you can retrieve it later
 * @param intern
 * @returns
 */
function setSelectedIntern(intern) {
	localStorage.setItem("selectedIntern", intern);
}

		
/**
 * Add User Message
 * 
 * @param type
 * @param message
 * @returns
 */
function addUserMessage(type, message) {
	// Add switch to manage the type of message that we need to display
	// Get an instance of the "message id" and make it visible
	// (element.classList.remove("hidden");)
	// Get an instance of the "message list" and append the message using proper
	// DOM manipulation

	
	 /*switch(type) { case 'success' : const div =
	 document.querySelector("#successMessage"); const ul =
	 document.querySelector("#successMessageList"); const msg =
	 document.createTextNode(message); ul.appendChild(msg);
	 div.classList.remove("hidden"); break; }*/
	 
}

function enrollIntern() {
	let min = 10000;
	let max = 99999;
	let randID = Math.floor(Math.random() * (max - min +1)) + min;
	let TeamMemberID = "4" + randID;
	let	TeamMember = document.querySelector("#myInput").value;
	let	Average = "test avg";
	interns.push([TeamMemberID, TeamMember, Average]);
	localStorage.setItem('interns', JSON.stringify(interns));
	
}

/**
 * "Extra Credit" Can you loop through your interns in local storage and find
 * interns similar to the search text?
 */
function filterInterns() {
	alert("key pressed!");
	// Check if the keypress is the proper "char code"
	// If so, filter the intern list and present results
	// If no results are found with the given text, present "No Records Found"
	// (colspan="2")
	// If the text is empty, clear the filter and present all interns
}



/**
 * Handle NAV Menu Clicks
 * @param linkName
 * @returns
 */
function setActiveLink(linkName) {
	// Remove the "active" class from any and all NAV list items
	// Add "active" to the list item that was clicked
	try {
		Array.prototype.forEach.call( document.querySelectorAll('.navLink'), function(el) {
			el.classList.remove("active");
		});
		
		document.getElementById(linkName).classList.add("active");	
	} catch (err) {
		console.log("Error setting active link. err=" + err);
	}
}

function loadInternTable(){
	const tbody = document.querySelector('#myTbody');
	
	for (let i = 0; i < interns.length; i++) {
		const tr = document.createElement('tr');
		const td1 = document.createElement('td');
		const td2 = document.createElement('td');
		const td3 = document.createElement('td');
		const link = document.createElement('a');
		
		link.href = 'editIntern.jsp';
		link.addEventListener("click", () => {
			setSelectedIntern(i);
		})
		
		link.innerText = interns[i][0];
		td1.appendChild(link);
		td2.innerText = interns[i][1];
		td3.innerText = interns[i][2];
		
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tbody.appendChild(tr);
	}
	
	
	
}





