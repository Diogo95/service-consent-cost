package com.apps.test.domain

import com.apps.test.data.ServiceData
import com.apps.test.data.ServicesData
import com.apps.test.domain.model.CostsModel
import com.apps.test.domain.model.ServiceCostModel
import com.apps.test.fake.FakeCalculateConsentsCostImplementation
import org.junit.Assert.assertEquals
import org.junit.Test


internal class CalculateAllConsentsCostImplementationTest{

    @Test
    fun `call() - when it receives a serviceData returns a costModel object`(){
        val expected = CostsModel(
            listOf(
                ServiceCostModel(
                    "Facebook",
                    10
                ),
                ServiceCostModel(
                    "Google",
                    20
                )
            )
        )
        val servicesData = ServicesData(
            listOf(
                ServiceData(
                    "id1",
                    "Facebook",
                    listOf(
                        "Service1",
                        "Service2"
                    )
                ),
                ServiceData(
                    "id2",
                    "Google",
                    listOf(
                        "Service3",
                        "Service2"
                    )
                )
            )
        )
        val fakeCalculateConsentCost = FakeCalculateConsentsCostImplementation(listOf(10, 20))

        val subject = CalculateAllConsentsCostImplementation(fakeCalculateConsentCost)
        val result = subject.call(servicesData,)

        assertEquals(expected, result)
    }
}
