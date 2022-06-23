package controller;

import java.io.IOException;
import java.util.List;

/* libreria servelet*/
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* importar modelo*/
import model.GeneroDao;
import model.GeneroVo;


public class Genero extends HttpServlet {
    GeneroDao gdao=new GeneroDao();
    GeneroVo g=new GeneroVo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.println("Entró al DoGet");
        String accion=req.getParameter("accion");

        switch(accion){
            case "abrirForm":
            abrirForm(req,resp);
            break;
       
            case "listar":
            listar(req,resp);
            break;

            case "eliminar":
                eliminar(req,resp);
            break;

            case "generoEs":
                generoEs(req, resp);
            break;

            
            case "editarForm":
                editarForm(req, resp);
            break;
          
    }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String accion=req.getParameter("accion");

        switch(accion){
            case "add":
                addGenero(req,resp);
            break;
            case "editar":
                editar(req,resp);
            break;
        }
    }

        private void abrirForm(HttpServletRequest req, HttpServletResponse resp) {
            try{
                req.getRequestDispatcher("views/genero/formGenero.jsp").forward(req, resp);
                System.out.println("El formulario ha sido abierto");
            }catch(Exception e){
                System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
            }
    }

    private void addGenero(HttpServletRequest req, HttpServletResponse resp) {
        GeneroDao gdao=new GeneroDao();
        GeneroVo g=new GeneroVo();
        if(req.getParameter("nombreGenero")!=null){
            g.setNombreGenero(req.getParameter("nombreGenero"));
        }
        if(req.getParameter("chkestado")!=null){
            g.setEstadoGenero(true);
        }
        else{
            g.setEstadoGenero(false);
        }
        try {
            gdao.registrar(g);
            resp.sendRedirect("genero?accion=listar");
            System.out.println("Registro insertado correctamente");
        } catch (Exception e) {
            req.setAttribute("msje","No se pudo registrar el Genero"+e.getMessage());
            System.out.println("No se pudo registrar el Genero "+e.getMessage().toString());
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) {

        GeneroDao gdao=new GeneroDao();
        GeneroVo g=new GeneroVo();

        try {
            List<GeneroVo> genero=gdao.listar();
            req.setAttribute("generos", genero);
            req.getRequestDispatcher("views/genero/listGenero.jsp").forward(req, resp);
            System.out.println("Generos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los generos "+e.getMessage().toString());
        }
}

    private void generoEs(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idGenero")!=null) {
            g.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        if(req.getParameter("estadoGenero")!=null){
            g.setEstadoGenero(Boolean.parseBoolean(req.getParameter("estadoGenero")));
        }
        try{
            gdao.estadoGenero(g.getIdGenero(), g.getEstadoGenero());
            listar(req, resp);
            System.out.println("El estado es correcto");
        }
        catch(Exception e){
            req.setAttribute("msj", "No se pudo modificar el estado"+e.getMessage());
            System.out.println("No se pudo modificar el estado" +e.getMessage());
        }
    }

    
    private void eliminar(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idGenero")!=null){
            g.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));

        }
        try {
            gdao.eliminar(g.getIdGenero());
           /* request.getRequestDispatcher("viws/genero.jsp").
            forward(request,response);*/
            resp.sendRedirect("genero?accion=listar");
            System.out.println("Genero eliminado");
            
        } catch (Exception e) {
            req.setAttribute("msje", "No se elimino el registro"+e.getMessage());
            System.out.print("No se elimio el registro"+e.getMessage());
        }finally{
            
        }
    }

    private void editarForm(HttpServletRequest req, HttpServletResponse resp) {
        GeneroDao gdao=new GeneroDao();
        GeneroVo g=new GeneroVo();

        if(req.getParameter("idGenero")!=null) {
            g.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        
        try{
            List<GeneroVo> genero = gdao.listarG(g.getIdGenero());
            req.setAttribute("Generos", genero);            
            req.getRequestDispatcher("views/genero/editGenero.jsp").forward(req, resp);
            System.out.println("Formulario editar genero abierto correctamente");

        }

        catch(Exception e){
            System.out.println("Se presentó un error en el formulario de editar genero "+e.getMessage());
        }
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        
        if(req.getParameter("idGenero")!=null) {
            g.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));}
    
        if(req.getParameter("nombreGenero")!=null) {
            g.setNombreGenero(req.getParameter("nombreGenero"));
        }
        
        if(req.getParameter("chkestado")!=null) {
            g.setEstadoGenero(Boolean.parseBoolean(req.getParameter("chkestado")));
        }
        
        try{
            gdao.editar (g.getIdGenero(), g.getNombreGenero(), g.getEstadoGenero());
            listar(req, resp);
            System.out.println("Actualización correcta");
        }
                
        catch(Exception e){
            req.setAttribute("msje", "No se pudo actualizar el genero" + e.getMessage());
            System.out.println("No se pudo actualizar el genero" + e.getMessage());
        }
        
        finally{ 
            
        }
    }



    
}
