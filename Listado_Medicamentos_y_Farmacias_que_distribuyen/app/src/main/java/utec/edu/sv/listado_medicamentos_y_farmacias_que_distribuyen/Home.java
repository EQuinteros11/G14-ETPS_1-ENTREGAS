package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {
    TextView tvverusu;
    ListView lstFarmacias;
    Button btnListaFarmacias, btCategoria1;
    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter adaptador;
    DrawerLayout drawerLayout;
    Toolbar tlbar;
    NavigationView nView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lstFarmacias = findViewById( R.id.listFarmaciasMasVisitadas );
        btnListaFarmacias = findViewById( R.id.btnVerFarmacias );
        btCategoria1 = findViewById( R.id.btnCategoria1 );
        drawerLayout = findViewById( R.id.drawLayout );
        tlbar = findViewById( R.id.toolbar );
        nView = findViewById( R.id.navView );

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawerLayout, tlbar, R.string.open, R.string.close );
        drawerLayout.addDrawerListener( toggle );
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor( getResources().getColor( R.color.white, null ) );

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