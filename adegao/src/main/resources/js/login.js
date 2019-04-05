 
function validarLogin(entrar)
{
	var usuario = document.getElementById("usuario").value;
	var senha = document.getElementById("senha").value;
	
	if(form.usuario.value == "admin" && form.senha.value=="admin" )
	{
		alert ("Bem-vindo ao Adegão, administrador!");
		window.location = "produtos-admin.html"; 
		return true;
	}
	else if(form.usuario.value == "usuario" && form.usuario.value="usuario" )
	{
		alert ("Bem-vindo ao Adegão!");
		window.location = "produtos.html";
		return true;
	}
	else
	{
		alert("Usuario ou senha incorretos!");
		document.getElementById("usuario").disabled = true;
		document.getElementById("senha").disabled = true;
		document.getElementById("logar").disabled = true;
		return false;
	}
}

