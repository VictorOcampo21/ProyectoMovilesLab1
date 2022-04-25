
var url = "http://localhost:8080/ProyectoMovilesLab1/";

function userLog() {
    let usuarioJson = JSON.parse(sessionStorage.getItem('user'));
    if (usuarioJson !== null) {
        $("#navLogin").hide();
        $("#navAccount").on('click', function () {
            switch (usuarioJson.role) {
                case 'Administrador':
                    document.location = url + 'vista/Admin.html';
                    break;
                case 'Estudiante':
                    document.location = url + 'vista/Estudiante.html';
                    break;
                case 'Profesor':
                    document.location = url + 'vista/Profesor.html';
                    break;
            }
        });
    } else {
        $("#navAccount").hide();
        $("#navRegisterAdmin").hide();
        $("#navRegisterStudent").hide();
        $("#navRegisterTeacher").hide();
        $("#navLogout").hide();
    }
}

function buscador(){
    let usuarioJson = JSON.parse(sessionStorage.getItem('user'));
    if (usuarioJson.role === "Administrador") {
        $(this).attr("href", url+ "?name=" + $("#searchAdministrador").val());
    }
    if(usuarioJson.role === "Cliente"){
        $(this).attr("href", url+ "?name=" + $("#searchBtnEstudiante").val());
    }
    if(usuarioJson.role === "Cliente"){
        $(this).attr("href", url+ "?name=" + $("#searchBtnProfesor").val());
    }
}

function inicializaNav(){
    userLog();
    $("#searchBtnAdmin").on("click", buscador);
    $("#searchBtnEstudiante").on("click", buscador);
    $("#searchBtnProfesor").on("click", buscador);
}
$(inicializaNav);
