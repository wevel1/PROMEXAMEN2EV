package com.example.dm2.examen;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Actividad3 extends AppCompatActivity {
    private final String SOAP_ACTION = "http://www.webserviceX.NET/GetAtomicNumber";
    private final String URL = "http://www.webservicex.net/periodictable.asmx";
    private final String METHOD = "GetAtomicNumber";
    private final String NAMESPACE = "http://www.webserviceX.NET";
    private SoapPrimitive spr;

    private Button btnInfo;
    private EditText etElemento;
    private TextView txtSimbolo, txtNumero, txtPeso, txtEbullicion, txtDensidad;

    void volver(View v) {
        finish();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad3);

        btnInfo = (Button) findViewById(R.id.button31);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AsyncCallWS task = new AsyncCallWS();
                task.execute();
            }
        });
    }

    public class AsyncCallWS extends AsyncTask<Void, Void, Void> {

        protected void onPreExecute() {
            Log.i("TAG", "metodo onPreExecute");
        }

        protected Void doInBackground(Void... params) {
            Log.i("TAG", "metodo doInBackground");
            calcular();
            return null;
        }

        protected void onPostExecute(Void aVoid) {
            Log.i("TAG", "metodo onPostExecute");
            txtSimbolo = (TextView) findViewById(R.id.simbolo);
            txtNumero = (TextView) findViewById(R.id.numero);
            txtPeso = (TextView) findViewById(R.id.peso);
            txtEbullicion = (TextView) findViewById(R.id.punto);
            txtDensidad = (TextView) findViewById(R.id.densidad);

            String str = spr.toString();

            //Parseamos el String
            DocumentBuilderFactory factory;
            DocumentBuilder builder;
            InputStream is;
            Document dom;
            try {
                factory = DocumentBuilderFactory.newInstance();
                is = new ByteArrayInputStream(str.getBytes("UTF-8"));
                builder = factory.newDocumentBuilder();

                dom = builder.parse(is);

                Element root = dom.getDocumentElement();
                NodeList tablas = root.getElementsByTagName("Table");
                Node tabla = tablas.item(0);
                Element elementoTabla = (Element) tabla;

                String simbolo = getValorNodo("Symbol",elementoTabla);
                String numero = getValorNodo("AtomicNumber",elementoTabla);
                String peso = getValorNodo("AtomicWeight",elementoTabla);
                String ebullicion = getValorNodo("BoilingPoint",elementoTabla);
                String densidad = getValorNodo("Density",elementoTabla);

                txtSimbolo.setText(simbolo);
                txtNumero.setText(numero);
                txtPeso.setText(peso);
                txtEbullicion.setText(ebullicion);
                txtDensidad.setText(densidad);
            }
            catch(Exception e){}
        }

        private String getValorNodo(String etiqueta, Element elem) {
            NodeList nodo= elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
            Node valornodo = nodo.item(0);
            return	valornodo.getNodeValue().toString();
        }

        public void calcular() {

            //EditText txtKm = (EditText) findViewById(R.id.txtKm);
            //TextView txtvYards = (TextView) findViewById(R.id.txtvYards);
            try {

                etElemento = (EditText) findViewById(R.id.edittext31);
                String s = etElemento.getText().toString();

                SoapObject request = new SoapObject(NAMESPACE, METHOD);

                request.addProperty("ElementName", s);

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);

                HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

                androidHttpTransport.call(SOAP_ACTION, envelope);
                spr = (SoapPrimitive) envelope.getResponse();
                //txtvYards.setText(spr.toString());
                Log.i("bbb", "valor escrito en yardas");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
