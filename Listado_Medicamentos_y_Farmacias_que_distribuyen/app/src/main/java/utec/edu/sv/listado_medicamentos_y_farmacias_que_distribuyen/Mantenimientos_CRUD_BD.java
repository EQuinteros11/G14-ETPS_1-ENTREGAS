package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases.Control_Direcciones;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases.Control_Farmacia;

public class Mantenimientos_CRUD_BD extends AppCompatActivity {
    Button btnCRUDDIRECCIONES, btnCRUDFARMACIAS, btnCRUDMEDICAMENTO, btnCRUDCATEGORIA,btnCRUDDETALLEFARMACIA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mantenimientos_crud_bd);

        btnCRUDDIRECCIONES = findViewById(R.id.btnCRUDDIRECT);
        btnCRUDFARMACIAS = findViewById(R.id.btnCRUDFARM);
        btnCRUDMEDICAMENTO = findViewById(R.id.btnCRUDMEDICAMENTO);
        btnCRUDCATEGORIA = findViewById(R.id.btnCRUDCATEGORIA);
        btnCRUDDETALLEFARMACIA = findViewById(R.id.btnCRUDDETALLEFARMACIA);
        btnCRUDDIRECCIONES.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent(getApplicationContext(), MNT_DIRECCIONES.class);
                startActivity(o);
            }
        });
        btnCRUDFARMACIAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent far = new Intent(getApplicationContext(), MNT_FARMACIAS.class);
                startActivity(far);
            }
        });
        btnCRUDMEDICAMENTO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Me = new Intent(getApplicationContext(), MNT_MEDICAMENTOS.class);
                startActivity(Me);
            }
        });
        btnCRUDCATEGORIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Me = new Intent(getApplicationContext(), MNT_CATEGORIAS.class);
                startActivity(Me);
            }
        });
        btnCRUDDETALLEFARMACIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Me = new Intent(getApplicationContext(), MNT_DEATLLE_FARMACIA.class);
                startActivity(Me);
            }
        });

    }
}