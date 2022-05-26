package com.apps.test

import com.apps.test.interactor.RetrieveCost
import com.apps.test.presenter.BaseConverter
import com.apps.test.presenter.CostPresenter
import com.usercentrics.sdk.UsercentricsServiceConsent
import com.usercentrics.sdk.UsercentricsUserInteraction

class ServiceCostManager(
    private val retrieveCostService: RetrieveCost,
    private val costPresenter: BaseConverter
) {
    fun serviceCost(
        userInteraction: UsercentricsUserInteraction,
        consents: List<UsercentricsServiceConsent>
    ): CostPresenter {
        val cost = retrieveCostService.call(userInteraction, consents)
        return costPresenter.convertCost(cost)
    }
}
