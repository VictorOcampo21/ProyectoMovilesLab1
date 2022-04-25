var usuario = {id: "", password: "", role: "Profesor"};
profesor = {id: "", name: "", telefono: "", email: ""};
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
    error |= $("#registerTeacherForm input[type='password']").filter((i, e) => {
        return e.value === '';
    }).length > 0;
    $("#registerTeacherForm input[type='password']").filter((i, e) => {
        return e.value === '';
    }).addClass("invalid");
    var x = $("#registerTeacherId").val();
    error |= isNaN(x);
    if (isNaN(x)) {
        $("#registerTeacherId").addClass("invalid");
        $("#registerTeacherModal #errorDivIdRegister").show();
        $("#pErrorIdRegister").text("Identificacion debe de ser numerica");
    }

    return !error;
}
function loadRegister() {
    usuario = {id: $("#registerTeacherId").val(), password: $("#registerTeacherPassword").val(), role: "Estudiante"};
    profesor = {id: $("#registerTeacherId").val(), name: $("#registerTeacherName").val(), 
        telefono: $("#registerTeacherTelefono").val(), email: $("#registerTeacherEmail").val()};
}

function resetRegister() {
    usuario = {id: "", password: "", role: "Estudiante"};
    profesor = {id: "", name: "", telefono: "", email: "", age: "", carrera: ""};
    $("#registerTeacherId").val("");
    $("#registerTeacherName").val("");
    $("#registerTeacherTelefono").val("");
    $("#registerTeacherEmail").val("");
    $("#registerTeacherPassword").val("");
}

function addUser() {
    loadRegister();
    if (!validarRegister())
        return;
    let requestUser = new Request(url + 'api/registerProfesor', {method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(usuario, profesor)});
    (async () => {
        const responseUser = await fetch(requestUser);
        if (!responseUser.ok) {
            errorMessageRegister(responseUser.status, $("#registerTeacherModal #errorDivIdRegister"));
            return;
        }

        resetRegister();
        document.location = url;
    })();

}

function renderRegister() {
    $("#registerTeacherId").val(usuario.id);
    $("#registerTeacherName").val("");
    $("#registerTeacherPassword").val(usuario.password);
    $('#registerTeacherBtn').on('click', addUser);
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
        $("#registerTeacherModal #errorDivIdRegister").hide();
    } else {
        $("#registerTeacherId").addClass("invalid");
        $("#registerTeacherModal #errorDivIdRegister").show();
        $("#pErrorIdRegister").text(error);
    }
    return;
}
$(renderRegister);
