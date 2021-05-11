package com.example.linkstorer;

public class Link {

    public String link;
    public String linkDesc;

    public Link(String link, String linkDesc){

        this.link = link;
        this.linkDesc = linkDesc;
    }

    public Link() {

    }

    public String getLink() {
        return link;
    }

    public String getLinkDesc() {
        return linkDesc;
    }
}
