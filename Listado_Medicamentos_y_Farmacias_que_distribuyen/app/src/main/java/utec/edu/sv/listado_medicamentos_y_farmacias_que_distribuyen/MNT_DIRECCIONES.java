package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases.Control_Direcciones;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases.Control_lista_direcciones;

public class MNT_DIRECCIONES extends AppCompatActivity {

    BottomNavigationView btnNavD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mnt_direcciones);
        btnNavD = findViewById(R.id.btnNavD);
        btnNavD.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) navaListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navaListener= new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seleccionFrag= null;

            switch (item.getItemId()){
                case R.id.nav_ver:
                    seleccionFrag = new Control_lista_direcciones();
                    break;
                case R.id.nav_crear:
                    seleccionFrag = new Control_Direcciones();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContD, seleccionFrag ).commit();
            return true;

        }



    };

}