package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.R;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.helper.AdminSQLiteOpenHelper;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.utilidades.utilidades;

public class Control_detalle_farmacia extends Fragment {
    VariablesGlobales va= VariablesGlobales.getInstance();
    Spinner SPCate,SPMedica;

    Button btnGuardar;
    EditText edtCantidad,edtPrecio;
    ArrayList<String> listaInformacion;
    ArrayList<categorias> listaCategoria;
    ArrayList<String> listaInformacion2;
    ArrayList<medicamentos> listaMedicamento;
    AdminSQLiteOpenHelper conn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragmento_crear_detalle_farmacia,container,false);
        edtCantidad = root.findViewById(R.id.edtCantidadDF);
        edtPrecio = root.findViewById(R.id.edtPrecioDF);
        btnGuardar = root.findViewById(R.id.btnGuradarDF);
        SPCate = root.findViewById(R.id.spCategoriaDF);
        conn =new AdminSQLiteOpenHelper(getContext(),"BD_listadoFarmacia",null,1);
        ConsultarListaCategoria();
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,listaInformacion);
        SPCate.setAdapter(adaptador);
        


        return root;
    }

    private void ConsultarListaCategoria() {
        SQLiteDatabase db =conn.getReadableDatabase();
        categorias categorias =null;
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
        AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(getContext(),"BD_listadoFarmacia",null,1);
        SQLiteDatabase db =admin.getWritableDatabase();
        listaInformacion = new ArrayList<String>();
        listaInformacion.add("Seleccione");
        for(int i=0;i<listaCategoria.size();i++){
            Cursor fila = db.rawQuery( "select b."+utilidades.CAMPO_NOMBRE_MEDICA+" from "+utilidades.TABLA_CAT_MEDICA+" as a inner join "+utilidades.TABLA_MEDICAMENTO+" as b on b."+utilidades.CAMPO_ID_MEDICA+" = a."+"'"+utilidades.CAMPO_FKCATE_ID+"'"+" where b."+utilidades.CAMPO_ID_MEDICA+" = "+"'"+listaCategoria.get(i).getFK_ID_MEDICA()+"'",null );

            if(fila.moveToFirst()) {
                listaInformacion.add(listaCategoria.get(i).getID_CAT()+ " - CATEGORIA: "+listaCategoria.get(i).getCATE()+"\n\t   MEDICAMENTO: "+fila.getString(0));
            }

        }
    }
}
