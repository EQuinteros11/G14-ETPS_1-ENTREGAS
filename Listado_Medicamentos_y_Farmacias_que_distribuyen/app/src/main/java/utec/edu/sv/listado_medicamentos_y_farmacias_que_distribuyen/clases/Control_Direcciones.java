package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.R;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.helper.AdminSQLiteOpenHelper;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.utilidades.utilidades;

public class Control_Direcciones extends Fragment {

    EditText edtlocation,edtdep, edtmuni, edtcomple;
    Button btnguardar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragmento_crear_direcciones,container,false);
        edtlocation = root.findViewById(R.id.edtLocation);
        edtdep = root.findViewById(R.id.edtdepa);
        edtmuni = root.findViewById(R.id.edtMunicipio);
        edtcomple = root.findViewById(R.id.edtComplemento);
        btnguardar = root.findViewById(R.id.btnGuardarD);


        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(getContext(),"BD_listadoFarmacia",null,1);
                SQLiteDatabase db =admin.getWritableDatabase();
                String  LOCATION = edtlocation.getText().toString(),
                        DEPARTAMENTO= edtdep.getText().toString(),
                        MUNICIPIO    = edtmuni.getText().toString(),
                        COMPLEMENTO = edtcomple.getText().toString();
                ContentValues detalle = new ContentValues();
                detalle.put("LOCATION",LOCATION);
                detalle.put("DEPARTAMENTO",DEPARTAMENTO);
                detalle.put("MUNICIPIO",MUNICIPIO);
                detalle.put("COMPLEMENTO",COMPLEMENTO);
                try {
                    db.insert(utilidades.TABLA_DIRECCIONES, null, detalle );
                    Toast.makeText(getContext(), "Registro Exitoso", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(getContext(), "No se inserto", Toast.LENGTH_SHORT).show();
                }


            }
        });



        return root;
    }
}
