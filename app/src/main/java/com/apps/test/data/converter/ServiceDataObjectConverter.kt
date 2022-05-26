package com.apps.test.data.converter

import com.apps.test.data.ServiceData
import com.apps.test.data.ServicesData
import com.usercentrics.sdk.v2.settings.data.UsercentricsService

class ServiceDataObjectConverter: ServiceDataConverter {
    override fun convert(servicesData: List<UsercentricsService>): ServicesData {
        val cmpData = mutableListOf<ServiceData>()
        servicesData.forEach { serviceData ->
            val newServiceData = cmpData.find { it.name == serviceData.dataProcessor!! }
            if (newServiceData != null) {
                cmpData.remove(newServiceData)
                cmpData.add(
                    ServiceData(
                        serviceData.templateId!!,
                        serviceData.dataProcessor!!,
                        (serviceData.dataCollectedList + newServiceData.data).distinct()
                    )
                )
            } else {
                cmpData.add(ServiceData(serviceData.templateId!!, serviceData.dataProcessor!!, serviceData.dataCollectedList))
            }
        }
        return ServicesData(cmpData)
    }
}
