var menu=`
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <div class="container-fluid bg-secondary">
            <div class="col-ms-4 col-md-4">
                <img src="https://cdn-icons-png.flaticon.com/128/4207/4207253.png" class="img-responsive col-ms-2 col-md-2">
            </div>        
            <br/>
        </div>
        <div class="collapse navbar-collapse" id="menu">
        <ul class="navbar-nav ml-auto" id="menuUl">`;  
          
            let usuarioJson = sessionStorage.getItem('user');
            
            if (usuarioJson!==null){ 
                let usuario= JSON.parse(usuarioJson);
                if (['ADM', 'ESTU', 'PROFE'].includes(usuario.role)){
                    if(usuario.role == 'ADM'){
                        menu+=`
                        <li 
                           class='nav-item'> <a class='nav-link' href='#'>Registrar una sala</a> 
                        </li>
                        <li 
                           class='nav-item'> <a class='nav-link' href='#'>Programar Proyecciones</a> 
                        </li>
                        <li 
                           class='nav-item'> <a class='nav-link' href='#'>Imprimir Tiquetes</a> 
                        </li>`;
                    }
                    if(usuario.role == 'ESTU'){
                        menu+=`<li class='nav-item'> <a class='nav-link' href='#'>Ver compras</a> </li>`;
                    }
                    if(usuario.role == 'PROFE'){
                        menu+=`<li class='nav-item'> <a class='nav-link' href='#'>Ver compras</a> </li>`;
                    }
                    
                }

                menu+=`
                    <li class='nav-item dropdown'>
                      <a class='nav-link dropdown-toggle' data-toggle='dropdown' href='#'> ${usuario.name}</a>
                      <div class='dropdown-menu'>
                        <a class='dropdown-item' id='logout'>Cerrar sesion</a>
                      </div>
                    </li>
                    `;                
            }
            else{
              menu+=`
              <div class='ms-1 col-md-11 bg-secondary rounded'>
                <div class='col-ms-1 col-md-4'>
                    <li class='nav-item'>
                        <a class='nav-link' href='/ProyectoMovilesLab1/login/login.jsp' data-toggle='modal' data-target='#loginDialog'>Ingresar</a>
                    </li>
                </div>        
                <br/>
              </div>`;           
            }
            menu+=`
        </ul>
      </div>
    </div>
  </nav>`;
  
  function loadMenu(){
    $('body').prepend(menu); 
  }
  
  $(loadMenu);

