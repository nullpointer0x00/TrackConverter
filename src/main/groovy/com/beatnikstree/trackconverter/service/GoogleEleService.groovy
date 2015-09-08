package com.beatnikstree.trackconverter.service

import com.beatnikstree.trackconverter.Environment
import groovy.json.JsonSlurper

/**
 * Created by nullpointer0x00 on 9/7/15.
 */
class GoogleEleService {

    def apiKey = Environment.GOOGLE_API_KEY
    def baseUrl = "https://maps.googleapis.com/maps/api/elevation/json?sensor=false&key=${apiKey}"
    def locationParams = "&locations="

    def getLocationInfo(double lat, double lon){
        def data
        if(apiKey && Environment.isElevationServiceEnabled()) {
            def url = baseUrl + locationParams + """${lat},${lon}"""
            data = new JsonSlurper().parse(new URL(url))
        }
        return data?.results?.elevation ? data.results.elevation[0] : null
    }

}
