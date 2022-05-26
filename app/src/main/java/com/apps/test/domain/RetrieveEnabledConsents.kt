package com.apps.test.domain

import com.usercentrics.sdk.UsercentricsServiceConsent
import com.usercentrics.sdk.UsercentricsUserInteraction

interface RetrieveEnabledConsents {
    fun getConsents(
        userInteraction: UsercentricsUserInteraction,
        consents: List<UsercentricsServiceConsent>
    ): List<UsercentricsServiceConsent>
}