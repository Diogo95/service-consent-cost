package com.apps.test.data.converter

import com.apps.test.data.ServiceData
import com.apps.test.data.ServicesData
import com.usercentrics.sdk.v2.settings.data.UsercentricsService
import org.junit.Assert.assertEquals
import org.junit.Test


internal class ServiceDataObjectConverterTest{

    @Test
    fun `convert() - when it receives an UserCentricsCMPData converts in ServicesDataDTO`(){
        val expected = ServicesData(
            listOf(
                ServiceData("id1", "name", listOf("Service1", "Services2", "Service3"))
            )
        )
        val serviceData = listOf(UsercentricsService(templateId = "id1", dataProcessor = "name", dataCollectedList = listOf("Service1", "Services2")), UsercentricsService(templateId = "id1", dataProcessor = "name", dataCollectedList = listOf("Service1", "Services2", "Service3")))
        val subject = ServiceDataObjectConverter()
        val result = subject.convert(serviceData)

        assertEquals(expected, result)
    }
}