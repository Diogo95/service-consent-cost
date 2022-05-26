package com.apps.test.domain

import com.apps.test.data.ServiceData
import com.apps.test.data.ServicesData
import com.usercentrics.sdk.UsercentricsServiceConsent
import org.junit.Assert.assertEquals
import org.junit.Test


internal class RemoveNonConsentServicesTest{

    @Test
    fun `call() - removes services from the service list if they are not in the consents list`(){
        val expected = ServicesData(
                listOf(
                ServiceData(
                    "id1",
                    "name1",
                    listOf(
                        "Service1",
                        "Service2"
                    )
                )
            )
        )
        val serviceData = ServicesData(
            listOf(
                ServiceData(
                    "id1",
                    "name1",
                    listOf(
                        "Service1",
                        "Service2"
                    )
                ),
                ServiceData(
                    "id2",
                    "name2",
                    listOf(
                        "Service1",
                        "Service2"
                    )
                ),
            )
        )
        val consentServices = listOf(
            UsercentricsServiceConsent(
                "id1",
                true,
                emptyList(),
                null,
                "name1",
                "version",
                false
            )
        )

        val subject = RemoveDisabledConsentsImplementation()
        assertEquals(subject.call(serviceData, consentServices), expected)
    }

    @Test
    fun `call() - returns an empty list if there are no consents`(){
        val expected = ServicesData(emptyList())
        val serviceData = ServicesData(
                listOf(
                ServiceData(
                    "id1",
                    "name1",
                    listOf(
                        "Service1",
                        "Service2"
                    )
                ),
                ServiceData(
                    "id2",
                    "name2",
                    listOf(
                        "Service1",
                        "Service2"
                    )
                ),
            )
        )
        val consentServices = emptyList<UsercentricsServiceConsent>()

        val subject = RemoveDisabledConsentsImplementation()
        assertEquals(subject.call(serviceData, consentServices), expected)
    }
}
