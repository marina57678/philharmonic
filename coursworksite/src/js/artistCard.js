
const artistCards = document.querySelectorAll('.artist-card__body');
for (let i = 0; i < artistCards.length; i++) {
	const artistCard = artistCards[i];
	artistCard.addEventListener('mousemove', startRotate);
	artistCard.addEventListener('mouseout', stopRotate);
}

function startRotate(event){
const artistCardItem = this.querySelector('.artist-cards__body-item-img');
const artistCardHalfHeight =  artistCardItem.offsetHeight/2;
const artistCardHalfWidth =  artistCardItem.offsetWidth/2;
console.log(artistCardHalfHeight);
artistCardItem.innerText = event.offsetX + ' ' + event.offsetY;
artistCardItem.style.transform = 'rotateX('+-(event.offsetY-artistCardHalfHeight)/10+'deg) rotateY('+(event.offsetX-artistCardHalfWidth)/16+'deg)';
	// console.log('numbers');
}
function stopRotate(event){
	const artistCardItem = this.querySelector('.artist-cards__body-item-img');
	artistCardItem.innerText = event.offsetX + ' ' + event.offsetY;
	artistCardItem.style.transform = 'rotate(0)';
		// console.log('numbers');
	}