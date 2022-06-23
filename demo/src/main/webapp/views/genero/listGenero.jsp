
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href='assets/css/estilos.css'>
    <title>Listas</title>
</head>
<body>
    <h1>Lista de Generos</h1>

    <div class="flex-fill flex-grow-1 ms-3">

        <a type="button" class="btn btn-primary" href="genero?accion=abrirForm">
        <i class="bi bi-plus-circle"></i> 
        Agregar Genero
        </a>
      
       <table class="table table-hover table-bordered" id="datat">
       
              <tr>
                  <th>Id</th>
                  <th>Nombre</th>
                  <th><center>Estado</center></th>            
                  <th colspan="2"><center>Acciones</center></th>
              </tr>
              
      <c:forEach var="genero" items="${generos}">         
              
              <tr>
              <td>${genero.getIdGenero()}</td>
              <td>${genero.getNombreGenero()}</td>
                <c:if test="${genero.getEstadoGenero() == true}">
                 <td><span class="badge bg-success active">Genero activo</span></td> 
              </c:if>
              <c:if test="${genero.getEstadoGenero() == false}">
                  <td><span class="badge bg-danger active">Genero Inactivo</span></td> 
              </c:if>
              
              <td>
              <c:if test="${genero.getEstadoGenero() == true}">
                 <a genero="button" 
                 class="btn btn-danger btn-sm" 
                 href="genero?accion=generoEs&estadoGenero=false&idGenero=${genero.getIdGenero()}"> 
              Inactivar
              </a>
              </c:if>
              <c:if test="${genero.getEstadoGenero() == false}">
                  <a genero="button" 
                  class="btn btn-success btn-sm" 
                  href="genero?accion=generoEs&estadoGenero=true&idGenero=${genero.getIdGenero()}"
                >
              Activar
              </a>
              </c:if> 
              </td>
              
              
              <td>
              <a genero="button" 
              class="btn btn-warning" 
              href="genero?accion=editarForm&idGenero=${genero.getIdGenero()}">
              <i class="bi bi-pencil">Editar</i> 
              </a>
      
              <a genero="button" href="genero?accion=eliminar&idGenero=${genero.getIdGenero()}"
              class="btn btn-danger" 
              onclick="borrar(event,'${genero.getIdGenero()}','genero')">
              <i class="bi bi-trash">Eliminar</i> 
              </a>
              
              </td>
              <tr>
              
      </c:forEach>    
      
      
      </table>
      
      
      </div> 
      </div>
      <script src="assets/js/main.js"></script>
      
    
    
    
</body>
</html>