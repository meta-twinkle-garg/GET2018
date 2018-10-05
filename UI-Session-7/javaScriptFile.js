function validateForm() {
    var firstName, lastName, email, contact, city, state, errorMessage, zip, projectDescription, hosting;
    errorMessage = "";
    firstName = validateFirstName();
    lastName = validateLastName();
    email = validateEmail();
    contact = validateContact();
    city = validateCity();
    state = document.getElementById("state");
    localStorage.setItem("state", state.value);
    localStorage.setItem("address", document.getElementById("address").value);
    if (firstName != "valid") {
        errorMessage += firstName + "\n";
    }
    if (lastName != "valid") {
        errorMessage += lastName + "\n";
    }
    if (email != "valid") {
        errorMessage += email + "\n";
    }
    if (contact != "valid") {
        errorMessage += contact + "\n";
    }
    if (city != "valid") {
        errorMessage += city + "\n";
    }


    switch (state.value) {
        case "":
            errorMessage += "State: Please select an option";
            state.style.border = "2px solid red";
            break;

        case "Rajasthan":
            projectDescription = document.getElementById("description");
            localStorage.setItem("projectDescription", projectDescription.value);
            localStorage.setItem("website", document.getElementById('website').value);
            if (projectDescription.value == "") {
                errorMessage += "Project Description: Can't be empty\n";
                projectDescription.style.border = "2px solid red";
            }
            break;

        case "Haryana":
            zip = document.getElementById("zip-code");
            localStorage.setItem("zip", zip.value);
            if (zip.value == "") {
                errorMessage += "Zip Code: Can't be empty\n";
                zip.style.border = "2px solid red";
            }
            if (document.querySelector('input[name=hosting]:checked') != undefined) {
                localStorage.setItem("hosting", document.querySelector('input[name=hosting]:checked').value);
            }

            break;
        case "Maharashtra":
            zip = document.getElementById("zip-code");
            localStorage.setItem("zip", zip.value);
            projectDescription = document.getElementById("description");
            localStorage.setItem("projectDescription", projectDescription.value);
            if (zip.value == "") {
                errorMessage += "Zip Code: Can't be empty\n";
                zip.style.border = "2px solid red";
            }
            if (projectDescription.value == "") {
                errorMessage += "Project Description: Can't be empty\n";
                projectDescription.style.border = "2px solid red";
            }
            break;
        default:
            break;
    }


    if (errorMessage.length == 0) {
        return true;
    }
    alert(errorMessage);
    return false;
}

function validateFirstName() {
    var first = document.getElementById("firstName");
    if (first.value == "") {
        first.style.border = "2px solid red";
        return "First Name: Can't be empty";
    }
    var re = /^[A-Za-z]+$/;
    if (!re.test(first.value)) {
        first.style.border = "2px solid red";
        return "First Name: Invalid input type";
    } else {
        first.style.border = "none";
        localStorage.setItem("firstName", first.value);
        return "valid";
    }
}

function validateLastName() {
    var last = document.getElementById("lastName");
    if (last.value == "") {
        last.style.border = "2px solid red";
        return "Last Name: Can't be empty";
    }
    var re = /^[A-Za-z]*$/;
    if (!re.test(last.value)) {
        last.style.border = "2px solid red";
        return "Last Name: Invalid input type";
    } else {
        last.style.border = "none";
        localStorage.setItem("lastName", last.value);
        return "valid";
    }
}

function validateEmail() {

    var email = document.getElementById("email");
    if (email.value.length == 0) {
        email.style.border = "2px solid red";
        return "Email: Can't be empty";
    }

    if (email.value.length >= 5) {
        var atTheRate = email.value.indexOf('@');
        var dot = email.value.indexOf('.');
        if (atTheRate >= 1 && dot > atTheRate + 1 && dot < email.value.length - 3) {
            email.style.border = "none";
            localStorage.setItem("email", email.value);
            return "valid";
        } else {
            email.style.border = "2px solid red";
            return "Email: Invalid email format";
        }
    } else {
        email.style.border = "2px solid red";
        return "Email: Invalid email format";
    }
}

function validateContact() {
    var contact = document.getElementById("contact");
    if (contact.value.length == 0) {
        localStorage.setItem("contact", "");
        return "valid";
    }
    if (contact.value.length > 9) {
        var re = /^[0-9]+$/;
        if (re.test(contact.value)) {
            contact.style.border = "none";
            localStorage.setItem("contact", contact.value);
            return "valid";
        } else {
            contact.style.border = "2px solid red";
            return "Contact Number: Invalid input format";
        }
    } else {
        contact.style.border = "2px solid red";
        return "Contact Number: Minimum digits must be 10";
    }
}

function validateCity() {
    var city = document.getElementById("city");
    var re = /^[A-Za-z]*$/;
    if (!re.test(city.value)) {
        city.style.border = "2px solid red";
        return "City: Invalid input format";
    } else {
        city.style.border = "none";
        localStorage.setItem("city", city.value);
        return "valid";
    }
}

function appropriateFields() {
    var option = document.getElementById("state").value;
    removeAdditionalFields();
    if (option == "Rajasthan") {
        addWebsiteDomain();
        addProjectDescription();
    } else if (option == "Haryana") {
        addZipCode();
        addHosting();
    } else if (option == "Maharashtra") {
        addZipCode();
        addProjectDescription();
    } else {
        return;
    }
}

function addZipCode() {
    var div1 = document.createElement('div');
    div1.setAttribute("class", "input-container");
    div1.setAttribute("id", "zip-div");
    var label = document.createElement("label");
    label.innerHTML = "Zip Code";
    div1.appendChild(label);
    var icon = document.createElement('i');
    icon.setAttribute("class", "fas fa-home icon");
    div1.appendChild(icon);
    var inputField = document.createElement('input');
    inputField.setAttribute("class", "input-field");
    inputField.setAttribute("type", "text");
    inputField.required = true;
    inputField.setAttribute("id", "zip-code");
    inputField.setAttribute("placeholder", "Zip Code");
    inputField.setAttribute("title", "Six letters zip code");
    div1.appendChild(inputField);
    document.getElementById('form-fields').appendChild(div1);
}

function addWebsiteDomain() {
    var div1 = document.createElement('div');
    div1.setAttribute("class", "input-container");
    div1.setAttribute("id", "website-div");
    var label = document.createElement("label");
    label.innerHTML = "Website or domain name";
    div1.appendChild(label);
    var icon = document.createElement('i');
    icon.setAttribute("class", "fas fa-globe-asia icon");
    div1.appendChild(icon);
    var inputField = document.createElement('input');
    inputField.setAttribute("class", "input-field");
    inputField.setAttribute("type", "text");
    inputField.setAttribute("id", "website");
    inputField.setAttribute("placeholder", "Website or domain name");
    inputField.setAttribute("title", "Include http://");
    div1.appendChild(inputField);
    document.getElementById('form-fields').appendChild(div1);
}

function addProjectDescription() {
    var div1 = document.createElement('div');
    div1.setAttribute("class", "input-container");
    div1.setAttribute("id", "description-div");
    var label = document.createElement("label");
    label.innerHTML = "Project Description";
    div1.appendChild(label);
    var icon = document.createElement('i');
    icon.setAttribute("class", "fas fa-pen icon");
    div1.appendChild(icon);
    var inputField = document.createElement('textarea');
    inputField.setAttribute("class", "input-field");
    inputField.setAttribute("id", "description");
    inputField.setAttribute("placeholder", "Project Description");
    div1.appendChild(inputField);
    document.getElementById('form-fields').appendChild(div1);
}

function addHosting() {
    var div1 = document.createElement('div');
    div1.setAttribute("class", "input-container");
    div1.setAttribute("id", "hosting-div");
    var label = document.createElement("label");
    label.innerHTML = "Do you have hosting?";
    div1.appendChild(label);
    var div2 = document.createElement('div');
    div2.setAttribute("id", "hosting-radio-div");

    var inputField = document.createElement('input');
    inputField.setAttribute("type", "radio");
    inputField.setAttribute("value", "Yes");
    inputField.setAttribute("id", "radioYes");
    inputField.setAttribute("name", "hosting");
    div2.appendChild(inputField);
    var spanYes = document.createElement('span');
    spanYes.innerHTML = "Yes";
    div2.appendChild(spanYes);
    div2.appendChild(document.createElement('br'));

    var inputField2 = document.createElement('input');
    inputField2.setAttribute("type", "radio");
    inputField2.setAttribute("value", "No");
    inputField.setAttribute("id", "radioNo");
    inputField2.setAttribute("name", "hosting");
    div2.appendChild(inputField2);
    var spanNo = document.createElement('span');
    spanNo.innerHTML = "No";
    div2.appendChild(spanNo);
    div1.appendChild(div2);
    document.getElementById('form-fields').appendChild(div1);
}

function removeAdditionalFields() {
    var zip = document.getElementById('zip-div');
    var description = document.getElementById('description-div');
    var hosting = document.getElementById('hosting-div');
    var website = document.getElementById('website-div');
    if (zip != null) {
        document.getElementById('form-fields').removeChild(zip);
    }
    if (description != null) {
        document.getElementById('form-fields').removeChild(description);
    }
    if (hosting != null) {
        document.getElementById('form-fields').removeChild(hosting);
    }
    if (website != null) {
        document.getElementById('form-fields').removeChild(website);
    }


}
