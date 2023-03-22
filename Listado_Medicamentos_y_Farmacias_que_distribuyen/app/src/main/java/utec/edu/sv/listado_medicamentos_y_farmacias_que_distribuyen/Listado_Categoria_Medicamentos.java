package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Listado_Categoria_Medicamentos extends AppCompatActivity {

    Button btnRegresarPincipal;
    ListView lstMedicamentos;
    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_categoria_medicamentos);

        btnRegresarPincipal = findViewById( R.id.btnRegresarHome );
        lstMedicamentos = findViewById( R.id.listaMedicamentos );

        btnRegresarPincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent( getApplicationContext(), Home.class );
                startActivity( intento );
            }
        });

        adapter = ArrayAdapter.createFromResource(this, R.array.ListadoMedicamentos, android.R.layout.simple_list_item_1 );
        lstMedicamentos.setAdapter( adapter );
    }
}