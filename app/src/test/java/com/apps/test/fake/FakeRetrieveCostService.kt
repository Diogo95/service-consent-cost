package com.apps.test.fake

import com.apps.test.domain.model.CostsModel
import com.apps.test.interactor.RetrieveCost
import com.usercentrics.sdk.UsercentricsServiceConsent
import com.usercentrics.sdk.UsercentricsUserInteraction

class FakeRetrieveCostService(
    private val costs: CostsModel
): RetrieveCost {
    override fun call(
        userInteraction: UsercentricsUserInteraction,
        consents: List<UsercentricsServiceConsent>
    ): CostsModel {
        return costs
    }
}