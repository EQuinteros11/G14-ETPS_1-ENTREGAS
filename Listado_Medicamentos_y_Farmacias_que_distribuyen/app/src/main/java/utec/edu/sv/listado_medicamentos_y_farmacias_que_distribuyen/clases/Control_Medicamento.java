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

public class Control_Medicamento extends Fragment {
    EditText edtMedica,edtCantidad,edtUM;
    Button btnGuardar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragamento_crear_medicamento,container,false);
        edtCantidad = root.findViewById(R.id.edtCantidadMedic);
        edtMedica = root.findViewById(R.id.edtMedicamento);
        edtUM = root.findViewById(R.id.edtUM);
        btnGuardar = root.findViewById(R.id.btnGuardarMedi);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(getContext(),"BD_listadoFarmacia",null,1);
                    SQLiteDatabase db =admin.getWritableDatabase();
                    String  NOMBRE_MEDICA = edtMedica.getText().toString(),
                            CANTIDAD= edtCantidad.getText().toString(),
                            UM    = edtUM.getText().toString();
                    ContentValues detalle = new ContentValues();
                    detalle.put("NOMBRE_MEDICA",NOMBRE_MEDICA);
                    detalle.put("CANTIDAD",CANTIDAD);
                    detalle.put("UM", UM);

                        db.insert(utilidades.TABLA_MEDICAMENTO, null, detalle );
                        edtMedica.setText("");
                        edtCantidad.setText("");
                        edtUM.setText("");
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
