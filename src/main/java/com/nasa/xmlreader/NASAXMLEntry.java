package com.nasa.xmlreader;

import java.util.Date;

public class NASAXMLEntry {

    Date datePublished;
    String title;
    String author;
    String description;
    String link;
    String thumbnailLink;

    NASAXMLEntry(String title, String author, String description, String link, Date datePublished, String thumbnailLink){
        this.title=title;
        this.author=author;
        this.description=description;
        this.link=link;
        this.datePublished=datePublished;
        this.thumbnailLink=thumbnailLink;
    }

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
