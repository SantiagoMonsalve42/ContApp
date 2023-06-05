
function checkFormLogin(){
    if(formLoginIsValid()){
        document.getElementById("login_button").disabled = false;
    }else{
        document.getElementById("login_button").disabled = true;
    }
}
const validateEmail = (email) => {
  return email.match(
    /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
  );
};
function formLoginIsValid(){
    let email = document.getElementById("email_login").value;
    let pass = document.getElementById("pass_login").value;
    return (email != '' && pass != '' && validateEmail(email) && pass.length > 3);
}
function login(){
    let email = document.getElementById("email_login").value;
    let pass = document.getElementById("pass_login").value;
    $.post("usuario",
    {
      TIPO_ACCION: "LOGIN",
      email,
      pass
    },
    function(data,status){
      if(data.code != 200){
          alert(data.message);
      }else{
          localStorage.setItem("email",email);
          document.location = '/ContApp1/profile/index.html';
      }
    });
}


