package com.apps.test.fake

import com.apps.test.domain.model.ServicesCostModel
import com.apps.test.interactor.RetrieveCost
import com.usercentrics.sdk.UsercentricsServiceConsent
import com.usercentrics.sdk.UsercentricsUserInteraction

class FakeRetrieveCostService(
    private val costs: ServicesCostModel
): RetrieveCost {
    override fun call(
        userInteraction: UsercentricsUserInteraction,
        consents: List<UsercentricsServiceConsent>
    ): ServicesCostModel {
        return costs
    }
}