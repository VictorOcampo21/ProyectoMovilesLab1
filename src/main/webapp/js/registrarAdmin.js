var url="http://localhost:8080/ProyectoMovilesLab1/";

    function register(){
        if (!valRegister()) return;
        usuario = {
            id: $("#r_id").val(),
            pass: $("#r_pass").val()
        };       
        console.log(usuario);
        let request = new Request(url+'api/register', {method: 'POST', headers: { 'Content-Type': 'application/json'},body: JSON.stringify((usuario))});
        (async ()=>{
            const response = await fetch(request);
            if (!response.ok) {errorMessage(response.status,$("#registerDialog #r_errorDiv"));return;}
            $('#registerDialog').modal('hide');
            document.location = url;
            
        })(); 
    }

    function valRegister(){
        $("#registerForm").addClass("was-validated");
        return $("#registerForm").get(0).checkValidity(); 
    }
  function errorMessage(status,place){  
        switch(status){
            case 404: error= "Registro no encontrado"; break;
            case 403: case 405: error="Usuario no autorizado"; break;
            case 406: case 405: error="Usuario ya existe"; break;
        };            
        place.html('<div class="alert alert-danger fade show">' +
        '<button type="button" class="close" data-dismiss="alert">' +
        '&times;</button><h4 class="alert-heading">Error!</h4>'+error+'</div>');
        return;        
    }  
  
  function loadRegister(){
        let request = new Request(url+'register.html', {method: 'GET'});
        (async ()=>{
            const response = await fetch(request);
            if (!response.ok) {errorMessage(response.status,$("#registerDialog #r_errorDiv"));return;}
            content = await response.text();
            $('body').append(content); 
            $("#register").click(register);                         
        })();     
  }
  
  $(loadRegister);  

