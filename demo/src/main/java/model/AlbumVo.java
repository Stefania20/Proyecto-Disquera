package model;

public class AlbumVo {

    
    private int idAlbum;
    private String nombreAlbum;
    private int anioPublicacion; 
    private Boolean estadoAlbum;

    public AlbumVo() {
    }

    public AlbumVo(int idAlbum, String nombreAlbum, int anioPublicacion,
            Boolean estadoAlbum) {
        this.idAlbum = idAlbum;
        this.nombreAlbum = nombreAlbum;
        this.anioPublicacion = anioPublicacion;
        this.estadoAlbum = estadoAlbum;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Boolean getEstadoAlbum() {
        return estadoAlbum;
    }

    public void setEstadoAlbum(Boolean estadoAlbum) {
        this.estadoAlbum = estadoAlbum;
    }

    
}
