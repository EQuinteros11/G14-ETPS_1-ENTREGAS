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

public class Control_lista_farmacia extends Fragment {

    ListView lsvLista;
    ArrayList<String> listaInformacion;
    ArrayList<farmacia> listaFarmacia;
    AdminSQLiteOpenHelper conn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragmento_lista_farmacia,container,false);
        lsvLista = root.findViewById(R.id.lsvFarmacia);
        conn =new AdminSQLiteOpenHelper(getContext(),"BD_listadoFarmacia",null,1);
        ConsultarListafarmacias();
        ArrayAdapter adaptador = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,listaInformacion);
        lsvLista.setAdapter(adaptador);

        return root;

    }

    private void ConsultarListafarmacias() {
        SQLiteDatabase db =conn.getWritableDatabase();
        farmacia farmacia = null;
        listaFarmacia = new ArrayList<farmacia>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_FARMACIAS,null);
        while (cursor.moveToNext()){
            farmacia = new farmacia();
            farmacia.setID_FAR(cursor.getString(0));
            farmacia.setRASON_S(cursor.getString(1));
            farmacia.setSUCURSAL(cursor.getString(2));
            farmacia.setID_DIR(cursor.getString(3));
            listaFarmacia.add(farmacia);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion= new ArrayList<String>();
        for(int i=0;i<listaFarmacia.size();i++){
            listaInformacion.add(listaFarmacia.get(i).getID_FAR()+" - Razon Social: "+listaFarmacia.get(i).getRASON_S()+
                    "\n\t  Sucursal: "+listaFarmacia.get(i).getSUCURSAL()+"\n\t  ID DIRECCION: "+listaFarmacia.get(i).getID_DIR());
        }
    }
}
