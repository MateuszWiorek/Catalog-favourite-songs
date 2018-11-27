package com.wiorekmateusz;

import java.util.*;


public class FavouriteSongsList {
    public List<FavouriteSongs> listaPiosenek = new ArrayList<FavouriteSongs>();
        public List<FavouriteSongs> getListaPiosenek() {
            return listaPiosenek;
        }

        public void setListaPiosenek(List<FavouriteSongs> listaPiosenek) {
            this.listaPiosenek = listaPiosenek;
        }

        public void addToListaPiosenek(FavouriteSongs song) {
            this.listaPiosenek.add(song);
        }

    }

