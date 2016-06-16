<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<form action="${linkTo[ApartamentoController].adiciona(null)}" method="post">
<img src = "">
Nome do Propietário: 
<input type "text" value = "${propietario.nome}" name="propietario.nome"id = "txtNomePropietario"> <br> <br>

<!-- depois fazer uma query para impedir que o mesmo propietario seja adicionado duas vezes  !-->
Telefone: 
<input type "text" value = "${propietario.telefone} name="propietario.telefone" id = "txtTelefonePropietario"> <br> 
<br> 
<input type = "button" value= "Cadastra">

</form>
</html>