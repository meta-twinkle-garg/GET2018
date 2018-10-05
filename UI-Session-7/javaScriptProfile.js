function setFields() {
    if (localStorage.getItem("address") == "") {
        document.getElementById("form-fields").removeChild(document.getElementById("address-div"));
    } else {
        document.getElementById("address").value = localStorage.getItem("address");
        document.getElementById("address").readOnly = true;
    }
    if (localStorage.getItem("contact") == "") {
        document.getElementById("form-fields").removeChild(document.getElementById("phone-div"));
    } else {
        document.getElementById("contact").value = localStorage.getItem("contact");
        document.getElementById("contact").readOnly = true;
    }
    if (localStorage.getItem("city") == "") {
        document.getElementById("form-fields").removeChild(document.getElementById("city-div"));
    } else {
        document.getElementById("city").value = localStorage.getItem("city");
        document.getElementById("city").readOnly = true;
    }

    document.getElementById("firstName").value = localStorage.getItem("firstName");
    document.getElementById("lastName").value = localStorage.getItem("lastName");
    document.getElementById("email").value = localStorage.getItem("email");

    var state = localStorage.getItem("state");
    document.getElementById("firstName").readOnly = true;
    document.getElementById("lastName").readOnly = true;
    document.getElementById("email").readOnly = true;
    document.getElementById("state").disabled = true;

    document.getElementById("state").value = state;
    if (state == "Rajasthan") {
        if (localStorage.getItem("website") != "") {
            addWebsiteDomain();
            document.getElementById("website").value = localStorage.getItem("website");
            document.getElementById("website").readOnly = true;
        }
        addProjectDescription();
        document.getElementById("description").value = localStorage.getItem("projectDescription");
        document.getElementById("description").readOnly = true;
    } else if (state == "Haryana") {
        addZipCode();
        document.getElementById("zip-code").value = localStorage.getItem("zip");
        document.getElementById("zip-code").readOnly = true;
        if (localStorage.getItem("hosting") != "") {
            addHosting();
            document.getElementById("hosting").value = localStorage.getItem("hosting");
            document.getElementById("hosting").readOnly = true;
        }
    } else if (state == "Maharashtra") {
        addZipCode();
        document.getElementById("zip-code").value = localStorage.getItem("zip");
        document.getElementById("zip-code").readOnly = true;
        addProjectDescription();
        document.getElementById("description").value = localStorage.getItem("projectDescription");
        document.getElementById("description").readOnly = true;
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
    inputField.setAttribute("class", "input-field");
    inputField.setAttribute("type", "text");
    inputField.setAttribute("id", "hosting");
    div1.appendChild(inputField);
    document.getElementById('form-fields').appendChild(div1);
}
