package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases.medicamentos;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.helper.AdminSQLiteOpenHelper;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.utilidades.utilidades;

public class Control_lista_Medicamento extends Fragment {
    ListView lsvLista;
    ArrayList<String> listaInformacion;
    ArrayList<medicamentos> listaMedicamento;
    AdminSQLiteOpenHelper conn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragmento_lista_medicamento,container,false);
        lsvLista = root.findViewById(R.id.lsvMedicamento);
        conn =new AdminSQLiteOpenHelper(getContext(),"BD_listadoFarmacia",null,1);
        ConsultarListaMedicamentos();
        ArrayAdapter adaptador = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,listaInformacion);
        lsvLista.setAdapter(adaptador);

        return  root;
    }

    private void ConsultarListaMedicamentos() {
        SQLiteDatabase db =conn.getWritableDatabase();
        medicamentos medicamentos = null;
        listaMedicamento = new ArrayList<medicamentos>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_MEDICAMENTO,null);
        while (cursor.moveToNext()){
            medicamentos = new medicamentos();
            medicamentos.setID_MEDICA(cursor.getString(0));
            medicamentos.setNOMBRE_MEDICA(cursor.getString(1));
            medicamentos.setCANTIDAD(cursor.getString(2));
            medicamentos.setUM(cursor.getString(3));
            listaMedicamento.add(medicamentos);
        }
        obtenerLista();
    }
    private void obtenerLista() {
        listaInformacion= new ArrayList<String>();
        for(int i=0;i<listaMedicamento.size();i++){
            listaInformacion.add(listaMedicamento.get(i).getID_MEDICA()+" - Medicamento: "+listaMedicamento.get(i).getNOMBRE_MEDICA()+
                    "\n\t  Cantidad: "+listaMedicamento.get(i).getCANTIDAD()+"\n\t  UM: "+listaMedicamento.get(i).getUM());
        }
    }
}
