package com.apps.test.interactor

import com.apps.test.domain.model.ServicesCostModel
import com.usercentrics.sdk.UsercentricsServiceConsent
import com.usercentrics.sdk.UsercentricsUserInteraction

interface RetrieveCost {
    fun call(userInteraction: UsercentricsUserInteraction, consents: List<UsercentricsServiceConsent>): ServicesCostModel
}