package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases.Control_Categoria;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases.Control_Farmacia;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases.Control_lista_categoria;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases.Control_lista_farmacia;

public class MNT_CATEGORIAS extends AppCompatActivity {
    BottomNavigationView btnNavCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mnt_categorias);
        btnNavCat = findViewById(R.id.btnNavCat);
        btnNavCat.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) navaListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navaListener= new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seleccionFrag= null;

            switch (item.getItemId()){
                case R.id.nav_ver:
                    seleccionFrag = new Control_lista_categoria();
                    break;
                case R.id.nav_crear:
                    seleccionFrag = new Control_Categoria();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContCat, seleccionFrag ).commit();
            return true;

        }



    };

}