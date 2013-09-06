package com.puntodeventa.global.Util;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Jorge Hernandez
 */
public class ParamHelper {

    public static Object getParam(String propertyName) {
        LogHelper objLog = new LogHelper("TextHelper");
        Properties prop = new Properties();
        Object returnValue = null;
        
        try {
            
            prop.load(ParamHelper.class.getResourceAsStream("/com/puntodeventa/settings/params.properties"));
            returnValue = prop.getProperty(propertyName);

        } catch (IOException ex) {
            objLog.Log(ex.getMessage());
        }
        
        return returnValue;
    }
}
