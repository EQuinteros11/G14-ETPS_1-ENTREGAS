package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases.VariablesGlobales;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.helper.AdminSQLiteOpenHelper;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.utilidades.utilidades;

public class MainActivity extends AppCompatActivity {
    VariablesGlobales va=VariablesGlobales.getInstance();
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
                        Toast toastP = new Toast(getApplicationContext());
                        AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(getApplicationContext(),"BD_listadoFarmacia",null,1);
                        SQLiteDatabase db =admin.getWritableDatabase();
                        use = edtUsuario.getText().toString();
                        pass = edtPass.getText().toString();
                        Cursor fila = db.rawQuery( "select "+utilidades.CAMPO_USER_NICKNAME+", "+utilidades.CAMPO_ROL+"  from "+utilidades.TABLA_USUARIO+"  where "+utilidades.CAMPO_USER_NICKNAME+"="+"'"+use+"'"+" and "+utilidades.CAMPO_PASS+" = "+"'"+pass+"'" ,null );

                        if(fila.moveToFirst()) {
                                va.setNickUser(fila.getString(0));
                                System.out.println(fila.getString(1));
                                if (fila.getString(1).equals("admin")){
                                    Intent intento=new Intent(getApplicationContext(),Mantenimientos_CRUD_BD.class);
                                    Toast.makeText(MainActivity.this, "Bienvenido "+fila.getString(1), Toast.LENGTH_SHORT).show();
                                    startActivity(intento);
                                }
                                else{
                                Intent intento=new Intent(getApplicationContext(),Home.class);
                                Toast.makeText(MainActivity.this, "Bienvenido "+fila.getString(0), Toast.LENGTH_SHORT).show();
                                startActivity(intento);
                                }

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
