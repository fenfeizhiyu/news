package com.save;

import com.model.SaveUnit;

import java.util.List;

/**
 * @author yu.yang
 */
public class FileSave {


    public void saveUnits(List<SaveUnit> saveUnitList) {
        for(SaveUnit s :saveUnitList){
            saveUnit(s);
        }
    }

    public void saveUnit(SaveUnit saveUnit){
        String pref=saveUnit.getNewSource().getSaveText();


    }
}
