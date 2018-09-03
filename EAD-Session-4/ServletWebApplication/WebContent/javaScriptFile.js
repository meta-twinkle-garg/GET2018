function validateForm() {
	var firstName, lastName, email, contact, pass, confirm;
	firstName = validateFirstName();
	lastName = validateLastName();
	email = validateEmail();
	contact = validateContact();
	pass = checkPassword();
	confirm = confirmPassword();
	if (Boolean(firstName) && Boolean(lastName) && Boolean(email)
			&& Boolean(contact) && Boolean(pass) && Boolean(confirm)) {
		return true;
	}
	return false;
}

function validateFirstName() {
	var first = document.getElementById("firstName");
	var re = /^[A-Za-z]+$/;
	if (!re.test(first.value) || first.value.length <= 2) {
		// alert("First Name Invalid");
		first.style.border = "2px solid red";
		return false;
	} else {
		first.style.border = "2px solid green";
		return true;
	}
}

function validateLastName() {
	var last = document.getElementById("lastName");
	var re = /^[A-Za-z]+$/;
	if (!re.test(last.value) || last.value.length <= 2) {
		// alert("Last Name Invalid");
		last.style.border = "2px solid red";
		return false
	} else {
		last.style.border = "2px solid green";
		return true;
	}
}

function validateEmail() {
	var email = document.getElementById("email");
	if (email.value.length >= 5) {
		var atTheRate = email.value.indexOf('@');
		var dot = email.value.indexOf('.');
		if (atTheRate >= 1 && dot > atTheRate + 1
				&& dot < email.value.length - 3) {
			email.style.border = "2px solid green";
			return true;
		} else {
			// alert("Invalid email");
			email.style.border = "2px solid red";
			return false;
		}
	} else {
		// alert("Invalid email");
		email.style.border = "2px solid red";
		return false;
	}
}

function validateContact() {
	var contact = document.getElementById("contact");
	if (contact.value.length > 8) {
		var re = /^[0-9]+$/;
		if (re.test(contact.value)) {
			contact.style.border = "2px solid green";
			return true;
		} else {
			// alert("Contact number invalid");
			contact.style.border = "2px solid red";
			return false;
		}
	} else {
		// alert("Contact number invalid length");
		contact.style.border = "2px solid red";
		return false;
	}
}

function checkPassword() {
	var strength = document.getElementById("strength");
	var strongRegex = new RegExp(
			"^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
	var mediumRegex = new RegExp(
			"^(?=.{8,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$",
			"g");
	var enoughRegex = new RegExp("(?=.{8,}).*", "g");
	var pwd = document.getElementById("password");
	if (pwd.value.length == 0) {
		strength.innerHTML = "Type Password";
		pwd.style.border = "2px solid red";
		return false;
	} else if (false == enoughRegex.test(pwd.value)) {
		strength.innerHTML = "<span style='color:blue'>More Characters</span>";
		pwd.style.border = "2px solid red";
		return false;
	} else if (strongRegex.test(pwd.value)) {
		strength.innerHTML = "<span style='color:green'>Strong!</span>";
		pwd.style.border = "2px solid green";
		return true;
	} else if (mediumRegex.test(pwd.value)) {
		strength.innerHTML = "<span style='color:orange'>Medium!</span>";
		pwd.style.border = "2px solid orange";
		return false;
	} else {
		strength.innerHTML = "<span style='color:red'>Weak!</span>";
		pwd.style.border = "2px solid red";
		return false;
	}
}

function confirmPassword() {

	var confirm = document.getElementById("confirm");
	var pwd = document.getElementById("password");
	var match = document.getElementById("match");
	if (confirm.value.match(pwd.value)) {
		match.innerHTML = "<span style='color:green'>Passwords matched..!!</span>";
		confirm.style.border = "2px solid green";
		return true;
	} else {
		match.innerHTML = "<span style='color:red'>Passwords do not match..!!</span>";
		confirm.style.border = "2px solid red";
		return false;

	}

}