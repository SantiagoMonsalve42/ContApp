<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
        <link rel="stylesheet" href="estilos/estilos.css">
    </head>
    <body>
        <div class="row m-2">
            <h1 class="display-6 text-end red-title">CONTAPP</h1>
        </div>
        <div class="container container-color ">
            <div class="d-flex flex-column min-vh-100 justify-content-center align-items-center">
                <h1 class="display-6 text-end">REGISTRO</h1>
                    <form action="usuario" method="post">
                        <div class="mb-3">
                          <label for="exampleInputEmail1" class="form-label">Correo</label>
                          <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                        </div>
                        <div class="mb-3">
                          <label for="exampleInputPassword1" class="form-label">Contraseña</label>
                          <input type="password" class="form-control" id="exampleInputPassword1">
                        </div>
                       <div class="d-grid gap-2">
                            <button class="btn btn-danger" type="submit">INICIAR SESIÓN</button>
                            <p><a href="login.jsp" 
                             class="link-danger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">¿Ya tiene una cuenta? Inicie Sesión</a>
                            </p> 
                       </div>
                       
                    </form>
            </div>
        </div>
    </body>
</html>
