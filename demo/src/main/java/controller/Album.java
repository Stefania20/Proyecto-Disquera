package controller;

import java.io.IOException;
import java.util.List;

/* libreria servelet*/
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* importar modelo*/
import model.AlbumDao;
import model.AlbumVo;

public class Album extends HttpServlet{

    AlbumDao ald=new AlbumDao();
    AlbumVo alv=new AlbumVo();

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        System.out.print("Entró al DoGet del Servlet album");
        String accion=req.getParameter("accion");

        switch(accion){
            
            case "abrirForm":
                abrirForm(req,resp);
            break;
            case "editarForm":
                editarForm(req,resp);
            break;
            case "listar":
                listar(req,resp);
            break;
            case "editar":
                editar(req,resp);
            break;
            case "eliminar":
                eliminar(req,resp);
            break;
            case "estado":
                estadoAlbum(req, resp);
            break;
            
        }
    }

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.print("Entró al DoPost del Servlet album");
        String accion=req.getParameter("accion");

        switch(accion){
            case "addAlbum":
                addAlbum(req,resp);
            break;
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        
        AlbumDao ald=new AlbumDao();
        AlbumVo alv=new AlbumVo(); 
        
        try{
            List<AlbumVo> album = ald.listar();
            req.setAttribute("albumes", album);
            req.getRequestDispatcher("views/album/listAlbum.jsp").forward(req, resp); 
            System.out.println("Albumes encontrados");
        }
            
        catch(Exception e){
            req.setAttribute("msje", "No se listaron los Albumes" + e.getMessage());
            System.out.println("No se listaron los Albumes" + e.getMessage());
        }
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        
        //if(req.getParameter("id")!=null) {
        //alv.setIdAlbum(Integer.parseInt(req.getParameter("id")));}

        if(req.getParameter("nombreAlbum")!=null) {
            alv.setNombreAlbum(String.valueOf(req.getParameter("nombreAlbum")));
        }

        if(req.getParameter("anioPublicacion")!=null) {
            alv.setAnioPublicacion(Integer.parseInt(req.getParameter("anioPublicacion")));
        }
        
        if(req.getParameter("EstadoAlbum")!=null) {
            alv.setEstadoAlbum(Boolean.parseBoolean(req.getParameter("EstadoAlbum")));
        }
        
        try{
            ald.editar (alv.getIdAlbum(), alv.getNombreAlbum(), alv.getAnioPublicacion());
            listar(req, resp);
            System.out.println("Estado correcto");
        }
                
        catch(Exception e){
            req.setAttribute("msje", "No se pudo actualizar el album" + e.getMessage());
            System.out.println("No se pudo actualizar el album" + e.getMessage());
        }
        
        finally{ 
        }
    }
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        
        if(req.getParameter("idAlbum")!=null) {
            alv.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));
        }
    
        try{
            ald.eliminar(alv.getIdAlbum());
            //request.getRequestDispatcher("views/role-edit.jsp").forward(request, response);
            resp.sendRedirect("album?accion=listar");
            System.out.println("album Eliminado");
        }
            
        catch(Exception e){
            req.setAttribute("msje", "No se pudo eliminar el registro de album" + e.getMessage());
            System.out.println("No se pudo eliminar el registro de album" + e.getMessage());

        }    
            
        finally{       
        }
    }

    private void estadoAlbum(HttpServletRequest req, HttpServletResponse resp) {
        
        if(req.getParameter("idAlbum")!=null) {
        alv.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));}
    
        if(req.getParameter("estadoAlbum")!=null) {
        alv.setEstadoAlbum(Boolean.parseBoolean(req.getParameter("estadoAlbum")));}
    
        try{
            ald.estadoAlbum(alv.getIdAlbum(), alv.getEstadoAlbum());
            listar(req, resp);
            System.out.println("Estado correcto");}
            
        catch(Exception e){
            req.setAttribute("msje", "No se cambio el estado del album" + e.getMessage());
            System.out.println("No se cambio el estado de album" + e.getMessage());}
        
        finally{

        }
    }

    
    private void addAlbum(HttpServletRequest req, HttpServletResponse resp) {

        //Validar datos

        if(req.getParameter("nombreAlbum")!=null){
            alv.setNombreAlbum(req.getParameter("nombreAlbum"));
        }
        
        if(req.getParameter("anioPublicacion")!=null){
            alv.setAnioPublicacion(Integer.parseInt(req.getParameter("anioPublicacion")));
        }
        
        if(req.getParameter("chkestado")!=null){
            alv.setEstadoAlbum(true);
        }
    
        else{
            alv.setEstadoAlbum(false);
        }

        try{
            ald.registrar(alv);
            resp.sendRedirect("album?accion=listar");
            System.out.println("Se realizó el registro del album");
            listar(req, resp);
        }

        catch(Exception e){
            System.out.println("Se presentó un error en el registro del album "+e.getMessage().toString());
        }
    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) {

        try{
            req.getRequestDispatcher("views/album/formAlbum.jsp").forward(req, resp);
            System.out.println("Formulario de album abierto correctamente");
        }
        
        catch(Exception e){
        System.out.println("Formulario de album NO abierto correctamente"+e.getMessage().toString());
        }
    }

    private void editarForm(HttpServletRequest req, HttpServletResponse resp) {

        try{
            req.getRequestDispatcher("views/album/formAlbum.jsp").forward(req, resp);
            System.out.println("Formulario de album abierto correctamente");
        }
        
        catch(Exception e){
        System.out.println("Formulario de album NO abierto correctamente"+e.getMessage().toString());
        }
    }


}
        



