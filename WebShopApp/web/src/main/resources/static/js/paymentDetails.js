var owner = $('#owner'),
	cardNumber = $('#cardNumber'),
	cardNumberField = $('#card-number-field'),
	CVV = $('#cvv'),
	mastercard = $('#mastercard'),
	confirmButton = $('#confirm-purchase'),
	visa = $('#visa'),
	amex = $('#amex');

cardNumber.payform('formatCardNumber');
CVV.payform('formatCardCVC');

cardNumber.keyup(function() {
	amex.removeClass('transparent');
	visa.removeClass('transparent');
	mastercard.removeClass('transparent');

	if ($.payform.validateCardNumber(cardNumber.val()) == false) {
		cardNumberField.removeClass('has-success');
		cardNumberField.addClass('has-error');
	} else {
		cardNumberField.removeClass('has-error');
		cardNumberField.addClass('has-success');
	}

	if ($.payform.parseCardType(cardNumber.val()) == 'visa') {
		mastercard.addClass('transparent');
		amex.addClass('transparent');
	} else if ($.payform.parseCardType(cardNumber.val()) == 'amex') {
		mastercard.addClass('transparent');
		visa.addClass('transparent');
	} else if ($.payform.parseCardType(cardNumber.val()) == 'mastercard') {
		amex.addClass('transparent');
		visa.addClass('transparent');
	}
});

var paymentForm = document.getElementById("paymentForm");

paymentForm.addEventListener("submit", function(e) {
    var isCardValid = $.payform.validateCardNumber(cardNumber.val());
    var isCvvValid = $.payform.validateCardCVC(CVV.val());

    if (owner.val().length < 5) {
        e.preventDefault();
        alert('Wrong owner name');
    } else if (!isCardValid) {
        e.preventDefault();
        alert('Wrong card number');
    } else if (!isCvvValid) {
        e.preventDefault();
        alert('Wrong CVV');
    } else {
   		this.submit();
    }
})
