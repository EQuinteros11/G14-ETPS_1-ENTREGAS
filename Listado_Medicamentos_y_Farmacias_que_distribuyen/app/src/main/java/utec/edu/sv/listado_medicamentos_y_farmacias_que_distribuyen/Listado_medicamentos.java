package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Listado_medicamentos extends AppCompatActivity {

    Button btnRegresarPincipal;
    ListView listaMedicamentosTotal;
    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_farmacias);

        btnRegresarPincipal = findViewById( R.id.btnRegresarHome );
        listaMedicamentosTotal = findViewById( R.id.listaMedicamentos);

        btnRegresarPincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent( getApplicationContext(), Home.class );
                startActivity( intento );
            }
        });

        adapter = ArrayAdapter.createFromResource(this, R.array.FarmaciasMasVisitadas, android.R.layout.simple_list_item_1 );
        listaMedicamentosTotal.setAdapter( adapter );
    }
}