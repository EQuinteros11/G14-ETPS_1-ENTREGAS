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
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Datos_Generales_Perfil extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar tlbar;
    NavigationView nView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_generales_perfil);

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
                        Toast.makeText(Datos_Generales_Perfil.this, "Selección Pagina Principal", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent( getApplicationContext(), Home.class );
                        startActivity( intent );
                        break;

                    case R.id.Category:
                        Toast.makeText(Datos_Generales_Perfil.this, "Selección Categoria", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.Profile:
                        Toast.makeText(Datos_Generales_Perfil.this, "Selección Perfil", Toast.LENGTH_SHORT).show();

                        break;

                    case R.id.LogOut:
                        Toast.makeText(Datos_Generales_Perfil.this, "Selección Cerrar Sesión", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        /* FIN DE FUNCIONALIDAD D EMENÚ */
    }
}