package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

import java.text.DateFormat;

import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.helper.AdminSQLiteOpenHelper;

public class Registro_Usuario extends AppCompatActivity {

    EditText
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        AdminSQLiteOpenHelper admin =new AdminSQLiteOpenHelper(getApplicationContext(),"BD_listadoFarmacia",null,1);
        SQLiteDatabase db =admin.getWritableDatabase();
        ContentValues detalleCon = new ContentValues();
        detalleCon.put("fecchaR", DateFormat.LONG);
        db.insert("ctl_Contar",null,detalleCon);
        Cursor fila = db.rawQuery( "select count(cont) as num from ctl_Contar",null );
        if(fila.moveToFirst()){
            String ID_DU  = fila.getString(0),
                   NOMBRE = ,
                   APEllIDOS = ,
                   EDAD =,
                   DIRECCION = ,
                   CORREO = ,
                   ID_USER =;



        }
        else {

        }



    }
}