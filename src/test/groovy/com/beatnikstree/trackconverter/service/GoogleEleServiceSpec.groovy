package com.beatnikstree.trackconverter.service

import com.beatnikstree.trackconverter.BaseSpec

/**
 * Created by nullpointer0x00 on 9/7/15.
 */
class GoogleEleServiceSpec extends BaseSpec{


    def "get location info"(){
        setup:
        GoogleEleService service = new GoogleEleService()
        when:
        def response = service.getLocationInfo(-33.88471, 151.218237)
        then:
        [56.6168212890625, null].contains(response)
    }
}
