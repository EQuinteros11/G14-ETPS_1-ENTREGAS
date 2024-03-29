package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.utilidades.utilidades;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(utilidades.CREAR_TABLA_DATOS_USUARIO);
        db.execSQL(utilidades.CREAR_TABLA_USUARIO);
        db.execSQL(utilidades.CREAR_TABLA_MEDICAMENTO);
        db.execSQL(utilidades.CREAR_TABLA_CAT_MEDICA);
        db.execSQL(utilidades.CREAR_TABLA_DIRECCIONES);
        db.execSQL(utilidades.CREAR_TABLA_FARMACIAS);
        db.execSQL(utilidades.CREAR_TABLA_FARMACIA_DETALLE);
        db.execSQL("CREATE TABLE ctl_Contar(" +
                "cont integer primary key autoincrement," +
                "fecchaR date )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {


    }
}
