window.addEventListener('DOMContentLoaded' , () => { 
	allOrgInit();
	ArtistInit();
	EventsInit();
	selectOrganizer();
	selectTEvent();
	selectBuilding();
	EventsGetForDel();
	delOldEvent();
	function allOrgInit(){
		// console.log('organizers were loaded');
		getResource('http://localhost:8080/aboutus')
		.then(data=> createAllOrgList(data))
		.catch(err => console.log('err')); 
	}

	function ArtistInit(){
		// console.log('artist were loaded');
		getResource('http://localhost:8080/artists')
		.then(data=> createArtistCards(data))
		.catch(err => console.log('err')); 
	}
	function selectOrganizer(){
		// console.log('org were loaded');
		getResource('http://localhost:8080/aboutus')
		.then(data=> selectOrg(data))
		.catch(err => console.log('err')); 
	}
	function selectTEvent(){
		// console.log('org were loaded');
		getResource('http://localhost:8080/typeofevent')
		.then(data=> selectTypeofEvent(data))
		.catch(err => console.log('err')); 
	}
	function selectBuilding(){
		// console.log('org were loaded');
		getResource('http://localhost:8080/buildings')
		.then(data=> selectBuldings(data))
		.catch(err => console.log('err')); 
	}

	function EventsInit(){
		// console.log('events were loaded');
		getResource('http://localhost:8080/events')
		.then(data=> createEventsList(data))
		.catch(err => console.log('err')); 
	}
	function EventsGetForDel(){
		// console.log('events were loaded');
		getResource('http://localhost:8080/events')
		.then(data => selectEventForDel(data))
		.catch(err => console.log('err')); 
	}
		// удаляю ивенты
	function deleteOldOrganizer(organizerId){
		console.log("pisska mari");
		const xhr = new XMLHttpRequest();
		const url = "http://localhost:8080/aboutus/delete/"+organizerId;
		xhr.open("DELETE", url, true);
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.send(null);
	}
	function EventsInfoBlock(eventId){
		getResource('http://localhost:8080/events/'+eventId)
		.then(data=> createEventBlock(data))
		.catch(err => console.log('err')); 
	}

	async function getResource(url){
		const res = await fetch(url); // async await что бы дождаться ответа 
		if(!res.ok){
			throw new Error('could not fetch ${url}, status ${res.status}');
			console.log('bad');
		}
		return await res.json();
	}
	
	function createAllOrgList(repsonse){
		repsonse.forEach(item => {
			let orgList = document.createElement('div');
			orgList.classList.add('org-card__container');
			orgList.classList.add('card__container');
			orgList.innerHTML = `
			<div class="org-card__body card__body">
					<img  class ="org-cards__body-item-img cards__body-item-img" src = "${item.photoOrganizer}" alt="person">
				</div>	
					<div class="org-cards__body-item-text cards__body-item-text">
						<div class="orgName aristText">${item.organizerName} </div>
						<div class="orgSname aristText"> ${item.organizerSname} </div>
					</div>
			`;
			// addeventlist.
			// document.querySelector('.allOrg-filter__bygenre').prepend(AllOrgList);  в начало .
			document.querySelector('.org-cards__container').appendChild(orgList);
		});
	}
		// 2 часть! добавляю org.
	
	function createArtistCards(response){
		response.forEach(item => {
			let artistCards = document.createElement('div');
			// либо так
			artistCards.classList.add('artist-card__container');
			artistCards.classList.add('card__container');
			// console.log(item);
			// console.log(artistCards);
			artistCards.innerHTML = `
				<div class="artist-card__body card__body">
					<img  class ="artist-cards__body-item-img cards__body-item-img" src = "${item.artistPhoto}" alt="person">
				</div>	
					<div class="artist-cards__body-item-text">
						<div class="aristText">${item.artistName} </div>
						<div class="aristText"> ${item.artistSname} </div>
						<div class="aristText"> ${item.artistAge} </div>
					</div>
				`;
				const cards = document.querySelectorAll('.artist-card__body');
				const artistCard = artistCards;
				artistCards.addEventListener('mousemove', startRotate);
				artistCards.addEventListener('mouseout', stopRotate);
				console.log('hello');
				function startRotate(event){
					const cardItem = this.querySelector('.artist-cards__body-item-img');
					const halfHeight =  cardItem.offsetHeight/2;
					const halfWidth =  cardItem.offsetWidth/2;
					console.log(halfHeight);
					cardItem.innerText = event.offsetX + ' ' + event.offsetY;
					cardItem.style.transform = 'rotateX('+-(event.offsetY-halfHeight)/10+'deg) rotateY('+(event.offsetX-halfWidth)/16+'deg)';
				}
				function stopRotate(event){
					const cardItem = this.querySelector('.artist-cards__body-item-img');
					cardItem.innerText = event.offsetX + ' ' + event.offsetY;
					cardItem.style.transform = 'rotate(0)';
					// 			// console.log('numbers');
					}
			document.querySelector('.artist-cards__container').appendChild(artistCards);
		});
	}

	const createEventsList = (ourevents)=> {
		const getEventsList = document.getElementById('events-all');
		for(let ourevent in ourevents ) {
			let tr = document.createElement('tr');
			tr.classList.add('info-events-table');
			tr.id="ourevent-row-"+ourevents[ourevent].eventId;
			let td1 = document.createElement('td');
			td1.style.width='10%';
			let td2 = document.createElement('td');
			td2.style.width='20%';
			let td3 = document.createElement('td');
			td3.style.width='20%';
			let td4 = document.createElement('td');
			let td5 = document.createElement('td');
			td1.textContent = ourevents[ourevent].eventId; 
			tr.appendChild(td1);
			td1.classList.add('eventInfo-table-item')
			td2.classList.add('eventInfo-table-item')
			td3.classList.add('eventInfo-table-item')
			td4.classList.add('eventInfo-table-item')
			td2.textContent = ourevents[ourevent].eventName;
			tr.appendChild(td2);
			td3.textContent = ourevents[ourevent].dateOfEvent;
			tr.appendChild(td3);
			document.querySelector('.eventInfo-tables__container').appendChild(tr);

			let eventRow = document.getElementById("ourevent-row-"+ourevents[ourevent].eventId);
			// console.log(eventRow);
			eventRow.addEventListener('click', (e) =>{
				// eventRow.classList.toggle('eventBlock_acrive'); //верни позже
				console.log('noooo');
				EventsInfoBlock(ourevents[ourevent].eventId);
			})
		}
	}	

	function createEventBlock(eventInfo){
			console.log('how are you?')
			console.log(eventInfo);
			let eventInfoDiv = document.createElement('div');
			eventInfoDiv.classList.add('events-infoblock__container');
			eventInfoDiv.innerHTML = `
				<div class= "event-infoblock__container">
							<div class="event-infoblock__btnClose">
								<div class="event-infoblock__buttonClose"><span></span></div>
							</div>
					<div class="event-infoblock-photo">
						<img  class ="event-infoblock-item-img cards__body-item-img" src = "https://i.ytimg.com/vi/9Gjs83Wz19M/maxresdefault.jpg" alt="person">
					</div>	
					<div class="events-infoblock-text">
						<div class="events-infoblock-item events-infoblock-item1">${eventInfo.eventName} </div>
						<div class="events-infoblock-item events-infoblock-item1"> ${eventInfo.organizers.organizerName}  ${eventInfo.organizers.organizerSname} </div>
						<div class="events-infoblock-item events-infoblock-item1"> ${eventInfo.typeOfEvent.nameType} </div>
					</div>
				</div>
			`;
			document.querySelector('.info-events__body-text').appendChild(eventInfoDiv);
			//try
			let InfoBlock = document.getElementsByClassName("event-infoblock__buttonClose");
		
			console.log(InfoBlock);
			InfoBlock[0].addEventListener('click', (e)  => {
				console.log('its work!');
				let a = document.getElementsByClassName("events-infoblock__container");
				console.log(a);
				// a[0].innerHTML ="";
				// a[0].classList.remove("events-infoblock__container");
				a[0].remove();
			})

	}
		const formOrgContainer = document.getElementById('form-create-org');
		formOrgContainer.addEventListener('submit', addNewOrg);

		async function addNewOrg (e) {
			console.log('add');
				e.preventDefault();
				// проверим валидацию
				let error = formValidateAdd(formOrgContainer);
				console.log(error);
				console.log('add');
				// formValidate(signup);
				if(error ===  2 ){
				// 	// создать пермен,сохранить в нее то что мы ввели и отпарвить куда-то
				// 	// let accId=document.getElementById('form-create')
		
					let organizerName=document.getElementById('form-create-orgName');
					let organizerSname= document.getElementById('form-create-orgSname');
					// let userEmail= document.getElementById('form-createEmail');
					console.log(organizerSname.value);
					console.log(error);
					let xhr = new XMLHttpRequest();
					let url = "http://localhost:8080/aboutus/save";
					xhr.open("POST", url, true);
					xhr.setRequestHeader("Content-Type", "application/json");
					xhr.onreadystatechange = function () {
						if (xhr.readyState === 4 && xhr.status === 200){
							let json = JSON.parse(xhr.responseText);
						}
					};
				//	// let data = JSON.stringify({ "userName": userName, " userPhone":  userPhone , "userEmail": userEmail, "userLogin":userLogin, "userPassword": userPassword });
				// 	//console.log(data);
					let data = JSON.stringify({ "organizerName": organizerName.value, "organizerSname":  organizerSname.value
					//"userEmail": userEmail.value}
					});
					xhr.send(data);
					console.log(data);
					let orgList = document.createElement('div');
					orgList.classList.add('org-card__container');
					orgList.classList.add('card__container');
					orgList.innerHTML = `
					<div class="org-card__body card__body">
							<img  class ="org-cards__body-item-img cards__body-item-img" src = "https://vladmihalcea.com/wp-content/uploads/2019/01/hpjp-covers_w280.jpg" alt="person">
						</div>	
							<div class="org-cards__body-item-text cards__body-item-text">
								<div class="orgName aristText">${organizerName.value} </div>
								<div class="orgSname aristText"> ${organizerSname.value} </div>
							</div>
					`;
					document.querySelector('.org-cards__container').appendChild(orgList);
				}
			
		}

		function formValidateAdd(formOrgContainer) {
			let error = 0;	
			let formAddReq = document.querySelectorAll('._reqAdd');
			// нужно создать цикл . будет бегать по объектам . 
			//получать каждый объект в конст инпут и будет работаь с ней
			for (let i= 0; i < formAddReq.length; i++) {
				const input = formAddReq[i];
				formRemoveError(input); // изначательно нужно убрать класс еррор , после проверка
				if (input.classList.contains('_email')) {
					if (emailTest(input)) {
						formAddError(input);
						console.log(input.value);
						error++;
					}
				}
				else {
					if (input.value === '' ) {
						formAddError(input);
						error++;
					}
				}
			}
			// console.log(formReq);
			return error;
			
		}

		function formAddError(input) {
			input.parentElement.classList.add('_error');
			input.classList.add('_error');
			console.log('problem with input');
		}

		function emailTest(input) {
			return !/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(input.value);
		}

		function formRemoveError(input) {
			input.parentElement.classList.remove('_error');
			input.classList.remove('_error');
		}
		
		const openAddOrg = document.querySelector('.addform-org');
		if (openAddOrg) {
			const addOrgBlock =document.querySelector('.create-org');
			openAddOrg.addEventListener('click', () => {
				addOrgBlock.classList.toggle('create-org_acrive');
				if(openAddOrg.textContent==='Add'){
					openAddOrg.textContent="Close";
					openAddOrg.style.background='rgba(145, 62, 47, 0.54)';
				}
				else if(openAddOrg.textContent==='Close'){
					openAddOrg.textContent="Add";
					openAddOrg.style.background='rgba(83, 126, 79, 0.54)';
				}
			});
			const closeOrgBlock =document.querySelector('.form-org-close-btn');
			closeOrgBlock.addEventListener('click', () => {
				addOrgBlock.classList.toggle('create-org_acrive');
				openAddOrg.textContent="Add";
				openAddOrg.style.background='rgba(83, 126, 79, 0.54)';
			})
		}
		// 3 часть! добавляю ивенты.
		const openAddEvent = document.querySelector('.addform-event');
		if (openAddEvent) {
			const addEventBlock =document.querySelector('.create-event');
			openAddEvent.addEventListener('click', () => {
				addEventBlock.classList.toggle('create-event_acrive');
				if(openAddEvent.textContent==='Add'){
					openAddEvent.textContent="Close";
					openAddEvent.style.background='rgba(145, 62, 47, 0.54)';
				}
				else if(openAddEvent.textContent==='Close'){
					openAddEvent.textContent="Add";
					openAddEvent.style.background='rgba(83, 126, 79, 0.54)';
				}
			});
			const closeEventBlock =document.querySelector('.form-event-close-btn');
			closeEventBlock.addEventListener('click', () => {
				addEventBlock.classList.toggle('create-event_acrive');
				openAddEvent.textContent="Add";
				openAddEvent.style.background='rgba(83, 126, 79, 0.54)';
			})
		}
		function selectOrg(organizers){
			organizers.forEach(item => {
				// console.log('cry');
				let orgOption = document.createElement('option');
				console.log(orgOption);
				orgOption.id="org-option-"+item.organizerId;
				orgOption.classList.add('org-option__container');

				orgOption.value = item.organizerId;
				orgOption.textContent =item.organizerName+" "+item.organizerSname;
				document.querySelector('.select-org').appendChild(orgOption);
				
			});
		}

		function selectTypeofEvent(TypeofEvent){
			TypeofEvent.forEach(item => {
				// console.log('funny');
				let TypeofEventOption = document.createElement('option');
				// console.log(TypeofEventOption);
				TypeofEventOption.id="eventType-option-"+item.idTypeOfEvent;
				TypeofEventOption.classList.add('eventType-option__container');
				TypeofEventOption.value = item.idTypeOfEvent;
				TypeofEventOption.textContent = item.nameType;
				document.querySelector('.select-typeofevent').appendChild(TypeofEventOption);
				
			});
		}

		function selectBuldings(Buildings){
			Buildings.forEach(item => {
				let BuildingsOption = document.createElement('option');
				BuildingsOption.id="building-option-"+item.buildingId;
				BuildingsOption.classList.add('buildings-option__container');
				BuildingsOption.value = item.idBuilding;
				BuildingsOption.textContent = item.nameBuildings;
				document.querySelector('.select-building').appendChild(BuildingsOption);
				
			});
		}
		const formEventContainer = document.getElementById('form-create-event');
		formEventContainer.addEventListener('submit', addNewEvent);

		async function addNewEvent(e){
			console.log('add');
			e.preventDefault();
			// проверим валидацию
			let error = formValidateAdd(formOrgContainer);
			console.log(error);
			console.log('add');
			// formValidate(signup);
			// if(error ===  0 ){
				let eventName=document.getElementById('form-create-eventName');
				let organizerId = document.getElementById('form-create-organizerId');
				let dateOfEvent = document.getElementById('form-create-dateOfEvent');
				let TypeofEvent = document.getElementById('form-create-idTypeOfEvent');
				let buildingId = document.getElementById('form-create-buildingId');
				// let userEmail= document.getElementById('form-createEmail');
				console.log(organizerId.value);
				// let selectBuldingsIdValue = document.getElementsById('form-create-idTypeOfEvent');
				let xhr = new XMLHttpRequest();
				let url = "http://localhost:8080/events/save";
				xhr.open("POST", url, true);
				xhr.setRequestHeader("Content-Type", "application/json");
				xhr.onreadystatechange = function () {
					if (xhr.readyState === 4 && xhr.status === 200){
						let json = JSON.parse(xhr.responseText);
					}
				};
				let data = JSON.stringify({ "eventName": eventName.value , "organizerId": organizerId.value ,
				"dateOfEvent": dateOfEvent.value , "idTypeOfEvent":TypeofEvent.value ,"buildingId":buildingId.value
				});
				console.log(organizerId.value);
				xhr.send(data);
				console.log(data);
				
			//}
		}

		function selectEventForDel(ourevents){
			ourevents.forEach(item => {
				// console.log('cry');
				let eventDelOption = document.createElement('option');
				eventDelOption.id="event-delete-option-"+item.organizerId;
				eventDelOption.classList.add('event-delete-option__container');
				eventDelOption.value = item.eventId;
				eventDelOption.textContent =item.eventName+" "+item.dateOfEvent;
				document.querySelector('.select-eventId').appendChild(eventDelOption);
			});
		}
		// const formDeleteEvent = document.getElementById('form-event-delete-btn');
		// formDeleteEvent.addEventListener('submit', delOldEvent);

		const openDelEvent = document.querySelector('.form-delete-event');
		if (openDelEvent) {
			const delEventBlock =document.querySelector('.delete-event');
			openDelEvent.addEventListener('click', () => {
				delEventBlock.classList.toggle('delete-event_acrive');
				if(openDelEvent.textContent==='Delete'){
					openDelEvent.textContent="Close";
					openDelEvent.style.background='rgba(145, 62, 47, 0.54)';
				}
				else if(openDelEvent.textContent==='Close'){
					openDelEvent.textContent="Delete";
					openDelEvent.style.background='rgba(83, 126, 79, 0.54)';
				}
			});

			const closeDelEventBlock =document.querySelector('.form-del-event-close-btn');
			closeDelEventBlock.addEventListener('click', () => {
				delEventBlock.classList.toggle('delete-event_acrive');
				openDelEvent.textContent="Delete";
				openDelEvent.style.background='rgba(83, 126, 79, 0.54)';
			})
		}
	// Разобрать утром удаление!
		function delOldEvent(){
			console.log('delete');
			let eventVtnDel=document.getElementById('form-event-delete-btn');
			eventVtnDel.addEventListener('click', (e) => {
				console.log('good');
				e.preventDefault();
				let selectEventDel = document.getElementById('form-delete-eventId');
				let eventId = selectEventDel.value;
				console.log(eventId);
				let xhr = new XMLHttpRequest();
				let url = "http://localhost:8080/events/delete/"+eventId;
				xhr.open("DELETE", url, true);
				xhr.setRequestHeader("Content-Type", "application/json");
				xhr.send(null);
			})
		}
})
window.onscroll = function showHead1() {
	const head = document.querySelector('.header');
	const signin  = document.querySelector('.form-create__body');
	const signup  = document.querySelector('.form-sighin__body');
	if (window.pageYOffset > 780) {
		head.classList.add('head-fixed');
		signin.classList.add('signin-fixed');
	}

	else {
		head.classList.remove('head-fixed');
	}
}