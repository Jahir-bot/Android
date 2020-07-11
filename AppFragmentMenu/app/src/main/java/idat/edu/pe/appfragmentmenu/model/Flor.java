package idat.edu.pe.appfragmentmenu.model;

public class Flor {

    private String etiqueta;
    private String imgUrl;

    public Flor(String etiqueta, String imgUrl) {
        this.etiqueta = etiqueta;
        this.imgUrl = imgUrl;
    }
    public Flor()
    {

    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
