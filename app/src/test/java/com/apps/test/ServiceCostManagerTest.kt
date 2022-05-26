package com.apps.test

import com.apps.test.domain.model.CostsModel
import com.apps.test.domain.model.ServiceCostModel
import com.apps.test.fake.FakeCostPresenter
import com.apps.test.fake.FakeRetrieveCostService
import com.apps.test.presenter.CostPresenter
import com.usercentrics.sdk.UsercentricsServiceConsent
import com.usercentrics.sdk.UsercentricsUserInteraction
import org.junit.Assert.assertEquals
import org.junit.Test


internal class ServiceCostManagerTest{

    @Test
    fun `serviceCost() - returns a string with the names and costs of the services`(){
        val expected = CostPresenter("""
            Facebook = 6
            Google = 4
            Total = 10
        """.trimIndent(), 10
        )

        val cost = CostsModel(
            listOf(
                ServiceCostModel(
                    "Facebook",
                    6
                ),
                ServiceCostModel(
                    "Google",
                    4
                )
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
        val calculateConsentsCostFake = FakeRetrieveCostService(cost)
        val costPresenterFake = FakeCostPresenter(
            CostPresenter(
                """
                Facebook = 6
                Google = 4
                Total = 10
            """.trimIndent(),
                10)
        )

        val subject = ServiceCostManager(calculateConsentsCostFake, costPresenterFake)
        val result = subject.serviceCost(userInteraction, consents)

        assertEquals(expected, result)
    }
}
