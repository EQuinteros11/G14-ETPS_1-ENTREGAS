package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases;

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

import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.R;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.helper.AdminSQLiteOpenHelper;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.utilidades.utilidades;

public class Control_lista_direcciones extends Fragment {
    ListView lsvLista;
    ArrayList<String> listaInformacion;
    ArrayList<direcciones> listadirecciones;
    AdminSQLiteOpenHelper conn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragmento_lista_direcciones,container,false);
        lsvLista = root.findViewById(R.id.lsvListaDire);
        conn =new AdminSQLiteOpenHelper(getContext(),"BD_listadoFarmacia",null,1);
        ConsultarListaDirecciones();
        ArrayAdapter adaptador = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,listaInformacion);
        lsvLista.setAdapter(adaptador);

        return root;
    }
    private void ConsultarListaDirecciones() {
        SQLiteDatabase db =conn.getWritableDatabase();
        direcciones direcciones = null;
        listadirecciones = new ArrayList<direcciones>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_DIRECCIONES,null);
        while (cursor.moveToNext()){
            direcciones = new direcciones();
            direcciones.setID_DIR(cursor.getString(0));
            direcciones.setLOCATION(cursor.getString(1));
            direcciones.setDEPARTAMENTO(cursor.getString(2));
            direcciones.setMUNICIPIO(cursor.getString(3));
            direcciones.setCOMPLEMENTO(cursor.getString(4));
            listadirecciones.add(direcciones);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion= new ArrayList<String>();
        for(int i=0;i<listadirecciones.size();i++){
            listaInformacion.add(listadirecciones.get(i).getID_DIR()+" - Departamento: "+listadirecciones.get(i).getDEPARTAMENTO()+
                    "\n\t  Municipio: "+listadirecciones.get(i).getMUNICIPIO()+"\n\t  Complemento: "+listadirecciones.get(i).getCOMPLEMENTO());
        }
    }
}
