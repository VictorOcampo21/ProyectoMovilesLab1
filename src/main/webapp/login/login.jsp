<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
              rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.12/css/all.css">         
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="icon" href="/ProyectoMovilesLab1/images/iconopagina.png" >
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
    </head>
    <body class="bg-dark text-white">
    <br>
    <div class="container">
        <div class="row text-center login-page justify-content-md-center">
            <div class="col-md-3 login-form">
                <form class="bg-secondary rounded">
                    <br>
                    <div class="row">
                        <div class="col-md-12 login-form-header">
                        <h2 class="login-form-font-header text-white">Iniciar Sesión<h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 login-from-row">
                            <input class="border text-center rounded" name="usuario" type="text" placeholder="Usuario" required/>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-12 login-from-row">
                            <input class="border text-center rounded" name="password" type="password" placeholder="Contraseña" required/>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-12 login-from-row">
                            <a class="btn btn-dark bg-dark text-white" href="">Entrar</a>
                        </div>
                    </div>
                    <br>

                    <div class="row">
                        <div class="col-md-12 login-from-row align-items-center">
                            <a class="text-white-50" href="/ProyectoMovilesLab1/login/registrarse.html">¿No tiene cuenta? Regístrese</a>
                        </div>
                    </div>
                    <br>
                </form>
                </div>
            </div>
            <br>
        </div>
    </body>
</html>
