package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases;

public class VariablesGlobales {
    private static VariablesGlobales instance;

       //Declarar variable
    private static String NickUser ="";

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