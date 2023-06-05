/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function checkFormRegister(){
    if(formRegisterIsValid()){
        document.getElementById("login_button").disabled = false;
        document.getElementById("alerta").style ='display: none';
    }else{
        document.getElementById("login_button").disabled = true;
        document.getElementById("alerta").style ='display: block';
    }
}
const validateEmail = (email) => {
  return email.match(
    /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
  );
};
function verifyEmailControl(){
    let email = document.getElementById("mail").value;
    if(email != '' && validateEmail(email)){
        return true;
    }else{
        return false;
    }
}
function verifyDocumentoControl(){
    let documento = document.getElementById("documento").value;
    if(documento != '' && documento.length >= 5){
        return true;
    }else{
        return false;
    }
}
function verifyTDocumentoControl(){
    let tipo_documento = document.getElementById("tipo_documento").value;
    if([1,2,3].includes(Number(tipo_documento))){
        return true;
    }else{
        return false;
    }
}
function verifyUserControl(){
    let user = document.getElementById("user").value;
    if(user != '' && user.length >= 4){
        return true;
    }else{
        return false;
    }
}
function verifyPassControl(){
    var strongRegex = new RegExp("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})");
    let pass = document.getElementById("pass").value;
    if(pass != '' && pass.length >= 4 && strongRegex.test(pass)){
        return true;
    }else{
        return false;
    }
}
function verifyPassEquals(){
    let pass = document.getElementById("pass").value;
    let pass_c = document.getElementById("pass_confirm").value;
    return pass == pass_c;
}
function formRegisterIsValid(){
    let messageError = '';
    let emailIsValid = verifyEmailControl();
    let documentoIsValid = verifyDocumentoControl();
    let tDocumentoIsValid = verifyTDocumentoControl();
    let userIsValid = verifyUserControl();
    let verifyStrongPass = verifyPassControl();
    let verifyEqualPass = verifyPassEquals();
    let arrayControls = [emailIsValid,documentoIsValid,tDocumentoIsValid,userIsValid,verifyStrongPass,verifyEqualPass];
    if(arrayControls.every(x=> x == true)){
        return true;
    }
    if(!emailIsValid){messageError += "El correo no tiene un formato valido. <br>";}
    if(!documentoIsValid){messageError += "El documento no tiene un formato valido. <br>";}
    if(!tDocumentoIsValid){messageError += "El tipo documento no tiene un formato valido. <br>";}
    if(!userIsValid){messageError += "El usuario no tiene un formato valido. <br>";}
    if(!verifyStrongPass){messageError += "La contraseña ingresada no cumple con los requisitos de seguridad. <br>";}
    if(!verifyEqualPass){messageError += "Las contraseñas ingresadas no son iguales <br>";}
    if(messageError != ''){
        const alert = document.getElementById("alerta");
        alert.innerHTML = messageError;
    }
    return false;
}

function register(){
    let mail = document.getElementById("mail").value;
    let pass = document.getElementById("pass").value;
    let documento = document.getElementById("documento").value;
    let tipo_documento = document.getElementById("tipo_documento").value;
    let user = document.getElementById("user").value;
    
    $.post("usuario",
    {
      TIPO_ACCION: "REGISTRO",
      mail,
      pass,
      tipo_documento,
      documento,
      user
    },
    function(data,status){
      if(data.code != 200){
          alert(data.message);
      }else{
          alert("Registro exitoso");
          document.location = '/ContApp1/index.html';
      }
    });
}