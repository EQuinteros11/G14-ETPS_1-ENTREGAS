package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases.categorias;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.helper.AdminSQLiteOpenHelper;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.utilidades.utilidades;

public class CategoriaMostrar extends AppCompatActivity {
    ListView lsvMostrar;
    ArrayList<String> listaInformacion;
    ArrayList<categorias> listaCategoria;
    AdminSQLiteOpenHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_mostrar);
        lsvMostrar = findViewById(R.id.lsvMostrarCategoria);
        conn =new AdminSQLiteOpenHelper(getApplicationContext(),"BD_listadoFarmacia",null,1);
        ConsultarListaCategoria();
        ArrayAdapter adaptador = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,listaInformacion);
        lsvMostrar.setAdapter(adaptador);
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