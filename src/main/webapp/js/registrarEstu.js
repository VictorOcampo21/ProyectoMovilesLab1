var usuario = {id: "", password: "", role: "Estudiante"};
estudiante = {id: "", name: "", telefono: "", email: "", age: "", carrera: ""};
var url="http://localhost:8080/ProyectoMovilesLab1/";

function validarRegister() {
    var error = false;
    $("#registerStudentForm input").removeClass("invalid");
    error |= $("#registerStudentForm input[type='text']").filter((i, e) => {
        return e.value === '';
    }).length > 0;
    $("#registerStudentForm input[type='text']").filter((i, e) => {
        return e.value === '';
    }).addClass("invalid");
    error |= $("#registerStudentForm input[type='password']").filter((i, e) => {
        return e.value === '';
    }).length > 0;
    $("#registerStudentForm input[type='password']").filter((i, e) => {
        return e.value === '';
    }).addClass("invalid");
    var x = $("#registerStudentId").val();
    error |= isNaN(x);
    if (isNaN(x)) {
        $("#registerStudentId").addClass("invalid");
        $("#registerStudentModal #errorDivIdRegister").show();
        $("#pErrorIdRegister").text("Identificacion debe de ser numerica");
    }

    return !error;
}
function loadRegister() {
    usuario = {id: $("#registerStudentId").val(), password: $("#registerStudentPassword").val(), role: "Estudiante"};
    estudiante = {id: $("#registerStudentId").val(), name: $("#registerStudentName").val(), 
        telefono: $("#registerStudentTelefono").val(), email: $("#registerStudentEmail").val(),
    age: $("#registerStudentAge").val(), carrera: $("#registerStudentCarrera").val()};
}

function resetRegister() {
    usuario = {id: "", password: "", role: "Estudiante"};
    estudiante = {id: "", name: "", telefono: "", email: "", age: "", carrera: ""};
    $("#registerStudentId").val("");
    $("#registerStudentName").val("");
    $("#registerStudentTelefono").val("");
    $("#registerStudentEmail").val("");
    $("#registerStudentAge").val("");
    $("#registerStudentCarrera").val("");
    $("#registerStudentPassword").val("");
}

function addUser() {
    loadRegister();
    if (!validarRegister())
        return;
    let requestUser = new Request(url + 'api/registerEstu', {method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(usuario)});
    let requestEstu = new Request(url + 'api/register/estudiante', {method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(estudiante)});
    (async () => {
        const responseUser = await fetch(requestUser);
        const responseEstu = await fetch(requestEstu);
        if (!responseUser.ok) {
            errorMessageRegister(responseUser.status, $("#registerStudentModal #errorDivIdRegister"));
            return;
        }
        if (!responseEstu.ok) {
            console.log("Error");
            return;
        }

        resetRegister();
        document.location = url;
    })();

}

function renderRegister() {
    $("#registerStudentId").val(usuario.id);
    $("#registerStudentName").val("");
    $("#registerStudentPassword").val(usuario.password);
    $('#registerStudentBtn').on('click', addUser);
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
        $("#registerStudentModal #errorDivIdRegister").hide();
    } else {
        $("#registerStudentId").addClass("invalid");
        $("#registerStudentModal #errorDivIdRegister").show();
        $("#pErrorIdRegister").text(error);
    }
    return;
}
$(renderRegister);
