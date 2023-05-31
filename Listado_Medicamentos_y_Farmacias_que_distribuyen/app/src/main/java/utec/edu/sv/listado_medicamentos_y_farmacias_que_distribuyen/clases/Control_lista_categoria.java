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

public class Control_lista_categoria extends Fragment {
    ListView lsvLista;
    ArrayList<String> listaInformacion;
    ArrayList<categorias> listaCategoria;
    AdminSQLiteOpenHelper conn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragmento_lista_categoria,container,false);
        lsvLista = root.findViewById(R.id.lsvCategoria);
        conn =new AdminSQLiteOpenHelper(getContext(),"BD_listadoFarmacia",null,1);
        ConsultarListaCategoria();
        ArrayAdapter adaptador = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,listaInformacion);
        lsvLista.setAdapter(adaptador);


        return root;
    }

    private void ConsultarListaCategoria() {
        SQLiteDatabase db =conn.getWritableDatabase();
        categorias categorias = null;
        listaCategoria = new ArrayList<categorias>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_CAT_MEDICA,null);
        while (cursor.moveToNext()){
            categorias = new categorias();
            categorias.setID_CAT(cursor.getString(0));
            categorias.setCATE(cursor.getString(1));
            categorias.setFK_ID_MEDICA(cursor.getString(2));
            listaCategoria.add(categorias);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion= new ArrayList<String>();
        for(int i=0;i<listaCategoria.size();i++){
            listaInformacion.add(listaCategoria.get(i).getID_CAT()+" - Categoria: "+listaCategoria.get(i).getCATE()+
                    "\n\t  ID MEDICA: "+listaCategoria.get(i).getFK_ID_MEDICA());
        }
    }
}
