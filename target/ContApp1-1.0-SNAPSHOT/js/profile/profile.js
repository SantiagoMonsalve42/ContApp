function getByEmail(){
   let email = localStorage.getItem("email") ;
   $.get("/ContApp1/usuario?TIPO_ACCION=GETBYEEMAIL&email="+email,
    function(response,status){
      if(response.code === 200){
          const user = document.getElementById("user");
          user.innerHTML = "<h5 class='mt-5'>Usuario: "+response.data.usuario+"</h5>";
          const email = document.getElementById("email");
          email.innerHTML = "<h5>Email: "+response.data.email+"</h5>";
          const documento = document.getElementById("documento");
          documento.innerHTML = "<h5>Documento: "+response.data.documento+"</h5>";
      }else{
          localStorage.clear();
          document.location = '/ContApp1/index.html';
      }
    });
}

getByEmail();