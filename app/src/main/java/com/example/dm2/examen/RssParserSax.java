package com.example.dm2.examen;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
public class RssParserSax {
    private URL rssUrl;
    public RssParserSax(String url) {
        try
        {
            this.rssUrl = new URL(url);
        }
        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Pronostico> parse() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try
        {
            SAXParser parser = factory.newSAXParser();
            RssHandler handler = new RssHandler();
            parser.parse(this.getInputStream(), handler);
            return handler.getPronosticos();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private InputStream getInputStream() {
        try
        {
            return rssUrl.openConnection().getInputStream();
        }
        catch (IOException e) {
            throw new
                    RuntimeException(e);
        }
    }
}
