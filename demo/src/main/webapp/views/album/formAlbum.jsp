<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script type="text/javascript" src="https://cdn.jsdelivr.net/gh/mobius1/vanilla-Datatables@latest/vanilla-dataTables.min.js"></script>
  <link rel="stylesheet" href='assets/css/estilos.css'>
  <title>Disquera</title>
</head>
<body>
    <h1>Registro de Album</h1>

  <div class="flex-fill flex-grow-1 ms-3">
    
    <form action="album" method="post">
        <div class="form-group">
            <label for="nombreAlbum">Nombre Album</label>
            <input type="text" name="nombreAlbum" id="nombreAlbum" class="form-control">
        </div>

        <div class="form-group">
            <label for="anioPublicacion">Año Publicacion</label>
            <input type="text" name="anioPublicacion" id="anioPublicacion" class="form-control">
        </div>
    
        <div class="form-check">
            <input type="checkbox" name="chkestado" id="chkestado" checked class="form-check-input">
            <label for="chkestado"> Activo</label>
        </div>
    
        <div>
            <button type="submit" class="btn btn-primary" name="accion" value="addAlbum">Guardar</button>
        </div>
    </form>
</body>
</html>