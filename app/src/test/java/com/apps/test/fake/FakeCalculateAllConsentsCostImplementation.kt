package com.apps.test.fake

import com.apps.test.data.ServicesData
import com.apps.test.domain.CalculateAllConsentsCost
import com.apps.test.domain.model.ServicesCostModel

class FakeCalculateAllConsentsCostImplementation(
    private val costs: ServicesCostModel = ServicesCostModel(emptyList())
): CalculateAllConsentsCost {
    override fun call(appliedConsents: ServicesData): ServicesCostModel {
        return costs
    }
}
