package com.apps.test.fake

import com.apps.test.domain.RetrieveEnabledConsents
import com.usercentrics.sdk.UsercentricsServiceConsent
import com.usercentrics.sdk.UsercentricsUserInteraction

class FakeRetrieveConsentsImplementation(
    private val consentsToReturn: List<UsercentricsServiceConsent> = emptyList()
): RetrieveEnabledConsents {
    override fun getConsents(
        userInteraction: UsercentricsUserInteraction,
        consents: List<UsercentricsServiceConsent>
    ): List<UsercentricsServiceConsent> {
        return consentsToReturn
    }
}