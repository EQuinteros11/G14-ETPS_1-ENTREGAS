package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases;

public class medicamentos {

    private String ID_MEDICA;
    private String  NOMBRE_MEDICA;
    private String CANTIDAD;
    private String UM;

    public medicamentos(String ID_MEDICA, String NOMBRE_MEDICA, String CANTIDAD, String UM) {
        this.ID_MEDICA = ID_MEDICA;
        this.NOMBRE_MEDICA = NOMBRE_MEDICA;
        this.CANTIDAD = CANTIDAD;
        this.UM = UM;
    }

    public medicamentos() {

    }

    public String getID_MEDICA() {
        return ID_MEDICA;
    }

    public void setID_MEDICA(String ID_MEDICA) {
        this.ID_MEDICA = ID_MEDICA;
    }

    public String getNOMBRE_MEDICA() {
        return NOMBRE_MEDICA;
    }

    public void setNOMBRE_MEDICA(String NOMBRE_MEDICA) {
        this.NOMBRE_MEDICA = NOMBRE_MEDICA;
    }

    public String getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(String CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public String getUM() {
        return UM;
    }

    public void setUM(String UM) {
        this.UM = UM;
    }


}
