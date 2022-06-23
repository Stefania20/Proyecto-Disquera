<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href='assets/css/estilos.css'>
    <title>Disquera</title>
  
</head>
<body>

  <div class="cuadro">

    <div class="cuadro1">

            <center><h1 class="titulo">GENERO</h1></center>

            <a href="genero?accion=listar" style="text-decoration:none">Listas</a> <br>
            <a href="genero?accion=abrirForm" style="text-decoration:none">Formulario</a>
       
        </div>

        <div class="cuadro2"> 
        
            <center><h1 class="titulo">ALBÚM</h1></center>

            <a href="album?accion=listar" style="text-decoration:none">Listas</a> <br>
            <a href="album?accion=abrirForm" style="text-decoration:none">Formulario</a> 
        </div>
        
 </div>
    


</body>
</html>



