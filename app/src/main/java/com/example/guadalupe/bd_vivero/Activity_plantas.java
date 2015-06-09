package com.example.guadalupe.bd_vivero;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Activity_plantas extends ActionBarActivity {
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantas);


        List<modeloPlantas> items = new ArrayList<>();

        AdminSQLiteOpenHelper funcion = new AdminSQLiteOpenHelper(this, "plantas", null, 1);
        SQLiteDatabase BD = funcion.getWritableDatabase();
        Cursor fila = BD.rawQuery("select id_planta, nombre_planta, tipo_planta, color_planta, precio from Plantas", null);
        for(fila.moveToFirst(); !fila.isAfterLast(); fila.moveToNext()){
            items.add (new modeloPlantas(fila.getString(0), fila.getString(1), fila.getString(2), fila.getString(3), fila.getString(4)));
        }

        recycler = (RecyclerView) findViewById(R.id.list);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        adapter = new plantasadapter(items);
        recycler.setAdapter(adapter);
        BD.close();
    }
}




