package com.example.dm2.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menu_principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);
    }
    void salir(View v)
    {
        finish();
    }
    void tiempo(View v)
    {
        Intent intent = new Intent(menu_principal.this, Actividad2.class);
        startActivity(intent);
    }
    void atomo(View v)
    {
        Intent intent = new Intent(menu_principal.this, Actividad3.class);
        startActivity(intent);
    }
    void multi(View v)
    {
        Intent intent = new Intent(menu_principal.this, Actividad4.class);
        startActivity(intent);
    }
}
