window.onload = () => {
	// добавляем нажатие на кнопку( формы) все артисты.
	document.getElementById('get_artists-all').addEventListener('click',showArtists);
}
const showAllArtistTable = document.querySelector('.artists-all__container');
//присвоим знач для showArtists
// по урл обратились к бегу достали запрос.
//запинхули это все в айжакс
const showArtists = () => {
	console.log('artists were loaded');
	const url = 'http://localhost:8080/artists';
	ajaxDemoSample(url, (response) => {
		console.log(response);
		makeArtistTable(response);
		showAllArtistTable.classList.toggle('artists-all__active');
		// showTable.classList.toggle('allOrganizer-all_active');
		console.log('hi');
	});
}

const makeArtistTable = (artists)=>{
	if(makeArtistTable.length>0){
		document.getElementById('artists-all__container').textContent="";
	}
	//нужно найти табл в штмл и вставить шаблок по айди сюда
	const allArtist = document.querySelector('.get_artists-all')
	const artistContainer = document.getElementById('artists-all__container');
	
	for(let artist in artists ) {
		let tr = document.createElement('tr')
		//заголовок табл состоит из 2 полей th1 и th2
		tr.classList.add('artists__item-tr');
		// поле для заполнения
		let tr1 = document.createElement('tr');
		tr1.classList.add('artists__item');
		let td1 = document.createElement('td');
		td1.classList.add('artists__item-tr');
		let td2 = document.createElement('td');
		// это из бэка из табл артистр массив артистов по айди и по имени 
		td1.textContent = artists[artist].id
		tr1.appendChild(td1)
		td2.textContent = artists[artist].artistName	
		tr1.appendChild(td2)
		artistContainer.appendChild(tr);
		artistContainer.appendChild(tr1);
		console.log('hi');
	}
}

const ajaxDemoSample= (url, callback) => { 
	let xhr = new XMLHttpRequest(); 
	xhr.onreadystatechange = () => {
		if (xhr.readyState === 4 && xhr.status === 200) { // если стан объекта равен 4 (4 это какой-то хороший статус)
			callback(JSON.parse(xhr.responseText)); // callback ( response=json) в строке 7 у нас callback))))
		}
	}
	xhr.open('GET',url);
	xhr.send();
}
