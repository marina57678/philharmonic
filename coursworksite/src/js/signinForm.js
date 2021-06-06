"use strict"
const headerHide = document.querySelector('.header__container')
const btnSignin = document.querySelector('.signin');
const signinForm = document.querySelector('.form-sighin');
const mainPageText= document.querySelector('.full-screen');
const signinBody = document.querySelector('.form-sighin');
const linkCreate = document.querySelector('.linkCreate');
      const createForm = document.querySelector('.create-acc');
		if (linkCreate) {
			linkCreate.addEventListener('click', () => {
				linkCreate.classList.toggle('linkCreate__acrive');
				createForm.classList.toggle('create-acc__active');	
				signinForm.classList.toggle('form-signin__active');
				signinBody.classList.toggle('form-sighin_active');
				console.log('hai');
			});
		}
if (btnSignin) {
	btnSignin.addEventListener('click', () => { 
		headerHide.classList.add('header_hide')
		document.body.classList.toggle('_lock');
		signinForm.classList.toggle('form-signin__active');
		signinBody.classList.toggle('form-sighin_active');
		mainPageText.classList.toggle('full-screen__text_active');
		console.log('hw');
		
	});
}
// const closeForm = document.querySelectorAll('.form__buttonClose')
// closeForm.forEach.addEventListener('click', () => {
// 		headerHide.classList.remove('header_hide')
// 		document.body.classList.remove('_lock');
// 		signinForm.classList.remove('form-signin__active');
// 		signinBody.classList.remove('form-sighin_active');
// 		mainPageText.classList.remove('full-screen__text_active');
// 		console.log('poka');
// 	});
	const closeForm = document.querySelectorAll('.form__buttonClose')
	for ( let i = 0; i < closeForm.length; i++) {
		let closeEl= closeForm[i];
		closeEl.addEventListener('click', function (event) {
			headerHide.classList.remove('header_hide')
		document.body.classList.remove('_lock');
		signinForm.classList.remove('form-signin__active');
		signinBody.classList.remove('form-sighin_active');
		mainPageText.classList.remove('full-screen__text_active');
		linkCreate.classList.remove('linkCreate__acrive');
		createForm.classList.remove('create-acc__active');	
		console.log('poka');
		console.log('click');
		event.preventDefault();
		});
}

const backToForm = document.querySelector('.form-back-btn')
if(backToForm){
	backToForm.addEventListener('click', () => {
		signinForm.classList.add('form-signin__active');
		signinBody.classList.add('form-sighin_active');
		mainPageText.classList.add('full-screen__text_active');
		linkCreate.classList.remove('linkCreate__acrive');
		createForm.classList.remove('create-acc__active');	
		console.log('click');
});
} 


document.addEventListener('DOMContentLoaded', function () {
	const signup = document.getElementById('form-create');
	signup.addEventListener('submit', formSignupSend);
	// const labelSignup = document.querySelectorAll('.')

	async function formSignupSend (e) {
		e.preventDefault();
		// проверим валидацию
		let error = formValidate(signup);
		// formValidate(signup);
		if(error === 3 ){
			// создать пермен,сохранить в нее то что мы ввели и отпарвить куда-то
			// let accId=document.getElementById('form-create')

			let userName=document.getElementById('form-createName');
			let userPhone= document.getElementById('form-createPhone');
			let userEmail= document.getElementById('form-createEmail');
			let userLogin=document.getElementById('form-createLogin');
			let userPassword=document.getElementById('form-createPass');
			console.log(userEmail.value);
			console.log(error);
			let xhr = new XMLHttpRequest();
			let url = "http://localhost:8080/accs/save";
			xhr.open("POST", url, true);
			xhr.setRequestHeader("Content-Type", "application/json");
			xhr.onreadystatechange = function () {
      		if (xhr.readyState === 4 && xhr.status === 200){
               let json = JSON.parse(xhr.responseText);
            }
         };
			// let data = JSON.stringify({ "userName": userName, " userPhone":  userPhone , "userEmail": userEmail, "userLogin":userLogin, "userPassword": userPassword });
			//console.log(data);
			let data = JSON.stringify({ "userName": userName.value, "userPhone":  userPhone.value , "userEmail": userEmail.value, 
			"userLogin":userLogin.value, "userPassword": userPassword.value });
			xhr.send(data);
			console.log(data);

		}
	
	}

	function formValidate(signup) {
		// let input = document.getElementsByTagName('input');
		let error = 0;
		// req -require-обязательное поле
		// добавиим класс _req  к обязательным полям (в  нашей форме)
		// теперь в переменную forreq поступят объекты с классом _req
		let formReq = document.querySelectorAll('._req');
		// нужно создать цикл . будет бегать по объектам . 
		//получать каждый объект в конст инпут и будет работаь с ней
		for (let i= 0; i < formReq.length; i++) {
			const input = formReq[i];
			formRemoveError(input); // изначательно нужно убрать класс еррор , после проверка
			if (input.classList.contains('_email')) {
				if (emailTest(input)) {
					formAddError(input);
					console.log(input.value);
					error++;
				}
			}
			// else if (input.getAttribute("type") === "checkbox" && input.checked === false) {
			// 	formAddError(input);
			// 	error++;
			// }
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
	// добавим 2 доп функии которые будут дбавялть класс error нашему объекту 
	function formAddError(input) {
		input.parentElement.classList.add('_error');
		input.classList.add('_error');
		console.log('helpMe');
	}
	function formRemoveError(input) {
		input.parentElement.classList.remove('_error');
		input.classList.remove('_error');
	}
	function emailTest(input) {
		return !/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(input.value);
	}

});


