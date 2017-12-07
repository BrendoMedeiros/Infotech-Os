package infotech.model;

public class ImagensModel {

    private int idImagens;
    private String url;
    private int tipo;
    private int imIdOs;

    public ImagensModel(int idImagens, String url, int tipo, int imIdOs) {
        this.idImagens = idImagens;
        this.url = url;
        this.tipo = tipo;
        this.imIdOs = imIdOs;
    }

    public int getIdImagens() {
        return idImagens;
    }

    public void setIdImagens(int idImagens) {
        this.idImagens = idImagens;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getImIdOs() {
        return imIdOs;
    }

    public void setImIdOs(int imIdOs) {
        this.imIdOs = imIdOs;
    }

}
