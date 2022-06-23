package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDao{
    //atributos
    Connection con; //objeto para la conexion
    PreparedStatement ps; //ojeto para las sentencias preparadas
    ResultSet rs; //objeto para almacenarlos resultados de las consultas
    String sql=null; // variable para almacenar las sentecias de SQL
    int r;

    public List<AlbumVo> listar() throws Exception{

        List<AlbumVo> albumes=new ArrayList<>();
		sql="SELECT * FROM album";

        
		try {
			con=Conexion.conectar(); 
			ps=con.prepareStatement(sql);
			System.out.println(ps); 
			rs=ps.executeQuery(sql);
			
			while(rs.next()) {
				AlbumVo r=new AlbumVo();

               r.setIdAlbum(rs.getInt("idAlbum"));
               r.setNombreAlbum(rs.getString("nombreAlbum"));
               r.setAnioPublicacion(rs.getInt("anioPublicacion"));
		       r.setEstadoAlbum(rs.getBoolean("estadoAlbum"));
				
				albumes.add(r);
			}
			
			ps.close();
			System.out.println("Consulta exitosa");
			
		}
		
		catch(Exception e) {
			System.out.println("No existen albumes definidos"+e.getMessage());
		}
		
		finally {
			con.close(); 
		}
		
		return albumes;
	}

    public int registrar(AlbumVo album) throws SQLException{

        sql="INSERT INTO album(nombreAlbum,anioPublicacion,estadoAlbum) VALUES(?,?,?)";
        try{
            con=Conexion.conectar(); //abrir conexion
            ps=con.prepareStatement(sql); //Preparar sentencia
            ps.setString(1,album.getNombreAlbum());
            ps.setInt(2,album.getAnioPublicacion());
            ps.setBoolean(3,album.getEstadoAlbum());
            System.out.println(ps);
            ps.executeUpdate(); //ejecución sentencia preparada
            ps.close(); //cerrar sentencia
            System.out.println("Se registró el Album");


        }
		
		catch(Exception e){
            System.out.println("Se presentó un error en el registro del Album "+e.getMessage().toString());
        }
        
		finally{
            con.close();//cerrar conexión
        }
        
		return r;
    }

    public int editar(int idAlbum, String nombreAlbum, int anioPublicacion) throws SQLException{
		sql="UPDATE album SET nombreAlbum= "+nombreAlbum+" ,anioPublicacion= "+anioPublicacion+" WHERE idAlbum="+idAlbum;
		System.out.println(sql);
		
		try {
			con=Conexion.conectar();
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			System.out.println("Actualizacion correcto");
		}
		
		catch(Exception e) {
			System.out.println("Actualizacion incorrecto "+e.getMessage());
		}
		
		finally {
			con.close();
		}
		
		return idAlbum;
    }

    public void eliminar(int idAlbum) throws SQLException {
		sql="DELETE FROM album WHERE idAlbum="+idAlbum;
		System.out.println(sql);
		
		try {
			con=Conexion.conectar();
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			System.out.println("Se eliminó el album");
		}
		
		catch(Exception e) {
			System.out.println("Error en la eliminación del registro de album "+e.getMessage());
		}
		
		finally {
			con.close();
		}
	}

    public void estadoAlbum(int idAlbum, Boolean boolean1) throws SQLException {
		sql="UPDATE album SET estadoAlbum= "+boolean1+" WHERE idAlbum="+idAlbum;
		System.out.println(sql);
		
		try {
			con=Conexion.conectar();
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			System.out.println("Estado correcto");
		}
		catch(Exception e) {
			System.out.println("Estado incorrecto "+e.getMessage());
		}
		
		finally {
			con.close();
		}
	}  
    

        

}



