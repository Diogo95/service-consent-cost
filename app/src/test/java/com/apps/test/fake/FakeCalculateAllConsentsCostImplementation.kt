package com.apps.test.fake

import com.apps.test.data.ServicesData
import com.apps.test.domain.CalculateAllConsentsCost
import com.apps.test.domain.model.CostsModel

class FakeCalculateAllConsentsCostImplementation(
    private val costs: CostsModel = CostsModel(emptyList())
): CalculateAllConsentsCost {
    override fun call(appliedConsents: ServicesData): CostsModel {
        return costs
    }
}
