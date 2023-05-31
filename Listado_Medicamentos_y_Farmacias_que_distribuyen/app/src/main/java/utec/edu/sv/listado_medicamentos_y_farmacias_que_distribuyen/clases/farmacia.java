package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases;

public class farmacia {
    private String ID_FAR;
    private String  RASON_S;
    private String SUCURSAL;
    private String ID_DIR;

    public farmacia() {

    }
    public farmacia(String ID_FAR, String RASON_S, String SUCURSAL, String ID_DIR) {
        this.ID_FAR = ID_FAR;
        this.RASON_S = RASON_S;
        this.SUCURSAL = SUCURSAL;
        this.ID_DIR = ID_DIR;
    }


    public String getID_FAR() {
        return ID_FAR;
    }

    public void setID_FAR(String ID_FAR) {
        this.ID_FAR = ID_FAR;
    }

    public String getRASON_S() {
        return RASON_S;
    }

    public void setRASON_S(String RASON_S) {
        this.RASON_S = RASON_S;
    }

    public String getSUCURSAL() {
        return SUCURSAL;
    }

    public void setSUCURSAL(String SUCURSAL) {
        this.SUCURSAL = SUCURSAL;
    }

    public String getID_DIR() {
        return ID_DIR;
    }

    public void setID_DIR(String ID_DIR) {
        this.ID_DIR = ID_DIR;
    }
}
