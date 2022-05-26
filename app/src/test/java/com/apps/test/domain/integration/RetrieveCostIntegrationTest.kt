package com.apps.test.domain.integration

import com.apps.test.fake.FakeCMPGatewayImplementation
import com.apps.test.data.ServiceData
import com.apps.test.data.ServicesCost
import com.apps.test.data.ServicesData
import com.apps.test.domain.*
import com.apps.test.domain.model.ServicesCostModel
import com.apps.test.domain.model.ServiceCostModel
import com.apps.test.domain.rules.BankingSnoopy
import com.apps.test.domain.rules.GoodCitizen
import com.apps.test.domain.rules.WhyDoYouCare
import com.apps.test.interactor.RetrieveCostService
import com.usercentrics.sdk.UsercentricsServiceConsent
import com.usercentrics.sdk.UsercentricsUserInteraction
import org.junit.Assert.assertEquals
import org.junit.Test

internal class RetrieveCostIntegrationTest {

    @Test
    fun `when the user accept all and there is consented services consents returns the cost of the services and their total`(){
        val expected = ServicesCostModel(
            listOf(
                ServiceCostModel("Facebook", 3),
                ServiceCostModel("Google", 5)
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
                    listOf("Configuration of app setting", "IP address")
                ),
                ServiceData(
                    "id2",
                    "Google",
                    listOf("User agent", "Browser information")
                )
            )
        )

        val subject = RetrieveCostService(
            FakeCMPGatewayImplementation(serviceData),
            RetrieveEnabledConsentsImplementation(),
            CalculateAllConsentsCostImplementation(
                CalculateConsentCostImplementation(
                    ServicesCost(),
                    BankingSnoopy(),
                    GoodCitizen(),
                    WhyDoYouCare()
                )
            ),
            RemoveDisabledConsentsImplementation()
        )
        val result = subject.call(userInteraction, consents)

        assertEquals(expected, result)
    }

}