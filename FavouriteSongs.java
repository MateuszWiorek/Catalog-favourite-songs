package com.wiorekmateusz;


public class FavouriteSongs {

    private int id;
    private String title;
    private String author;
    private String link;

    FavouriteSongs(String title, String author, String link){
        this.title=title;
        this.author=author;
        this.link=link;
    }


    public FavouriteSongs() {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


public String toString(){
        return "Title: " +title +"     Author: " + author + "      Link: "+ link;
}
}
