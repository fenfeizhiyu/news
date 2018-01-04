package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yu.yang
 */
public class SaveUnit {

    private NewSource newSource;

    private List<NewsTitle> newsTitles;

    public SaveUnit(NewSource newSource){
        this.newSource=newSource;
        this.newsTitles = new ArrayList<NewsTitle>();
    }

    public NewSource getNewSource() {
        return newSource;
    }

    public void setNewSource(NewSource newSource) {
        this.newSource = newSource;
    }

    public List<NewsTitle> getNewsTitles() {
        return newsTitles;
    }

    public void setNewsTitles(List<NewsTitle> newsTitles) {
        this.newsTitles = newsTitles;
    }
}
