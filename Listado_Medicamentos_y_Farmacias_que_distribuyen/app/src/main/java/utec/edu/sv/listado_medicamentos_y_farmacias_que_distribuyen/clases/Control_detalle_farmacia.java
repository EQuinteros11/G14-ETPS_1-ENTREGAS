package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
    ArrayList<farmacia> listaFarmacia;
    AdminSQLiteOpenHelper conn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragmento_crear_detalle_farmacia,container,false);
        edtCantidad = root.findViewById(R.id.edtCantidadDF);
        edtPrecio = root.findViewById(R.id.edtPrecioDF);
        btnGuardar = root.findViewById(R.id.btnGuradarDF);
        SPCate = root.findViewById(R.id.spCategoriaDF);
        SPMedica = root.findViewById(R.id.spFarmaciaDF);
        conn =new AdminSQLiteOpenHelper(getContext(),"BD_listadoFarmacia",null,1);
        ConsultarListaCategoria();
        ConsultarListaFarmacia();

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,listaInformacion);
        SPCate.setAdapter(adaptador);
        ArrayAdapter<CharSequence> adaptador2 = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,listaInformacion2);
        SPMedica.setAdapter(adaptador2);
        SPMedica.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                if(pos!=0){
                    va.setIDFAR(listaFarmacia.get(pos-1).getID_FAR().toString());
                }
                else {
                    va.setIdDirCop("");
                    va.setIdDfMedi("");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SPCate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                if(pos!=0){
                    va.setIdDfCat(listaCategoria.get(pos-1).getID_CAT().toString());
                    va.setIdDfMedi(listaCategoria.get(pos-1).getFK_ID_MEDICA().toString());
                }
                else {
                    va.setIdDirCop("");
                    va.setIdDfMedi("");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(getContext(),"BD_listadoFarmacia",null,1);
                SQLiteDatabase db =admin.getWritableDatabase();
                String CANTIDAD_DET = edtCantidad.getText().toString(),
                        PRECIO_DET = edtPrecio.getText().toString();
                System.out.println(va.getIdDirCop());
                ContentValues detalle = new ContentValues();
                detalle.put("ID_CAT_DET",va.getIdDfCat());
                detalle.put("ID_MEDICA_DET",va.getIdDfMedi());
                detalle.put("CANTIDAD_DET",CANTIDAD_DET);
                detalle.put("PRECIO_DET",PRECIO_DET);
                detalle.put("FKID_FARM",va.getIDFAR());
                try {
                    db.insert( utilidades.TABLA_FARMACIAS_DETALLE, null, detalle );
                    Toast.makeText(getContext(), "Registro Exitoso", Toast.LENGTH_SHORT).show();
                    edtCantidad.setText("");
                    edtPrecio.setText("");
                }
                catch (Exception e){
                    Toast.makeText(getContext(), "No se Registro "+ e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });




        return root;
    }

    private void ConsultarListaFarmacia() {
        SQLiteDatabase db =conn.getReadableDatabase();
        farmacia farmacia =null;
        listaFarmacia = new ArrayList<farmacia>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_FARMACIAS,null);
        while (cursor.moveToNext()){
            farmacia = new farmacia();
            farmacia.setID_FAR(cursor.getString(0));
            farmacia.setRASON_S(cursor.getString(1));
            farmacia.setSUCURSAL(cursor.getString(2));
            listaFarmacia.add(farmacia);
        }
        obtenerLista2();
    }

    private void obtenerLista2() {
        listaInformacion2 = new ArrayList<String>();
        listaInformacion2.add("Seleccione");
        for(int i=0;i<listaFarmacia.size();i++){
            listaInformacion2.add(listaFarmacia.get(i).getID_FAR()+ " - "+listaFarmacia.get(i).getRASON_S()+" "+listaFarmacia.get(i).getSUCURSAL());


        }
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
