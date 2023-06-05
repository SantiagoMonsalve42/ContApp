function getByEmail(){
   let email = localStorage.getItem("email") ;
   $.post("/ContApp1/Cuenta?TIPO_ACCION=GET_ACCOUNTS&mail="+email,
    function(response,status){
      console.log(response);
      if(response.code === 200){
          if(response.data.length > 0){
            serializeResponse(response.data);
          }else{
            const result = document.getElementById("result");
            result.innerHTML = "<h5 class='text-center mt-4'>AUN NO TIENE CUENTAS INSCRITAS</h5>";  
          }
      }
    });
}
function serializeResponse(data){
   let resultHtml = "<table class='table'><thead>"+ 
                "<tr> <th scope='col'>#</th> <th scope='col'>NOMBRE CUENTA</th> <th scope='col'>TIPO CUENTA</th> <th scope='col'>ACCIONES</th> </tr> </thead>" +
                "<tbody>";
        
    for (let i =0; i< data.length ; i++){
        resultHtml+= "<tr> <th scope='row'>"+(i+1).toString()+"</th>"+
                     " <td>"+data[i].nombre+"</td> <td>"+data[i].Tipo_Cuenta+"</td>"+
                     " <td> <button type='button' class='btn btn-warning'>EDITAR</button> <button type='button' class='btn btn-danger'>ELIMINAR</button> </td>"+
                    "</tr>";
    }
    resultHtml +="</tbody></table>";
   const result = document.getElementById("result"); 
   result.innerHTML=resultHtml;
}
getByEmail();