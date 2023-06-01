package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases.Control_Farmacia;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases.Control_Medicamento;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases.Control_lista_farmacia;

public class MNT_MEDICAMENTOS extends AppCompatActivity {
    BottomNavigationView btnNavMedi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mnt_medicamentos);
        btnNavMedi = findViewById(R.id.btnNavMedi);
        btnNavMedi.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) navaListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navaListener= new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seleccionFrag= null;

            switch (item.getItemId()){
                case R.id.nav_ver:
                    seleccionFrag = new Control_lista_Medicamento();
                    break;
                case R.id.nav_crear:
                    seleccionFrag = new Control_Medicamento();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContMedi, seleccionFrag ).commit();
            return true;

        }



    };

}