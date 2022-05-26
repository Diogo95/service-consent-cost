package com.apps.test.domain

import com.apps.test.data.ServicesCost
import com.apps.test.domain.rules.DiscountsInterface

class CalculateConsentCostImplementation(
    private val servicesCost: ServicesCost,
    private val bankingSnoopy: DiscountsInterface,
    private val goodCitizen: DiscountsInterface,
    private val whyDoYouCare: DiscountsInterface
): CalculateConsentCost {
    override fun call(services: List<String>): Int{
        var serviceCost = 0
        services.forEach{
            serviceCost += servicesCost.retrieveServiceCost(it)
        }
        serviceCost = bankingSnoopy.apply(services, serviceCost)
        serviceCost = whyDoYouCare.apply(services, serviceCost)
        serviceCost = goodCitizen.apply(services, serviceCost)
        return serviceCost
    }
}
