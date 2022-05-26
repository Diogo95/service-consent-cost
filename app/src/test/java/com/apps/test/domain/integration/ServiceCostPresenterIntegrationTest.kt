package com.apps.test.domain.integration

import com.apps.test.ServiceCostManager
import com.apps.test.data.ServiceData
import com.apps.test.data.ServicesCost
import com.apps.test.data.ServicesData
import com.apps.test.domain.CalculateAllConsentsCostImplementation
import com.apps.test.domain.CalculateConsentCostImplementation
import com.apps.test.domain.RemoveDisabledConsentsImplementation
import com.apps.test.domain.RetrieveEnabledConsentsImplementation
import com.apps.test.domain.rules.BankingSnoopy
import com.apps.test.domain.rules.GoodCitizen
import com.apps.test.domain.rules.WhyDoYouCare
import com.apps.test.fake.FakeCMPGatewayImplementation
import com.apps.test.interactor.RetrieveCostService
import com.apps.test.presenter.CostConverter
import com.apps.test.presenter.CostPresenter
import com.usercentrics.sdk.UsercentricsServiceConsent
import com.usercentrics.sdk.UsercentricsUserInteraction
import org.junit.Assert.assertEquals
import org.junit.Test

internal class ServiceCostPresenterIntegrationTest {

    @Test
    fun `returns a string with the names and costs of the services `(){
        val expected = CostPresenter("""
            Facebook = 3
            Google = 5
            Total = 8
        """.trimIndent(),
            8
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

        val subject = ServiceCostManager(
            RetrieveCostService(
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
            ),
            CostConverter()
        )
        val result = subject.serviceCost(userInteraction, consents)

        assertEquals(expected, result)
    }
}
