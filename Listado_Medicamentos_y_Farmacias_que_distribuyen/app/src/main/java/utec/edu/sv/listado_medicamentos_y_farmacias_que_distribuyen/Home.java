package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases.VariablesGlobales;

public class Home extends AppCompatActivity {
    VariablesGlobales va= VariablesGlobales.getInstance();
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

        /* FUNCIONALIDAD D EMENÚ */

        /* Funcionamiento de escucha para eventos de menú lateral */
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawerLayout, tlbar, R.string.open, R.string.close );
        drawerLayout.addDrawerListener( toggle );
        toggle.syncState();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toggle.getDrawerArrowDrawable().setColor( getResources().getColor( R.color.white, null ) );
        }

        /* Funcionamiento para verficar escucha de elemento seleccionado de menú */
        nView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch ( item.getItemId() ){
                    case R.id.Home:
                        Toast.makeText(Home.this, "Selección Pagina Principal", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.Category:
                        Toast.makeText(Home.this, "Selección Categoria", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.Profile:
                        Toast.makeText(Home.this, "Selección Perfil", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent( getApplicationContext(), Datos_Generales_Perfil.class );
                        startActivity( intent );
                        break;

                    case R.id.LogOut:
                        Toast.makeText(Home.this, "Selección Cerrar Sesión", Toast.LENGTH_SHORT).show();
                        Intent o = new Intent( getApplicationContext(), MainActivity.class );
                        startActivity( o );
                        break;
                }
                return true;
            }
        });

        /* FIN DE FUNCIONALIDAD D EMENÚ */


        tvverusu =findViewById(R.id.tvVerUsuario);

        tvverusu.setText(va.getNickUser());

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