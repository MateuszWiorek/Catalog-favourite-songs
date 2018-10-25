package com.wiorekmateusz;

import java.util.Vector;

public class FavouriteSongsList {
    public  Vector<FavouriteSongs> listaPiosenek = new Vector<FavouriteSongs>();
    public Vector<FavouriteSongs> getListaPiosenek() {
        return listaPiosenek;
    }

    public void setListaPiosenek(Vector<FavouriteSongs> listaPiosenek) {
        this.listaPiosenek = listaPiosenek;
    }
    public void addToListaPiosenek(FavouriteSongs song){
        this.listaPiosenek.add(song );
    }

}
