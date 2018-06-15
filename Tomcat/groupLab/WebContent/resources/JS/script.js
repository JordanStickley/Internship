
//========================== INDEX PAGE ==============================

{
	let interns = JSON.parse(localStorage.getItem('interns'));
	if (interns == null) {
		interns = [];
	}

	function initIndex() {
		let body = document.querySelector("body");
		loadInternTable();
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
}

//======================= ENROLL INTERN PAGE =========================

{
	let interns = JSON.parse(localStorage.getItem('interns'));
	if (interns == null) {
		interns = [];
	}
	
	function enrollIntern() {
		let min = 10000;
		let max = 99999;
		let randID = Math.floor(Math.random() * (max - min +1)) + min;
		let teamMemberID = "4" + randID;
		let	teamMember = document.querySelector("#myInput").value;
		let	average = 0;
		interns.push([teamMemberID, teamMember, average]);
		localStorage.setItem('interns', JSON.stringify(interns));
	}
}

//======================== EDIT INTERNS PAGE =========================

{
	const selectedIntern = localStorage.getItem("selectedIntern");
	const interns = JSON.parse(localStorage.getItem('interns'));
	const intern = interns[selectedIntern];
	const milestones = JSON.parse(localStorage.getItem('milestones'));
	
	function initEditInterns() {
		//title
		document.querySelector('h1').innerText = intern[1] + ' (' + intern[0] + ')';
		//select options
		let select = document.querySelector('select');
		for (let milestone of milestones) {
			let option = document.createElement('option');
			option.innerText = milestone[0];
			select.add(option);
		}
		//select action to change max score
		select.addEventListener('click', () => {
			document.querySelector('#maxScore').innerText = milestones[select.selectedIndex][2];
		});
		//set initial max score
		document.querySelector('#maxScore').innerText = milestones[select.selectedIndex][2];
		//display current scores
		if (interns[selectedIntern][3].length > 0) {
			fillScores();
		}
		document.querySelector('#saveScore').addEventListener('click', saveScore);
	}
	
	function saveScore() {
		let milestone = document.querySelector('#milestone').selectedIndex,
			score = document.querySelector('#score').value;
		if ((!Number.isInteger(+score)) || ((+score) < 0) || ((+score) > milestones[milestone][2])) {
			alert('Please enter only a non-negative integer no greater than the milestone\'s maximum for the score.');
		} else {
			intern[3].push([milestone, +score]);
			//avgScore = (avgScore * (numScores - 1) + newScore) / numScores 
			let avgScore = intern[2],
				numScores = intern[3].length,
				newScore = intern[3][numScores - 1][1];
			intern[2] = (avgScore * (numScores - 1) + newScore) / numScores;
			fillScores();
			localStorage.setItem('interns', JSON.stringify(interns));
		}
	}
	
	function fillScores() {
		let target = document.querySelector('table > tbody');
		//if the placeholder exists and scores are in the array, remove placeholder and build scores
		if(interns[selectedIntern][3].length > 0) {
			if (target.children.length == 0) {
				for (let score of interns[selectedIntern][3].values()) {
					target.appendChild(createScoreElement(score));
				}
			} else {
				//append child created from last score
				target.appendChild(createScoreElement(interns[selectedIntern][3][interns[selectedIntern][3].length - 1]));
			}
		}
	}
	
	function createScoreElement(elem) {
		let row = document.createElement('tr');
		let milestone = document.createElement('td');
		let score = document.createElement('td');
		let maxScore = document.createElement('td');
		
		milestone.innerText = milestones[elem[0]][0];
		score.innerText = elem[1];
		maxScore.innerText = milestones[elem[0]][2];
		row.appendChild(milestone);
		row.appendChild(score);
		row.appendChild(maxScore);
		
		return (row);
	}
}

//======================== MILESTONES PAGE =========================

{
	var milestones = JSON.parse(localStorage.getItem('milestones'));
	if (milestones == null) {
		milestones = [];
	}
	
	function initMilestones() {
		fillMilestones(document.querySelector('#milestones'));
		document.querySelector('#addMilestone').addEventListener('click', saveMilestone);
	}
	
	function saveMilestone() {
		let title = document.querySelector('#titleOfMilestone').value,
			description = document.querySelector('#descriptionOfMilestone').value,
			points = document.querySelector('#milestoneMaxPoints').value;
		if ((title == "") || (description == "") || (points == "")) {
			alert('Please ensure all three fields are filled.')
		} else if (!Number.isInteger(+points) || ((+points) <0)) {
			alert('Please enter only a non-negative integer for the max points.')
		} else {
			milestones.push([title, description, points]);
			localStorage.setItem('milestones', JSON.stringify(milestones));
			fillMilestones(document.querySelector('#milestones'));
		}
	}
	
	function fillMilestones(target) {
		//if the placeholder exists and milestones are in the array, remove placeholder and build milestones
		if(milestones.length > 0) {
			if (target.children[0].classList.contains('killme')) {
				target.removeChild(target.children[0]);
				for (let milestone of milestones.values()) {
					target.appendChild(createMilestoneElement(milestone));
				}
			} else {
				target.appendChild(createMilestoneElement(milestones[milestones.length - 1]));
			}
		}
	}
	
	function createMilestoneElement(milestone) {
		let row = document.createElement('tr');
		let title = document.createElement('td');
		let description = document.createElement('td');
		let maxPoints = document.createElement('td');
		
		title.innerText = milestone[0];
		description.innerText = milestone[1];
		maxPoints.innerText = milestone[2];
		row.appendChild(title);
		row.appendChild(description);
		row.appendChild(maxPoints);
		
		return (row);
	}
}

//========================== OTHER FUNCTIONS ===========================

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

	/*
	 * switch(type) { case 'success' : const div =
	 * document.querySelector("#successMessage"); const ul =
	 * document.querySelector("#successMessageList"); const msg =
	 * document.createTextNode(message); ul.appendChild(msg);
	 * div.classList.remove("hidden"); break; }
	 */
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