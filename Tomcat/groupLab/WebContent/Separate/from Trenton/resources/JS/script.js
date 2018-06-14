
//======================== GLOBAL VARIABLES =========================
const selectedIntern = 0;//localStorage.getItem("selectedIntern");
var milestones = JSON.parse(localStorage.getItem('milestones'));
if (milestones == null) {
	milestones = [];
}
var interns = JSON.parse(localStorage.getItem('interns'));
if (interns == null) {
	interns = [];
}

//======================== EDIT INTERNS PAGE =========================

function initEditInterns() {
	let select = document.querySelector('select');
	for (let milestone of milestones) {
		let option = document.createElement('option');
		option.innerText = milestone[0];
		select.add(option);
	}
	if (interns[selectedIntern][3].length > 0) {
		fillScores();
	}
}

function saveScore() {
	let milestone = document.querySelector('#milestone').selectedIndex,	score = document.querySelector('#saveScore').value;
	if ((!Number.isInteger(+score)) || ((+score) <0) || ((+score) > milestones[milestone])) {
		alert('Please enter only a non-negative integer for the score.');
	} else {
		interns[selectedIntern][3].push([milestone, score]);
		localStorage.setItem('interns', JSON.stringify(interns));
		fillScores();
		//avgScore = (avgScore * (numScores - 1) + newScore) / numScores 
		let avgScore = intern[selectedIntern][2],
			numScores = intern[selectedIntern][3].length,
			newScore = intern[selectedIntern][3][numScores - 1];
		intern[selectedIntern][2] = (avgScore * (numScores - 1) + newScore) / numScores; 
	}
}

function fillScores() {
	let target = document.querySelector('table > tbody');
	//if the placeholder exists and milestones are in the array, remove placeholder and build milestones
	if(interns[selectedIntern][3].length > 0) {
		if (target.children.length == 0) {
			console.log(milestones);
			for (let score of interns[selectedIntern][3].values()) {
				console.log(score);
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

//======================== MILESTONES PAGE =========================

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
			console.log('fill');
			console.log(milestones);
			target.removeChild(target.children[0]);
			for (let milestone of milestones.values()) {
				console.log(milestone);
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

function enrollIntern() {
	alert("Enroll Intern Clicked!");
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





