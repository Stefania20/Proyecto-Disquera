package model;

public class GeneroVo {
    private int idGenero;
    private String nombreGenero;
    private boolean estadoGenero;


    public GeneroVo(){

    }

    public GeneroVo(int idGenero,String nombreGenero,Boolean estadoGenero){
        this.idGenero=idGenero;
        this.nombreGenero=nombreGenero;
        this.estadoGenero=estadoGenero;
    }
   public int getIdGenero() {
       return idGenero;
   }
   public void setIdGenero(int idGenero) {
       this.idGenero = idGenero;
   }

   public String getNombreGenero() {
       return nombreGenero;
   }
   public void setNombreGenero(String nombreGenero) {
       this.nombreGenero = nombreGenero;
   }
   public boolean getEstadoGenero() {
       return estadoGenero;
   }
   public void setEstadoGenero(Boolean estadoGenero) {
       this.estadoGenero = estadoGenero;
   }
    
}
