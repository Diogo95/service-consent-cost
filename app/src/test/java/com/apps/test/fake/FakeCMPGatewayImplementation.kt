package com.apps.test.fake

import com.apps.test.data.CMPGateway
import com.apps.test.data.ServicesData

class FakeCMPGatewayImplementation(
    private val servicesData: ServicesData = ServicesData(emptyList())
): CMPGateway {
    override fun getCMPDate(): ServicesData {
        return servicesData
    }
}