package com.beatnikstree.trackconverter

/**
 * Created by nullpointer0x00 on 9/7/15.
 */
class Environment {

    static def properties = System.getProperties()

    static Boolean ELE_SERVICE_ENABLED
    static String GOOGLE_API_KEY = properties.getProperty("google.api.key")

    public Environment(){
        ELE_SERVICE_ENABLED = properties.getProperty("ele.service.enabled")
    }

    static Boolean isElevationServiceEnabled(){
        if(ELE_SERVICE_ENABLED == null){
            String prop = properties.getProperty("ele.service.enabled")
            if(prop && prop.equalsIgnoreCase("true")){ ELE_SERVICE_ENABLED = true }else{ ELE_SERVICE_ENABLED = false}
        }
        return ELE_SERVICE_ENABLED
    }

}
