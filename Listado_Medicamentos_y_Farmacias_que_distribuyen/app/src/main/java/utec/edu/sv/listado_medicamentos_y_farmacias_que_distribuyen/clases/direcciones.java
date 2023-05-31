package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases;

public class direcciones {
    private String ID_DIR;
    private String  LOCATION;
    private String DEPARTAMENTO;
    private String MUNICIPIO;

    public direcciones() {

    }
    public direcciones(String ID_DIR, String LOCATION, String DEPARTAMENTO, String MUNICIPIO, String COMPLEMENTO) {
        this.ID_DIR = ID_DIR;
        this.LOCATION = LOCATION;
        this.DEPARTAMENTO = DEPARTAMENTO;
        this.MUNICIPIO = MUNICIPIO;
        this.COMPLEMENTO = COMPLEMENTO;
    }

    private String COMPLEMENTO;


    public String getID_DIR() {
        return ID_DIR;
    }

    public void setID_DIR(String ID_DIR) {
        this.ID_DIR = ID_DIR;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public String getDEPARTAMENTO() {
        return DEPARTAMENTO;
    }

    public void setDEPARTAMENTO(String DEPARTAMENTO) {
        this.DEPARTAMENTO = DEPARTAMENTO;
    }

    public String getMUNICIPIO() {
        return MUNICIPIO;
    }

    public void setMUNICIPIO(String MUNICIPIO) {
        this.MUNICIPIO = MUNICIPIO;
    }

    public String getCOMPLEMENTO() {
        return COMPLEMENTO;
    }

    public void setCOMPLEMENTO(String COMPLEMENTO) {
        this.COMPLEMENTO = COMPLEMENTO;
    }

}
