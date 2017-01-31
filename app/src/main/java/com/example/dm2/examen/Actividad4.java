package com.example.dm2.examen;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Actividad4 extends AppCompatActivity {

    private Spinner cmbOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad4);
        cmbOpciones=(Spinner) findViewById(R.id.CmbOpciones);
        try {
            InputStream fraw = getResources().openRawResource(R.raw.nombres);
            BufferedReader br = new BufferedReader(new InputStreamReader(fraw));
            String linea=br.readLine();
            ArrayList<String>arraylist=new ArrayList<String>();
            while(linea!=null)
            {
                arraylist.add(linea);
               linea =br.readLine() ;
            }
            String[]datos=new String[arraylist.size()];
            for(int i=0;i<arraylist.size();i++)
            {
                datos[i]=arraylist.get(i);
            }
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,datos);
            adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            cmbOpciones.setAdapter(adaptador);
            cmbOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String str=(String)adapterView.getSelectedItem().toString();

                    if(str.equals("disparo"))
                    {
                        MediaPlayer mp= MediaPlayer.create(Actividad4.this, R.raw.disparo);
                        mp.start();
                    }
                    if(str.equals("explosion"))
                    {
                        MediaPlayer mp= MediaPlayer.create(Actividad4.this, R.raw.explosion);
                        mp.start();
                    }
                    if(str.equals("audio"))
                    {
                        MediaPlayer mp= MediaPlayer.create(Actividad4.this, R.raw.audio);
                        mp.start();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    Toast.makeText(Actividad4.this, "audio no seleccionado", Toast.LENGTH_SHORT).show();
                }
            });
        }catch(Exception e)
        {
            Log.e("Ficheros","error en la lectura del fichero de recurso");
        }
    }
}
