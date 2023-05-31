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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.R;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.helper.AdminSQLiteOpenHelper;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.utilidades.utilidades;

public class Control_Farmacia extends Fragment {
    VariablesGlobales va= VariablesGlobales.getInstance();
    Spinner SPDireccion;

    Button btnRegistrarF;
    EditText edtRS,edtSucursal;
    ArrayList<String> listaInformacion;
    ArrayList<direcciones> listaDirecciones;
    AdminSQLiteOpenHelper conn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragmento_mnt_farmacia_crear,container,false);
        SPDireccion = root.findViewById(R.id.spDireccion);
        edtRS = root.findViewById(R.id.edtRazon);
        edtSucursal = root.findViewById(R.id.edtSucursal);
        btnRegistrarF = root.findViewById(R.id.btnRegistrarF);
        conn =new AdminSQLiteOpenHelper(getContext(),"BD_listadoFarmacia",null,1);
        ConsultarListaDirecciones();
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,listaInformacion);
        SPDireccion.setAdapter(adaptador);

        SPDireccion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                if(pos!=0){
                    va.setIdDirCop(listaDirecciones.get(pos-1).getID_DIR().toString());
                }
                else {
                    va.setIdDirCop("");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnRegistrarF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(getContext(),"BD_listadoFarmacia",null,1);
                SQLiteDatabase db =admin.getWritableDatabase();
                String RASON_S = edtRS.getText().toString(),
                       SUCURSAL = edtSucursal.getText().toString();
                System.out.println(va.getIdDirCop());
                ContentValues detalle = new ContentValues();
                detalle.put("RASON_S",RASON_S);
                detalle.put("SUCURSAL",SUCURSAL);
                detalle.put("ID_DIR",va.getIdDirCop());
                try {
                    db.insert( utilidades.TABLA_FARMACIAS, null, detalle );
                    Toast.makeText(getContext(), "Registro Exitoso", Toast.LENGTH_SHORT).show();
                    edtRS.setText("");
                    edtRS.setText("");
                }
                catch (Exception e){
                    Toast.makeText(getContext(), "No se Registro "+ e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        return  root;
    }

    private void ConsultarListaDirecciones() {
        SQLiteDatabase db =conn.getReadableDatabase();
        direcciones direcciones =null;
        listaDirecciones = new ArrayList<direcciones>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_DIRECCIONES,null);
        while (cursor.moveToNext()){
            direcciones = new direcciones();
            direcciones.setID_DIR(cursor.getString(0));
            direcciones.setLOCATION(cursor.getString(1));
            direcciones.setDEPARTAMENTO(cursor.getString(2));
            direcciones.setMUNICIPIO(cursor.getString(3));
            direcciones.setCOMPLEMENTO(cursor.getString(4));
            listaDirecciones.add(direcciones);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion = new ArrayList<String>();
        listaInformacion.add("Seleccione");
        for(int i=0;i<listaDirecciones.size();i++){
            listaInformacion.add(listaDirecciones.get(i).getID_DIR()+ " - "+listaDirecciones.get(i).getMUNICIPIO());
        }
    }

}
