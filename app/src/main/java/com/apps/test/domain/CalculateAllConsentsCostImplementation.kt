package com.apps.test.domain

import com.apps.test.data.ServicesData
import com.apps.test.domain.model.CostsModel
import com.apps.test.domain.model.ServiceCostModel

class CalculateAllConsentsCostImplementation(
    private val calculateConsentCost: CalculateConsentCost,
):CalculateAllConsentsCost {
    override fun call(appliedConsents: ServicesData): CostsModel {

        return CostsModel(appliedConsents.servicesData.map {
            ServiceCostModel(it.name, calculateConsentCost.call(it.data))
            }
        )
    }
}
