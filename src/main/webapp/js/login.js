var url="http://localhost:8080/ProyectoMovilesLab1/";

function loginValidar() {
    var error = false;
    $("#logInForm input").removeClass("invalid");

    error |= $("#logInForm input[type='text']").filter((i, e) => {
        return e.value === '';
    }).length > 0;

    $("#logInForm input[type='text']").filter((i, e) => {
        return e.value === '';
    }).addClass("invalid");

    error |= $("#logInForm input[type='password']").filter((i, e) => {
        return e.value === '';
    }).length > 0;

    $("#logInForm input[type='password']").filter((i, e) => {
        return e.value === '';
    }).addClass("invalid");
    var x = $("#logInId").val();
    error |= isNaN(x);
    if (isNaN(x)) {
        $("#logInId").addClass("invalid");
        $("#logInModal #errorDivId").show();
        $("#pErrorId").text("Identificacion debe ser numerica");
    }
    return !error;
}

function login() {
    if (!loginValidar())
        return;
    usuario = {
        id: $("#logInId").val(),
        password: $("#logInPassword").val(),
        role: "unknown"
    };

    let request = new Request(url + 'api/login', {method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(usuario)});
    (async () => {
        const response = await fetch(request);
        if (!response.ok) {
            errorMessageLogin(response.status);//-----------------------
            console.log("Error login");
            return;
        }
        usuario = await response.json();
        sessionStorage.setItem('user', JSON.stringify(usuario));
        $('#loginDialog').modal('close');
        document.location = url;
    })();
}

function logout() {
    let request = new Request(url + 'api/login', {method: 'DELETE', headers: {}});
    (async () => {
        const response = await fetch(request);
        if (!response.ok) {
            errorMessageLogin(response.status);
            return;
        }
        sessionStorage.removeItem('user');
        document.location = url;
    })();
    return false;
}

function errorMessageLogin(status) {
    let error;
    switch (status) {
        case 404:
            error = "Contraseña incorrecta";
            break;
        case 403:
        case 405:
            error = "Usuario no autorizado";
            break;
        case 406:
        case 405:
        case 500:
            error = "Usuario no existe";
            break;
    }
    if (error === "" || error === null) {
        $("#logInModal #errorDivId").hide();
        $("#logInModal #errorDivPass").hide();

    } else {
        if (error === "Usuario no existe" || error === "Usuario no autorizado") {
            $("#logInId").addClass("invalid");
            $("#logInModal #errorDivId").show();
            $("#pErrorId").text(error);
            $("#logInModal #errorDivPass").hide();
        }
        if (error === "Contraseña incorrecta") {
            $("#logInModal #errorDivId").hide();
            $("#logInPassword").addClass("invalid");
            $("#logInModal #errorDivPass").show();
            $("#pErrorPass").text(error);
        }

    }
    return;
}

function loadAccountListeners() {
    $("#loginBtn").click(login);
    $(document).on('click', '#navLogout', logout);
    $(document).on('click', '#footerLogout', logout);
}

$(loadAccountListeners);