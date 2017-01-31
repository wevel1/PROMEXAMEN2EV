package com.example.dm2.examen;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class Actividad2 extends AppCompatActivity {
    List<Pronostico> pronosticos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2);
    }
    void volver(View v)
    {
        finish();
    }
    void bilbo(View v)
    {
        TextView txt=(TextView) findViewById(R.id.textview23);
        txt.setText("BILBO-BILBAO");
        CargarXmlTask tarea = new CargarXmlTask();
        tarea.execute("http://xml.tutiempo.net/xml/8050.xml");
    }
    void gasteiz(View v)
    {
        TextView txt=(TextView) findViewById(R.id.textview23);
        txt.setText("VITORIA-GASTEIZ");
        CargarXmlTask tarea = new CargarXmlTask();
        tarea.execute("http://xml.tutiempo.net/xml/8043.xml");
    }
    void donosti(View v)
    {
        TextView txt=(TextView) findViewById(R.id.textview23);
        txt.setText("DONOSTIA-SAN SEBASTIAN");
        CargarXmlTask tarea = new CargarXmlTask();
        tarea.execute("http://xml.tutiempo.net/xml/4917.xml");
    }
    //Tarea Asíncrona para cargar un XML en segundo plano
    private class
    CargarXmlTask extends AsyncTask<String,Integer,Boolean> {
        protected Boolean doInBackground(String... params) {
            RssParserSax saxparser = new RssParserSax(params[0]);
            pronosticos = saxparser.parse();
            return true;
        }
    protected void
    onPostExecute(Boolean result) {
        for (int i= 0; i< pronosticos.size()&&i<1; i++)
        {
            TextView txt=(TextView) findViewById(R.id.textview24);
            txt.setVisibility(View.VISIBLE);
            txt=(TextView) findViewById(R.id.textview25);
            txt.setVisibility(View.VISIBLE);
            txt=(TextView) findViewById(R.id.textview26);
            txt.setVisibility(View.VISIBLE);
            txt=(TextView) findViewById(R.id.cielo);
            txt.setVisibility(View.VISIBLE);
            txt.setText(pronosticos.get(i).getTexto());
            txt=(TextView) findViewById(R.id.hora);
            txt.setVisibility(View.VISIBLE);
            txt.setText(pronosticos.get(i).getHora_datos());
            txt=(TextView) findViewById(R.id.temperatura);
            txt.setVisibility(View.VISIBLE);
            txt.setText(pronosticos.get(i).getTemperatura());
           // txtResultado.setText(txtResultado.getText().toString() + System.getProperty("line.separator" ) +
             //       noticias.get(i).getTitulo());
        }
    }
}

}


