package com.example.guadalupe.bd_vivero;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText id_planta, nombre_planta, tipo_planta,color_planta,precio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id_planta = (EditText) findViewById(R.id.idPlanta);
        nombre_planta= (EditText) findViewById(R.id.nombPlan);
        tipo_planta= (EditText) findViewById(R.id.tipoPla);
        color_planta = (EditText) findViewById(R.id.color);
        precio= (EditText) findViewById(R.id.precio);

    }

    public void alta (View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "plantas", null, 1);


        SQLiteDatabase bd = admin.getWritableDatabase();

        String idPlanta = id_planta.getText().toString();
        String  nombre_pla= nombre_planta.getText().toString();
        String tipo_plan = tipo_planta.getText().toString();
        String col = color_planta.getText().toString();
        String pre = precio.getText().toString();


        ContentValues registro = new ContentValues();

        registro.put("id_planta", idPlanta);
        registro.put("nombre_planta", nombre_pla);
        registro.put("tipo_planta", tipo_plan);
        registro.put("color_planta", col);
        registro.put("precio", pre);

        bd.insert("plantas", null, registro);
        bd.close();

        id_planta.setText("");
        nombre_planta.setText("");
        tipo_planta.setText("");
        color_planta.setText("");
        precio.setText("");


        Toast.makeText(this,"Se agrego una nueva planta",Toast.LENGTH_SHORT).show();

    }

    public void limpiar (View v) {
        id_planta.setText("");
        nombre_planta.setText("");
        tipo_planta.setText("");
        color_planta.setText("");
        precio.setText("");

    }

    public void consulta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "plantas", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String idPlan = id_planta.getText().toString();
        Cursor fila = bd.rawQuery("select nombre_planta,tipo_planta,color_planta,precio from plantas where id_planta=" + idPlan, null);
        if (fila.moveToFirst()) {
            nombre_planta.setText(fila.getString(0));
            tipo_planta.setText(fila.getString(1));
            color_planta.setText(fila.getString(2));
            precio.setText(fila.getString(3));


        } else {
            Toast.makeText(this,"No existe ninguna planta",Toast.LENGTH_SHORT).show();
        }
        bd.close();
    }

    public void baja(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "plantas", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String idPlan = id_planta.getText().toString();
        int cant = bd.delete("plantas", "id_planta=" + idPlan, null);
        bd.close();

        id_planta.setText("");
        nombre_planta.setText("");
        tipo_planta.setText("");
        color_planta.setText("");
        precio.setText("");


        if (cant == 1) {
            Toast.makeText(this, "Se borró la planta",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No existe la planta",Toast.LENGTH_SHORT).show();
        }
    }

    public void modificacion (View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "plantas", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();


        String idPlanta = id_planta.getText().toString();
        String  nombre_pla= nombre_planta.getText().toString();
        String tipo_plan = tipo_planta.getText().toString();
        String col = color_planta.getText().toString();
        String pre = precio.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("id_planta", idPlanta);
        registro.put("nombre_planta", nombre_pla);
        registro.put("tipo_planta", tipo_plan);
        registro.put("color_planta", col);
        registro.put("precio", pre);


        int cant = bd.update("plantas", registro, "id_planta=" + idPlanta, null);
        bd.close();

        if (cant == 1) {
            Toast.makeText(this, "Se modificaron los datos de la planta",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No existe esa planta",Toast.LENGTH_SHORT).show();
        }

    }

    public void limpia (View v) {

        id_planta.setText("");
        nombre_planta.setText("");
        tipo_planta.setText("");
        color_planta.setText("");
        precio.setText("");

    }

    public void ver (View v) {
        Intent intent = new Intent(MainActivity.this, Activity_plantas.class);
         startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


