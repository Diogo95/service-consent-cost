package com.apps.test.domain

import com.apps.test.data.ServiceData
import com.apps.test.data.ServicesData
import com.apps.test.domain.model.CostsModel
import com.apps.test.domain.model.ServiceCostModel
import com.apps.test.fake.*
import com.apps.test.interactor.RetrieveCostService
import com.usercentrics.sdk.UsercentricsServiceConsent
import com.usercentrics.sdk.UsercentricsUserInteraction
import org.junit.Assert.assertEquals
import org.junit.Test


internal class RetrieveCostTest{

    @Test
    fun `when receives a list of consents and an user interaction returns the cost of each service and their total`(){
        val expected = CostsModel(
            listOf(
                ServiceCostModel("Facebook", 3),
                ServiceCostModel("Google", 6)
            )
        )
        val userInteraction = UsercentricsUserInteraction.ACCEPT_ALL
        val consents = listOf(
            UsercentricsServiceConsent(
                "id1",
                true,
                emptyList(),
                null,
                "Facebook",
                "version",
                false
            ),
            UsercentricsServiceConsent(
                "id2",
                true,
                emptyList(),
                null,
                "Google",
                "version",
                false
            )
        )

        val serviceData = ServicesData(
            listOf(
                ServiceData(
                    "id1",
                    "Facebook",
                    listOf("Service1", "Service2")
                ),
                ServiceData(
                    "id2",
                    "Google",
                    listOf("Service1", "Service3")
                )
            )
        )
        val costs = CostsModel(
            listOf(
                ServiceCostModel("Facebook", 3),
                ServiceCostModel("Google", 6)
            )
        )

        val cmpGatewayFake = FakeCMPGatewayImplementation(serviceData)
        val retrieveConsentsFake = FakeRetrieveConsentsImplementation(consents)
        val calculateConsentsCostFake = FakeCalculateAllConsentsCostImplementation(costs)
        val removeNonConsentServicesFake = FakeRemoveNonConsentServicesImplementation(serviceData)

        val subject = RetrieveCostService(cmpGatewayFake, retrieveConsentsFake, calculateConsentsCostFake, removeNonConsentServicesFake)
        val response = subject.call(userInteraction, consents)

        assertEquals(response, expected)
    }
}
