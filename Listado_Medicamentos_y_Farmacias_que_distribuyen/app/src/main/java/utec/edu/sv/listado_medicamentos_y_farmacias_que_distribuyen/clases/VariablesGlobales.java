package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases;

public class VariablesGlobales {
    private static VariablesGlobales instance;

       //Declarar variable
    private static String NickUser ="";


    public  String getIdDfCat() {
        return ID_DF_CAT;
    }

    public  void setIdDfCat(String idDfCat) {
        ID_DF_CAT = idDfCat;
    }

    public  String getIdDfMedi() {
        return ID_DF_MEDI;
    }

    public  void setIdDfMedi(String idDfMedi) {
        ID_DF_MEDI = idDfMedi;
    }

    private static String ID_DF_CAT ="";
    private static String ID_DF_MEDI="";

    public  String getIDFAR() {
        return IDFAR;
    }

    public  void setIDFAR(String IDFAR) {
        VariablesGlobales.IDFAR = IDFAR;
    }

    private static String IDFAR = "" ;

    public String getIdDirCop() {
        return ID_DIR_COP;
    }

    public void setIdDirCop(String idDirCop) {
        ID_DIR_COP = idDirCop;
    }

    private static String ID_DIR_COP ;

    public String getNickUser() {
        return NickUser;
    }

    public void setNickUser(String nickUser) {
        NickUser = nickUser;
    }


    public static synchronized VariablesGlobales getInstance(){
        if(instance == null){
            instance = new VariablesGlobales();
        }
        return instance;
    }
}
