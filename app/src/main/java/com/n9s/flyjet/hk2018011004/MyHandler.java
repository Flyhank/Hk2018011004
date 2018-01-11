package com.n9s.flyjet.hk2018011004;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class MyHandler extends DefaultHandler
{
    boolean isTitle = false;
    boolean isItem = false;

    public ArrayList<String> titles = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        super.startElement(uri, localName, qName, attributes);
        //Log.d("NET", qName);
        if (qName.equals("title"))
        {
            isTitle = true;
        }
        if (qName. equals("item"))
        {
            isItem = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
                                                    //結束一段新聞時,若Title後跟著Item, 則只是標題
    {
        super.endElement(uri, localName, qName);
        if (qName.equals("title"))
        {
            isTitle = false;
        }
        if (qName.equals("item"))
        {
            isItem = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (isTitle && isItem)
        {
            Log.d("NET", new String(ch, start, length));
            titles.add(new String(ch, start, length));
        }

    }
}
