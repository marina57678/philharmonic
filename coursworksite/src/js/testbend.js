window.onload = () => {
	document.getElementById('get_organizers').addEventListener('click', showOrganizers);
	document.getElementById('get_organizers-withevents').addEventListener('click', showOrganizersWithEvent);
}
const allOrganizers = document.querySelector('.get_organizers');
const showTable = document.querySelector('.organizers-all');
const container = document.querySelector('organizers-all');

const showOrganizers = () => {
	console.log('organizers were loaded');
	const url = 'http://localhost:8080/aboutus';
	ajaxDemoSample(url, (response) => {
		console.log(response);
		makeTable(response);
		// allOrganizers.classList.toggle('allOrganizer_active');
		showTable.classList.toggle('allOrganizer-all_active');
	});
};

const makeTable = (organizers) => {
	const organizersContainer = document.getElementById('organizers-all');
	for(let organizer in organizers ) {
		let tr = document.createElement('tr')
		tr.classList.add('organizers__item-tr');
		// let th1 = document.createElement('th');
		// th1.classList.add('organizers__item');
		// th1.classList.add('organizers__item-tr');
		// let th2 = document.createElement('th');
		// th2.classList.add('organizers__item');	
		// th2.classList.add('organizers__item-tr');
		let tr1 = document.createElement('tr');
		tr1.classList.add('organizers__item');
		let td1 = document.createElement('td');
		td1.classList.add('organizers__item');
		let td2 = document.createElement('td');
		td2.classList.add('organizers__item');	
	   // th1.textContent = 'id';
		// tr.appendChild(th1);
		// th2.textContent = 'name';
		// tr.appendChild(th2);
td1.textContent = organizers[organizer].id;
tr1.appendChild(td1); // td1 помещается в нашу оболочку тр
//let td1 = document.createElement('td');
//for (let j = 0; j <= organizers.id.length; j++) {
	//td1.appendChild(document.getElementsByTagName(organizers.id[j]));
td2.textContent = organizers[organizer].organizerName;
tr1.appendChild(td2);
organizersContainer.appendChild(tr);
organizersContainer.appendChild(tr1);
// const addClassName = container.querySelectorAll('tr');
// addClassName.classList.add('organizers__item');
console.log('hi');
}
} 

const deleteOrgnizers = document.querySelector('.organizers-all');
if (allOrganizers) {
allOrganizers.addEventListener('click', () => {
document.getElementById('organizers-all').textContent="";
});
}
 // некс часть
const OrganizersWithevents = document.querySelector('.get_organizers-withevents');
const show1Table = document.querySelector('.organizers-withevents');
const showOrganizersWithEvent = () => {
	console.log('OrganizersWithEvent were loaded');
	const url = 'http://localhost:8080/aboutus';
	ajaxDemoSample(url, (response) => {
	console.log(response);
	makeSecondTable(response);
	// OrganizersWithevents.classList.toggle('organizers-withevents_active');
	show1Table.classList.toggle('organizers-withevents_active');
	})
};

const makeSecondTable = (organizers) => {
	const item = document.querySelectorAll('.organizers__item');
if (item.length > 0) {
	document.getElementById('organizers-withevents').textContent="";
	};
	const organizersContainer = document.getElementById('organizers-withevents');
	for(let organizer in organizers ) {
		let tr = document.createElement('tr')
		tr.classList.add('organizers__item-tr');
		let th1 = document.createElement('th');
		th1.classList.add('organizers__item');
		th1.classList.add('organizers__item-tr');
		let th2 = document.createElement('th');
		th2.classList.add('organizers__item');
		th2.classList.add('organizers__item-tr');
		let th3 = document.createElement('th');
		th3.classList.add('organizers__item');
		th3.classList.add('organizers__item-tr');
		let tr1 = document.createElement('tr');
		tr1.classList.add('organizers__item');
		let td1 = document.createElement('td');
		td1.classList.add('organizers__item');
		let td2 = document.createElement('td');
		td2.classList.add('organizers__item');	
		let td3 = document.createElement('td');
		td3.classList.add('organizers__item');	

th1.textContent = 'id';
tr.appendChild(th1);
th2.textContent = 'name';
tr.appendChild(th2);
th3.textContent = 'events';
tr.appendChild(th3);
td1.textContent = organizers[organizer].id;
tr1.appendChild(td1);
td2.textContent = organizers[organizer].organizerName;
tr1.appendChild(td2);
td3.textContent = organizers[organizer].organizerName;
tr1.appendChild(td3);
organizersContainer.appendChild(tr);
organizersContainer.appendChild(tr1);
}
}
// 2 парам( url, callback) 
//можно просто использовать .
const ajaxDemoSample= (url, callback) => { 
	let xhr = new XMLHttpRequest(); // 
	xhr.onreadystatechange = () => {
		if (xhr.readyState === 4 && xhr.status === 200) { // если стан объекта равен 4 (4 это какой-то хороший статус)
callback(JSON.parse(xhr.responseText)); // callback ( response=json) в строке 7 у нас callback))))
		}
	}
	xhr.open('GET',url);
	xhr.send();
}

// //let td1 = document.createElement('td');
// //for (let j = 0; j <= organizers.id.length; j++) {
// 	//td1.appendChild(document.getElementsByTagName(organizers.id[j]));
// td2.textContent = organizers[organizer].organizerName;
// tr.appendChild(td2);
// organizersContainer.appendChild(tr);
// console.log('hi');
// }
// } 


// const deleteOrgnizers = document.querySelector('.organizers-all');
// if (allOrganizers) {
// allOrganizers.addEventListener('click', () => {
// document.getElementById('organizers-all').textContent="";
// });
// }

// window.onload = () => {
// 	document.getElementById('get_organizers').addEventListener('click', showOrganizers);
// 	document.getElementById('get_organizers-withevents').addEventListener('click', showOrganizersWithEvent);
// 	document.getElementById('form-create-btn').addEventListener('click',)
// 	}
// 	const allOrganizers = document.querySelector('.get_organizers');
// 	const showTable = document.querySelector('.organizers-all');
// 	const container = document.querySelector('organizers-all');
// 	const showOrganizers = () => {
// 		console.log('organizers were loaded');
// 		const url = 'http://localhost:8080/aboutus';
// 		ajaxDemoSample(url, (response) => {
// 		console.log(response);
// 		makeTable(response);
// 		allOrganizers.classList.toggle('allOrganizer_active');
// 		showTable.classList.toggle('allOrganizer-all_active');
// 	})
// 	};
	
// 	const makeTable = (organizers) => {
// 		const organizersContainer = document.getElementById('organizers-all');
// 		for(let organizer in organizers ) {
// 			let tr = document.createElement('tr')
// 			tr.classList.add('organizers__item-tr');
// 			let th1 = document.createElement('th');
// 			th1.classList.add('organizers__item');
// 			th1.classList.add('organizers__item-tr');
// 			let th2 = document.createElement('th');
// 			th2.classList.add('organizers__item');	
// 			th2.classList.add('organizers__item-tr');
// 			let tr1 = document.createElement('tr');
// 			tr1.classList.add('organizers__item');
// 			let td1 = document.createElement('td');
// 			td1.classList.add('organizers__item');
// 			let td2 = document.createElement('td');
// 			td2.classList.add('organizers__item');	
// 			th1.textContent = 'id';
// 			tr.appendChild(th1);
// 			th2.textContent = 'name';
// 			tr.appendChild(th2);
// 	td1.textContent = organizers[organizer].id;
// 	tr1.appendChild(td1); // td1 помещается в нашу оболочку тр
// 	//let td1 = document.createElement('td');
// 	//for (let j = 0; j <= organizers.id.length; j++) {
// 		//td1.appendChild(document.getElementsByTagName(organizers.id[j]));
// 	td2.textContent = organizers[organizer].organizerName;
// 	tr1.appendChild(td2);
// 	organizersContainer.appendChild(tr);
// 	organizersContainer.appendChild(tr1);
// 	// const addClassName = container.querySelectorAll('tr');
// 	// addClassName.classList.add('organizers__item');
// 	console.log('hi');
// 	}
// 	} 
	
// 	const deleteOrgnizers = document.querySelector('.organizers-all');
// 	if (allOrganizers) {
// 	allOrganizers.addEventListener('click', () => {
// 	document.getElementById('organizers-all').textContent="";
// 	});
// 	}
// 	 // некс часть
// 	const OrganizersWithevents = document.querySelector('.get_organizers-withevents');
// 	const show1Table = document.querySelector('.organizers-withevents');
// 	const showOrganizersWithEvent = () => {
// 		console.log('OrganizersWithEvent were loaded');
// 		const url = 'http://localhost:8080/aboutus';
// 		ajaxDemoSample(url, (response) => {
// 		console.log(response);
// 		makeSecondTable(response);
// 		// OrganizersWithevents.classList.toggle('organizers-withevents_active');
// 		show1Table.classList.toggle('organizers-withevents_active');
// 		})
// 	};
	
	// const makeSecondTable = (organizers) => {
	// 	const item = document.querySelectorAll('.organizers__item');
	// if (item.length > 0) {
	// 	document.getElementById('organizers-withevents').textContent="";
	// 	};
	// 	const organizersContainer = document.getElementById('organizers-withevents');
	// 	for(let organizer in organizers ) {
	// 		let tr = document.createElement('tr')
	// 		tr.classList.add('organizers__item-tr');
	// 		let th1 = document.createElement('th');
	// 		th1.classList.add('organizers__item');
	// 		th1.classList.add('organizers__item-tr');
	// 		let th2 = document.createElement('th');
	// 		th2.classList.add('organizers__item');
	// 		th2.classList.add('organizers__item-tr');
	// 		let th3 = document.createElement('th');
	// 		th3.classList.add('organizers__item');
	// 		th3.classList.add('organizers__item-tr');
	// 		let tr1 = document.createElement('tr');
	// 		tr1.classList.add('organizers__item');
	// 		let td1 = document.createElement('td');
	// 		td1.classList.add('organizers__item');
	// 		let td2 = document.createElement('td');
	// 		td2.classList.add('organizers__item');	
	// 		let td3 = document.createElement('td');
	// 		td3.classList.add('organizers__item');	
	
	// th1.textContent = 'id';
	// tr.appendChild(th1);
	// th2.textContent = 'name';
	// tr.appendChild(th2);
	// th3.textContent = 'events';
	// tr.appendChild(th3);
	// td1.textContent = organizers[organizer].id;
	// tr1.appendChild(td1);
	// td2.textContent = organizers[organizer].organizerName;
	// tr1.appendChild(td2);
	// td3.textContent = organizers[organizer].organizerName;
	// tr1.appendChild(td3);
	// organizersContainer.appendChild(tr);
	// organizersContainer.appendChild(tr1);
	// }
	// }
// 	// 2 парам( url, callback) 
// 	const ajaxDemoSample= (url, callback) => { 
// 		let xhr = new XMLHttpRequest(); // 
// 		xhr.onreadystatechange = () => {
// 			if (xhr.readyState === 4 && xhr.status === 200) { // если стан объекта равен 4 (4 это какой-то хороший статус)
// 	callback(JSON.parse(xhr.responseText)); // callback ( response=json) в строке 7 у нас callback))))
// 			}
// 		}
// 		xhr.open('GET',url);
// 		xhr.send();
// 	}