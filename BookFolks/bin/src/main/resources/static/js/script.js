var divDetails = document.getElementById("details");

function loadDetails(){

	let divContainer = document.createElement("div");
	let elementField = document.createElement("h4");
	let elementValue = document.createElement("p");
	
	
	
	elementField.innerText = "Age";
	
	
	divContainer.appendChild(elementField);
	divContainer.appendChild(elementValue);
	
	divDetails.appendChild(divContainer);
	
	
}