package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases;

public class detallefarmacia {

    private String ID_FAR_DET;
    private String ID_CAT_DET;
    private String ID_MEDICA_DET;
    private String CANTIDAD_DET;
    private String PRECIO_DET;
    private String FKID_FARM;

    public detallefarmacia() {

    }


    public detallefarmacia(String ID_FAR_DET, String ID_CAT_DET, String ID_MEDICA_DET, String CANTIDAD_DET, String PRECIO_DET, String FKID_FARM) {
        this.ID_FAR_DET = ID_FAR_DET;
        this.ID_CAT_DET = ID_CAT_DET;
        this.ID_MEDICA_DET = ID_MEDICA_DET;
        this.CANTIDAD_DET = CANTIDAD_DET;
        this.PRECIO_DET = PRECIO_DET;
        this.FKID_FARM = FKID_FARM;
    }

    public String getID_FAR_DET() {
        return ID_FAR_DET;
    }

    public void setID_FAR_DET(String ID_FAR_DET) {
        this.ID_FAR_DET = ID_FAR_DET;
    }

    public String getID_CAT_DET() {
        return ID_CAT_DET;
    }

    public void setID_CAT_DET(String ID_CAT_DET) {
        this.ID_CAT_DET = ID_CAT_DET;
    }

    public String getID_MEDICA_DET() {
        return ID_MEDICA_DET;
    }

    public void setID_MEDICA_DET(String ID_MEDICA_DET) {
        this.ID_MEDICA_DET = ID_MEDICA_DET;
    }

    public String getCANTIDAD_DET() {
        return CANTIDAD_DET;
    }

    public void setCANTIDAD_DET(String CANTIDAD_DET) {
        this.CANTIDAD_DET = CANTIDAD_DET;
    }

    public String getPRECIO_DET() {
        return PRECIO_DET;
    }

    public void setPRECIO_DET(String PRECIO_DET) {
        this.PRECIO_DET = PRECIO_DET;
    }

    public String getFKID_FARM() {
        return FKID_FARM;
    }

    public void setFKID_FARM(String FKID_FARM) {
        this.FKID_FARM = FKID_FARM;
    }
}
