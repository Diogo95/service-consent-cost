package com.apps.test.data

import com.apps.test.data.converter.ServiceDataConverter
import com.usercentrics.sdk.Usercentrics

class CMPGatewayImplementation(
    private val serviceDataConverter: ServiceDataConverter
): CMPGateway {
    override fun getCMPDate(): ServicesData {
        val userCentricsCMPData =  Usercentrics.instance.getCMPData().services
        return serviceDataConverter.convert(userCentricsCMPData)
    }
}
