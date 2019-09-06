const searchInputField = document.getElementById('searchInput');
const productDivs = document.getElementsByClassName('shop_box');

searchInputField.addEventListener('keyup', event => {
	for (let i = 0; i < productDivs.length; i++) {
		// const inputString = event.te
		const productName = productDivs[i].getElementsByClassName('product_name')[0].textContent;

		const input = event.target.value;

		if (productName.toLowerCase().includes(input) || productName.includes(input) || productName.toUpperCase()includes(input)) {
			productDivs[i].classList.remove('hidden');
		} else {
            productDivs[i].classList.add('hidden');
		}
	}
});
