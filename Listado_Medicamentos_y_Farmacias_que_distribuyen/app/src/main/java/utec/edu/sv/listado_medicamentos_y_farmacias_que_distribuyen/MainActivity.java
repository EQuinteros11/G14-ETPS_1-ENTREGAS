package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText edtUsuario, edtPass;
Button btnIniciar;
String nombre[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtPass = findViewById(R.id.edtContra);
        btnIniciar = findViewById(R.id.btnIniciar);

       /* for(int i=1; i<5; i++) {

                btnIniciar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        startActivity(new Intent(getApplicationContext(),Home.class));
                        }
                    }
                });
       }*/

    }
    public void Home(View v){
        nombre = new String [4];
        String nombre []= {"EliasQ","IvanM","Edward","Jessi"};
        String use, pass;
        use = edtUsuario.getText().toString();
        pass = edtPass.getText().toString();
        for(int i=0; i<5;i++){
            System.out.println(nombre[0]);
            if(use.equals(nombre[i]) && pass.equals("123")){
                Intent mostrar = new Intent(this,Home.class);
                startActivity(mostrar);
                i=6;
            }
            else {

            }
       }
    }
}