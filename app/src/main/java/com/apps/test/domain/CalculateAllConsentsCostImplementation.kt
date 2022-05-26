package com.apps.test.domain

import com.apps.test.data.ServicesData
import com.apps.test.domain.model.ServicesCostModel
import com.apps.test.domain.model.ServiceCostModel

class CalculateAllConsentsCostImplementation(
    private val calculateConsentCost: CalculateConsentCost,
):CalculateAllConsentsCost {
    override fun call(appliedConsents: ServicesData): ServicesCostModel {

        return ServicesCostModel(appliedConsents.servicesData.map {
            ServiceCostModel(it.name, calculateConsentCost.call(it.data))
            }
        )
    }
}
