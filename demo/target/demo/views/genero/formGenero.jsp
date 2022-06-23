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
    <h1>Registro de Generos</h1>

  <div class="flex-fill flex-grow-1 ms-3">

    <form action="genero" method="post">
        <div class="form-group">
            <label for="nombreGenero">Nombre Genero</label>
            <input type="text" name="nombreGenero" id="nombreGenero" class="form-control">
        </div>
    
        <div class="form-check">
            <input type="checkbox" name="chkestado" id="chkestado" checked class="form-check-input">
            <label for="chkestado"> Activo</label>
        </div>
    
        <div>
            <button type="submit" class="btn btn-primary" name="accion" value="add">Guardar</button>
        </div>
    </form>
</body>
</html>