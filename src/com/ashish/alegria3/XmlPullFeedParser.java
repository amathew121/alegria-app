package com.ashish.alegria3;

import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.app.Activity;
import android.util.Xml;

import com.ashish.alegria3.util.BaseFeedParser;

public class XmlPullFeedParser extends BaseFeedParser {
    public XmlPullFeedParser(String feedUrl) {
        super(feedUrl);
    }
    public XmlPullFeedParser(Activity mActivity) {
    	super(mActivity);
    }
    public List<Event> parse() {
        List<Event> events = null;
        XmlPullParser parser = Xml.newPullParser();
        try {
            // auto-detect the encoding from the stream
            parser.setInput(this.getInputStream("alegria.xml"), null);
            int eventType = parser.getEventType();
            Event currentEvent = null;
            boolean done = false;
            while (eventType != XmlPullParser.END_DOCUMENT && !done){
                String name = null;
                switch (eventType){
                    case XmlPullParser.START_DOCUMENT:
                        events = new ArrayList<Event>();
                        break;
                    case XmlPullParser.START_TAG:
                        name = parser.getName();
                        if (name.equalsIgnoreCase(EVENT)){
                        	currentEvent = new Event();
                        	currentEvent.setEventId(parser.getAttributeValue(null, "id"));
                        } else if (currentEvent != null){
                            if (name.equalsIgnoreCase(RULE)){
                            	currentEvent.getRules().add(parser.nextText());
                            } else if (name.equalsIgnoreCase(TITLE)){
                            	currentEvent.setTitle(parser.nextText());
                            }    
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        name = parser.getName();
                        if (name.equalsIgnoreCase(EVENT) && 
currentEvent != null){
                            events.add(currentEvent);
                        } else if (name.equalsIgnoreCase("management")){
                            done = true;
                        }
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return events;
    }
}