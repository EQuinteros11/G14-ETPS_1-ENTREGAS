package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases.VariablesGlobales;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.helper.AdminSQLiteOpenHelper;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.utilidades.utilidades;

public class Registro_Usuario extends AppCompatActivity {
    VariablesGlobales va= VariablesGlobales.getInstance();
    EditText edtNombre, edtApellidof, edtApellidos, edtEdad, edtCorreo, edtPass, edtPass2;
    Button btnRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        edtNombre = findViewById(R.id.edtNombreRegistro);
        edtApellidof = findViewById(R.id.edtPrimerApellidoRegistro);
        edtApellidos = findViewById(R.id.edtSegundoApellidoRegistro);
        edtEdad = findViewById(R.id.edtEdadRegistro);
        edtCorreo = findViewById(R.id.edtCorreoRegistro);
        edtPass = findViewById(R.id.edtContrasenaRegistro);
        edtPass2 = findViewById(R.id.edtPass2);
        btnRegistro = findViewById(R.id.btnRegistroUsuario);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(getApplicationContext(),"BD_listadoFarmacia",null,1);
                SQLiteDatabase db =admin.getWritableDatabase();
                try {
                    String  NOMBRE = edtNombre.getText().toString(),
                            APEllIDOS = edtApellidof.getText().toString() +" " +edtApellidos.getText().toString() ,
                            EDAD =edtEdad.getText().toString(),
                            CORREO = edtCorreo.getText().toString(),
                            PASS = edtPass.getText().toString(),
                            CONFIR = edtPass2.getText().toString();
                    ContentValues detalle = new ContentValues();
                    detalle.put("NOMBRE",NOMBRE);
                    detalle.put("APEllIDOS",APEllIDOS);
                    detalle.put("EDAD",EDAD);
                    detalle.put("CORREO",CORREO);


                        if(PASS.equals(CONFIR)){
                            db.insert(utilidades.TABLA_DATOS_USUARIO,null, detalle);
                            Cursor concat = db.rawQuery( "select lower(substr("+utilidades.CAMPO_NOMBRE+",1,1)) as nick, "+utilidades.CAMPO_ID_DU+" from "+utilidades.TABLA_DATOS_USUARIO+" WHERE "+utilidades.CAMPO_NOMBRE+" = " +"'"+edtNombre.getText().toString()+"'" ,null );
                            if(concat.moveToFirst()){
                                System.out.println(concat.getString(0));
                                ContentValues detalle2 = new ContentValues();
                                Calendar y = Calendar.getInstance();
                                String year = String.valueOf(y.get(Calendar.YEAR));
                                System.out.println(concat.getString(1)+"-"+year);
                                detalle2.put("ID_USER",concat.getString(1) + "-"+year);

                                detalle2.put("USER_NICKNAME",concat.getString(0)+edtApellidof.getText().toString().toLowerCase());
                                detalle2.put("PASS",PASS);
                                detalle2.put("ROL","admin");
                                detalle2.put("ID_DU",concat.getString(1));
                                db.insert(utilidades.TABLA_USUARIO,null,detalle2);
                                System.out.println(concat.getString(0));
                                db.close();
                                Toast.makeText( getApplicationContext(), "Registro Exitoso Nª "+concat.getString(1), Toast.LENGTH_LONG ).show();
                                Intent login = new Intent(getApplicationContext(),MainActivity.class );
                                startActivity(login);
                            }
                            else {
                                Toast.makeText( getApplicationContext(), "Error de Registro", Toast.LENGTH_LONG ).show();
                            }

                        }
                        else {
                            Toast.makeText( getApplicationContext(), "Contraseñas no coinciden", Toast.LENGTH_LONG ).show();
                        }

                    }
                    catch (Exception e){
                        Toast.makeText( getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_LONG ).show();
                    }

            }
        });

    }
}