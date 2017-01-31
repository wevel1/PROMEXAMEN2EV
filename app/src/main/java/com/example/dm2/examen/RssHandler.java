package com.example.dm2.examen;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;
public class RssHandler extends DefaultHandler{
    private List<Pronostico> pronosticos;
    private Pronostico pronosticoActual;
    private StringBuilder sbTexto;
    public List<Pronostico> getPronosticos(){
        return pronosticos;
    }
    @Override public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (this.pronosticoActual!=null)
            sbTexto.append(ch, start, length);
    }
    @Override public void endElement(String uri, String localName, String name) throws SAXException {
        super.endElement(uri, localName, name);
        if (this.pronosticoActual!=null) {
            if (localName.equals("fecha")) {
                pronosticoActual.setFecha(sbTexto.toString());
            }
            else if (
                    localName.equals("hora_datos")
                    )
            {
                    pronosticoActual.setHora_datos(sbTexto.toString()
                );
            }
            else if
                    (localName.equals("temperatura" ))
            {
                pronosticoActual.setTemperatura(sbTexto.toString());
            }
            else if
                    (localName.equals("texto" ))
            {
                pronosticoActual.setTexto(sbTexto.toString());
            }
            else if
                    (
                    localName.equals("humedad" ))
            {
                pronosticoActual.setFecha(sbTexto.toString());
            }
            else if
                    (localName.equals("presion" ))
            {
                pronosticos.add(pronosticoActual);
            }
            else if
                    (localName.equals("icono" ))
            {
                pronosticos.add(pronosticoActual);
            }
            else if
                    (localName.equals("viento" ))
            {
                pronosticos.add(pronosticoActual);
            }
            else if
                    (localName.equals("dir_viento" ))
            {
                pronosticos.add(pronosticoActual);
            }
            else if
                    (localName.equals("ico_viento" ))
            {
                pronosticos.add(pronosticoActual);
            }
            sbTexto.setLength(0);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        pronosticos = new ArrayList<Pronostico>();
        sbTexto = new StringBuilder();
    }
    @Override public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, name, attributes);
        if (localName.equals("hora" ))
        {
            pronosticoActual = new Pronostico();
        }
    }
}
