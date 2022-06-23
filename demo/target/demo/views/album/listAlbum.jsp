<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%><!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <h1>Lista de Album</h1>

    <div class="login">

        <a type="button" class="btn btn-primary" href="album?accion=abrirForm">
        <i class="bi bi-plus-circle"></i> 
        Agregar Album
        </a>
      
       <table class="table table-hover table-bordered" id="datat">
       
              <tr>
                  <th>Id</th>
                  <th>Nombre Album</th>
                  <th>Año Publicacion</th>
                  <th><center>Estado</center></th>            
                  <th colspan="2"><center>Acciones</center></th>
              </tr>
              
      <c:forEach var="album" items="${albumes}">         
              
              <tr>
              <td>${album.getIdAlbum()}</td>
              <td>${album.getNombreAlbum()}</td>
              <td>${album.getAnioPublicacion()}</td>
                <c:if test="${album.getEstadoAlbum() == true}">
                 <td><span class="badge bg-success active">Album Activo</span></td> 
              </c:if>
              <c:if test="${album.getEstadoAlbum() == false}">
                  <td><span class="badge bg-danger active">Album Inactivo</span></td> 
              </c:if>
              
              <td>
              <c:if test="${album.getEstadoAlbum() == true}">
                 <a rol="button" 
                 class="btn btn-danger btn-sm" 
                 onclick=""> 
              Inactivar
              </a>
              </c:if>
              <c:if test="${album.getEstadoAlbum() == false}">
                  <a rol="button" 
                  class="btn btn-success btn-sm" 
                >
              Activar
              </a>
              </c:if> 
              </td>
              
              
              <td>
              <a rol="button" 
              class="btn btn-warning" 
              href="album?accion=editarForm&idAlbum=${album.getIdAlbum()}">
              <i class="bi bi-pencil">Editar</i> 
              </a>
      
              <a rol="button" href="album?accion=eliminar&idAlbum=${album.getIdAlbum()}"
              class="btn btn-danger" 
              onclick="borrar(event,'${album.getIdAlbum()}','album')">
              <i class="bi bi-trash">Eliminar</i> 
              </a>
              
              </td>
              <tr>
              
      </c:forEach>    
      
      
      </table>
      
      
      </div> 
      </div>
      
    
    
    
</body>
</html>