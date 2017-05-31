package com.nasa.xmlreader;

import com.sun.syndication.feed.synd.SyndEnclosure;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * Created by Craig on 31/05/2017.
 */
@Controller
public class NASAFeedReader {

    @RequestMapping("/readFeed")
    public ModelAndView readFeed(@RequestParam(value = "queryString", required = false, defaultValue = "Space") String queryString) {

        //Get RSS Feed
        SyndFeed feed = getFeed();
        if(feed==null){
            //TODO - If there's been an error, go to error page
        }

        //Incase the form is filled in empty and submitted
        if(queryString.isEmpty()){
            queryString="Space";
        }

        //Variables for objects, searching etc.
        List<NASAXMLEntry> returnedList=new ArrayList<NASAXMLEntry>();
        Date twoMonthDate = getDateMinus2Months();
        List<SyndEntry> entryList=feed.getEntries();

        //Loop through list of RSS Entries, checking if the title matches search string, and add them to the list if so
        for(SyndEntry entry:entryList){
            {
                if(checkEligible(entry,queryString,twoMonthDate)){
                    returnedList.add(processRSSEntry(entry));
                }
            }
        }

        //Sort the List
        returnedList=sortListByDate(returnedList);

        ModelAndView model = new ModelAndView("readFeed");
        model.addObject("nasaList", returnedList);

        return model;
    }


    private SyndFeed getFeed() {
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed=null;

        try {
             feed = input.build(new XmlReader(new URL("https://www.nasa.gov/rss/dyn/breaking_news.rss")));
            //TODO - Download a backup of the XML
        } catch (FeedException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TODO - if the feed is still null, use the backup XML file
        return feed;
    }

    private boolean checkEligible(SyndEntry entry, String queryString, Date boundaryDate){
        return (entry.getTitle().contains(queryString)) &&(entry.getPublishedDate().after(boundaryDate));
    }

    private NASAXMLEntry processRSSEntry(SyndEntry entry){

        //Get Image Link then instantiate an Entry to return
        SyndEnclosure img=(SyndEnclosure) entry.getEnclosures().get(0);
        NASAXMLEntry newEntry=new NASAXMLEntry(entry.getTitle(),entry.getAuthor(),
                entry.getDescription().getValue(),entry.getLink(),entry.getPublishedDate(),
                img.getUrl());
        return newEntry;
    }

    private Date getDateMinus2Months(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -2);
        return cal.getTime();
    }

    private List<NASAXMLEntry> sortListByDate(List<NASAXMLEntry> entryList){
        entryList.sort((o1,o2) -> o2.getDatePublished().compareTo(o1.getDatePublished()));
        return entryList;
    }
}
