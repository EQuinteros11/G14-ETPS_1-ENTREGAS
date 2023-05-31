package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases;

public class categorias {
    private String ID_CAT;
    private String CATE;
    private String FK_ID_MEDICA;


    public categorias() {
    }

    public categorias(String ID_CAT, String CATE, String FK_ID_MEDICA) {
        this.ID_CAT = ID_CAT;
        this.CATE = CATE;
        this.FK_ID_MEDICA = FK_ID_MEDICA;
    }

    public String getID_CAT() {
        return ID_CAT;
    }

    public void setID_CAT(String ID_CAT) {
        this.ID_CAT = ID_CAT;
    }

    public String getCATE() {
        return CATE;
    }

    public void setCATE(String CATE) {
        this.CATE = CATE;
    }

    public String getFK_ID_MEDICA() {
        return FK_ID_MEDICA;
    }

    public void setFK_ID_MEDICA(String FK_ID_MEDICA) {
        this.FK_ID_MEDICA = FK_ID_MEDICA;
    }
}
