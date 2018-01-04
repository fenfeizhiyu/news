package com.util;

import java.util.Collection;

/**
 * @author yu.yang
 */
public class CheckUtil {


    public static boolean notEmpty(Collection<Object> collection){
            return !isEmpty(collection);
    }

    public static boolean isEmpty(Collection collection){
        if(collection==null||collection.size()==0){
            return true;
        }else {
            return false;
        }
    }

    public static boolean notNull(Object obj){
      return  obj!=null;
    }


}
