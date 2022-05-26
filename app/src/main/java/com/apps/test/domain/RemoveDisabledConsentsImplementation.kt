package com.apps.test.domain

import com.apps.test.data.ServiceData
import com.apps.test.data.ServicesData
import com.usercentrics.sdk.UsercentricsServiceConsent

class RemoveDisabledConsentsImplementation: RemoveDisabledConsents {
    override fun call(serviceData: ServicesData, consents: List<UsercentricsServiceConsent>): ServicesData {
        val newServiceData = mutableListOf<ServiceData>()
        serviceData.servicesData.forEach { service ->
            consents.forEach { consent ->
                if(service.id == consent.templateId)
                    newServiceData.add(service)
            }
        }
        return ServicesData(newServiceData)
    }
}
