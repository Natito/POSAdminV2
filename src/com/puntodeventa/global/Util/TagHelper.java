package com.puntodeventa.global.Util;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Jorge Hernandez
 */
public class TagHelper {

    public static String getTag(String tagName) {
        LogHelper objLog = new LogHelper("TagHelper");
        Properties prop = new Properties();
        String returnValue = "";

        try {            
            prop.load(TagHelper.class.getResourceAsStream("/com/puntodeventa/global/Content/tags.properties"));
            returnValue =  prop.getProperty(tagName).toString();

        } catch (IOException ex) {
            objLog.Log(ex.getMessage());
        }
        
        return returnValue;
    }
}
