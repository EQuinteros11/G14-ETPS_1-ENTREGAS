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

public class Control_Categoria extends Fragment {
    VariablesGlobales va= VariablesGlobales.getInstance();
    Spinner spVerMedicamento;

    Button btnRegistrarCat;
    EditText edtCategoria;
    ArrayList<String> listaInformacion;
    ArrayList<medicamentos> listaCategoria;
    AdminSQLiteOpenHelper conn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragmento_crear_categoria,container,false);
        spVerMedicamento = root.findViewById(R.id.spVerMedicamentos);
        edtCategoria = root.findViewById(R.id.edtCategoria);
        btnRegistrarCat = root.findViewById(R.id.btnGuardar);
        conn =new AdminSQLiteOpenHelper(getContext(),"BD_listadoFarmacia",null,1);
        ConsultarListaCategoria();
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,listaInformacion);
        spVerMedicamento.setAdapter(adaptador);
        spVerMedicamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                if(pos!=0){
                    va.setIdDirCop(listaCategoria.get(pos-1).getID_MEDICA().toString());
                }
                else {
                    va.setIdDirCop("");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnRegistrarCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(getContext(),"BD_listadoFarmacia",null,1);
                SQLiteDatabase db =admin.getWritableDatabase();
                String CATE = edtCategoria.getText().toString();
                System.out.println(va.getIdDirCop());
                ContentValues detalle = new ContentValues();
                detalle.put("CATE",CATE);
                detalle.put("FK_ID_MEDICA",va.getIdDirCop());
                try {
                    db.insert( utilidades.TABLA_CAT_MEDICA, null, detalle );
                    Toast.makeText(getContext(), "Registro Exitoso", Toast.LENGTH_SHORT).show();
                    edtCategoria.setText("");

                }
                catch (Exception e){
                    Toast.makeText(getContext(), "No se Registro "+ e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });





        return root;
    }

    private void ConsultarListaCategoria() {
        SQLiteDatabase db =conn.getReadableDatabase();
        medicamentos medicamentos =null;
        listaCategoria = new ArrayList<medicamentos>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_MEDICAMENTO,null);
        while (cursor.moveToNext()){
            medicamentos = new medicamentos();
            medicamentos.setID_MEDICA(cursor.getString(0));
            medicamentos.setNOMBRE_MEDICA(cursor.getString(1));
            listaCategoria.add(medicamentos);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion = new ArrayList<String>();
        listaInformacion.add("Seleccione");
        for(int i=0;i<listaCategoria.size();i++){
            listaInformacion.add(listaCategoria.get(i).getID_MEDICA()+ " - "+listaCategoria.get(i).getNOMBRE_MEDICA());
        }

    }
}
