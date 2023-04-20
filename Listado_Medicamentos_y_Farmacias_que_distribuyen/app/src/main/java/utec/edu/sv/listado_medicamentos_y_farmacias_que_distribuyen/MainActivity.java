package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText edtUsuario, edtPass;
Button btnIniciar, btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtPass = findViewById(R.id.edtContra);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnRegistrar = findViewById(R.id.btnRegistrar);

       // for(int i=1; i<5; i++) {
                btnRegistrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intento1=new Intent(getApplicationContext(),Registro_Usuario.class);
                        startActivity(intento1);
                    }
                });
                btnIniciar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LayoutInflater inflater =getLayoutInflater();
                        View layout=inflater.inflate(R.layout.error_de_session,(ViewGroup) findViewById(R.id.MensajeError));
                        String use="", pass="";
                        use = edtUsuario.getText().toString();
                        pass = edtPass.getText().toString();
                        Toast toastP = new Toast(getApplicationContext());
                        if(use.equals("EliasQ") && pass.equals("123")) {
                                Intent intento=new Intent(getApplicationContext(),Home.class);
                                intento.putExtra("usuario",edtUsuario.getText().toString());
                                startActivity(intento);
                        }
                        else    {
                                TextView txtMensaje=(TextView) layout.findViewById(R.id.tvErrorLogin);
                                txtMensaje.setText("Usuario o contraseña invalidos");
                                toastP.setDuration(Toast.LENGTH_LONG);
                                toastP.setView(layout);
                                toastP.show();
                                }
                    }
                });

    }
}
