var usuario = {id: "", password: "", role: "Cliente"};
var cliente = {id: "", name: ""};
var url="http://localhost:8080/ProyectoMovilesLab1/";

function validarRegister() {
    var error = false;
    $("#registerAdminForm input").removeClass("invalid");
    error |= $("#registerAdminForm input[type='text']").filter((i, e) => {
        return e.value === '';
    }).length > 0;
    $("#registerAdminForm input[type='text']").filter((i, e) => {
        return e.value === '';
    }).addClass("invalid");
    error |= $("#registerAdminForm input[type='password']").filter((i, e) => {
        return e.value === '';
    }).length > 0;
    $("#registerAdminForm input[type='password']").filter((i, e) => {
        return e.value === '';
    }).addClass("invalid");
    var x = $("#registerAdminId").val();
    error |= isNaN(x);
    if (isNaN(x)) {
        $("#registerAdminId").addClass("invalid");
        $("#registerAdminModal #errorDivIdRegister").show();
        $("#pErrorIdRegister").text("Identificacion debe de ser numerica");
    }

    return !error;
}
function loadRegister() {
    usuario = {id: $("#registerAdminId").val(), password: $("#registerAdminPassword").val(), role: "Administrador"};
}

function resetRegister() {
    usuario = {id: "", password: "", role: "Administrador"};
    $("#registerAdminId").val("");
    $("#registerAdminPassword").val("");
}

function addUser() {
    loadRegister();
    if (!validarRegister())
        return;
    let requestUser = new Request(url + 'api/registerAdmin', {method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(usuario)});
    (async () => {
        const responseUser = await fetch(requestUser);
        if (!responseUser.ok) {
            errorMessageRegister(responseUser.status, $("#registerAdminModal #errorDivIdRegister"));
            return;
        }
        if (!responseClient.ok) {
            console.log("Error");
            return;
        }

        resetRegister();
        document.location = url;
    })();

}

function renderRegister() {
    $("#registerAdminId").val(usuario.id);
    $("#registerAdminPassword").val(usuario.password);
    $('#registerBtn').on('click', addUser);

}



function errorMessageRegister(status, place) {
    let error = "";
    switch (status) {
        case 404:
            error = "Registro no encontrado";
            break;
        case 403:
        case 405:
            error = "Usuario no autorizado";
            break;
        case 406:
        case 405:
            error = "Usuario ya existe";
            break;
    }
    ;
    if (error === "" || error === null) {
        $("#registerAdminModal #errorDivIdRegister").hide();
    } else {
        $("#registerAdminId").addClass("invalid");
        $("#registerAdminModal #errorDivIdRegister").show();
        $("#pErrorIdRegister").text(error);
    }
    return;
}
$(renderRegister);