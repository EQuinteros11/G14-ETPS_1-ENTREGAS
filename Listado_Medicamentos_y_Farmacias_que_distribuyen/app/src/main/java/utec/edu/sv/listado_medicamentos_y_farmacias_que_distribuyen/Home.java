package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    TextView tvverusu;
    ListView lstFarmacias;
    Button btnListaFarmacias, btCategoria1;
    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lstFarmacias = findViewById( R.id.listFarmaciasMasVisitadas );
        btnListaFarmacias = findViewById( R.id.btnVerFarmacias );
        btCategoria1 = findViewById( R.id.btnCategoria1 );

        Bundle bundle = getIntent().getExtras();
        tvverusu =findViewById(R.id.tvVerUsuario);
        String ver = bundle.getString("usuario");
        tvverusu.setText(ver);

        adapter = ArrayAdapter.createFromResource(this, R.array.FarmaciasMasVisitadas, android.R.layout.simple_list_item_1 );
        lstFarmacias.setAdapter( adapter );

        btnListaFarmacias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent( getApplicationContext(), Listado_medicamentos.class );
                startActivity( intento );
            }
        });

        btCategoria1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent( getApplicationContext(), Listado_Categoria_Medicamentos.class );
                startActivity( intento );
            }
        });
    }
}