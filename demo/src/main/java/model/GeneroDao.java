package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class GeneroDao {
    //atributos
    Connection con; //objeto para la conexion
    PreparedStatement ps; //ojeto para las sentencias preparadas
    ResultSet rs; //objeto para almacenarlos resultados de las consultas
    String sql=null; // variable para almacenar las sentecias de SQL
    int r;

        public List<GeneroVo> listar() throws Exception{
        List<GeneroVo> generos=new ArrayList<>();

        sql="SELECT * FROM genero";
        try {
            con=Conexion.conectar();//abrir conexion
            ps=con.prepareStatement(sql);//prepara sentencias select
            System.out.println (ps);
            rs=ps.executeQuery(); // ejecutar la sentencias y guardamos los resultados
            while(rs.next()){
                GeneroVo r=new GeneroVo();
                r.setIdGenero(rs.getInt( "idGenero"));
                r.setNombreGenero(rs.getString("nombreGenero"));
                r.setEstadoGenero(rs.getBoolean("estadoGenero"));
                generos.add(r);

            }
            ps.close();

            System.out.println("Consulta exitosa");

        } catch (Exception e) {
            System.out.println("No hay generos definidos"+e.getMessage());
         }finally{
             con.close();//cerrando la conexion
         }
        return generos;

    }

    public int registrar(GeneroVo genero) throws SQLException{
        sql="INSERT INTO genero (nombreGenero,estadoGenero) values(?,?)";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.setString(1, genero.getNombreGenero());
            ps.setBoolean(2, genero.getEstadoGenero());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró el genero correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return r;

       
    }

    public int estadoGenero(int idGenero, boolean estadoGenero) throws SQLException{
        sql="UPDATE genero SET estadoGenero="+estadoGenero+"WHERE idGenero="+idGenero;
        System.out.println(sql);
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("El estado esta de forma correcta");
        }catch(Exception e){
            System.out.println("El estado esta de forma incorrecta"+e.getMessage());
        }
        finally{
            con.close();//cerrando conexión
        }
        return idGenero;
    }
    
    public int eliminar(int idGenero)throws SQLException{
        sql="DELETE FROM genero WHERE idGenero="+idGenero;
        System.out.println(sql);
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate(sql);
            ps.close();
            System.out.println("Se elimino de manera correcta");
        } catch (Exception e) {
            System.out.println("Error en la eliminacion"+e.getMessage());
        }finally{
            con.close();
        }
        return r;
    }

    public int editar(int idGenero, String nombreGenero, Boolean estadoGenero) throws SQLException{
		sql="UPDATE genero SET nombreGenero='"+nombreGenero+"',estadoGenero="+estadoGenero+" WHERE idGenero="+idGenero;
		System.out.println(sql);
		
		try {
			con=Conexion.conectar();
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			System.out.println("Actualizacion correcta");
		}
		
		catch(Exception e) {
			System.out.println("Actualizacion incorrecta "+e.getMessage());
		}
		
		finally {
			con.close();
		}
		
		return idGenero;
    }

    public List<GeneroVo> listarG(int idGenero) throws Exception{

		List<GeneroVo> genero=new ArrayList<>();
			sql="SELECT * FROM genero Where idGenero="+idGenero;
            System.out.println("se listan los datos");
			
			try {
				con=Conexion.conectar(); 
				ps=con.prepareStatement(sql); 
				rs=ps.executeQuery(sql);
				
				while(rs.next()) {
					GeneroVo g=new GeneroVo();
					g.setIdGenero(rs.getInt("idGenero"));
					g.setNombreGenero(rs.getString("nombreGenero"));
					g.setEstadoGenero(rs.getBoolean("estadoGenero"));
					
					genero.add(g);
				}
				
				ps.close(); 
				System.out.println("Consulta exitosa");
			}
			
			catch(Exception e) {
				System.out.println("Error de consulta"+e.getMessage());
			}
			
			finally {
				con.close(); 
			}
			
			return genero;
		}

    
}



