package utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.clases;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.R;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.helper.AdminSQLiteOpenHelper;
import utec.edu.sv.listado_medicamentos_y_farmacias_que_distribuyen.utilidades.utilidades;

public class Control_lista_detalle_farmacia extends Fragment {
    ListView lsvDetalleFarm;
    ArrayList<String> listaInformacion2;
    ArrayList<detallefarmacia> listaFarmacia;
    AdminSQLiteOpenHelper conn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragmento_lista_detalle_farmacia,container,false);
        lsvDetalleFarm = root.findViewById(R.id.lsvDetalleFarm);
        conn =new AdminSQLiteOpenHelper(getContext(),"BD_listadoFarmacia",null,1);
        ConsultarListaFarmacia();

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,listaInformacion2);
        lsvDetalleFarm.setAdapter(adaptador);

        return  root;
    }

    private void ConsultarListaFarmacia() {
        SQLiteDatabase db =conn.getReadableDatabase();
        detallefarmacia detallefarmacia =null;
        listaFarmacia = new ArrayList<detallefarmacia>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_FARMACIAS_DETALLE,null);
        while (cursor.moveToNext()){
            detallefarmacia = new detallefarmacia();
            detallefarmacia.setID_FAR_DET(cursor.getString(0));
            detallefarmacia.setID_CAT_DET(cursor.getString(1));
            detallefarmacia.setID_MEDICA_DET(cursor.getString(2));
            detallefarmacia.setCANTIDAD_DET(cursor.getString(3));
            detallefarmacia.setPRECIO_DET(cursor.getString(4));
            detallefarmacia.setFKID_FARM(cursor.getString(5));
            listaFarmacia.add(detallefarmacia);
        }
        obtenerLista2();
    }

    private void obtenerLista2() {
        listaInformacion2 = new ArrayList<String>();
        for(int i=0;i<listaFarmacia.size();i++){
            listaInformacion2.add(listaFarmacia.get(i).getID_FAR_DET()+ " - ID CATEGORIA: "+listaFarmacia.get(i).getID_CAT_DET()+"\nID MEDICAMENTO: "+listaFarmacia.get(i).getID_MEDICA_DET()+"\nSTOCK: "+listaFarmacia.get(i).getCANTIDAD_DET()+"\nPRECIO UNITARIO: "+listaFarmacia.get(i).getPRECIO_DET()+"\nID FARMACIA: "+listaFarmacia.get(i).getFKID_FARM());
        }
    }
}
