package com.apps.test.domain

import com.usercentrics.sdk.UsercentricsServiceConsent
import com.usercentrics.sdk.UsercentricsUserInteraction

class RetrieveEnabledConsentsImplementation: RetrieveEnabledConsents {
    override fun getConsents(userInteraction: UsercentricsUserInteraction, consents: List<UsercentricsServiceConsent>): List<UsercentricsServiceConsent>{
        when(userInteraction) {
            UsercentricsUserInteraction.GRANULAR,
            UsercentricsUserInteraction.NO_INTERACTION,
            UsercentricsUserInteraction.DENY_ALL  -> {
                val newConsents = mutableListOf<UsercentricsServiceConsent>()
                consents.forEach {
                    if (it.status) {
                        newConsents.add(it)
                    }
                }
                return newConsents
            }
            UsercentricsUserInteraction.ACCEPT_ALL -> {
                return consents
            }
        }
    }
}
