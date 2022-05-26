package com.apps.test.interactor

import com.apps.test.data.CMPGateway
import com.apps.test.domain.CalculateAllConsentsCost
import com.apps.test.domain.model.ServicesCostModel
import com.apps.test.domain.RemoveDisabledConsents
import com.apps.test.domain.RetrieveEnabledConsents
import com.usercentrics.sdk.UsercentricsServiceConsent
import com.usercentrics.sdk.UsercentricsUserInteraction

class RetrieveCostService(
    private val cmpGateway: CMPGateway,
    private val retrieveEnabledConsents: RetrieveEnabledConsents,
    private val calculateAllConsentsCost: CalculateAllConsentsCost,
    private val removeNonConsentServices: RemoveDisabledConsents
): RetrieveCost {

    override fun call(userInteraction: UsercentricsUserInteraction, consents: List<UsercentricsServiceConsent>): ServicesCostModel {
        val enabledConsents = retrieveEnabledConsents.getConsents(userInteraction, consents)
        val serviceData = cmpGateway.getCMPDate()
        val appliedConsents = removeNonConsentServices.call(serviceData, enabledConsents)
        return calculateAllConsentsCost.call(appliedConsents)
    }
}
