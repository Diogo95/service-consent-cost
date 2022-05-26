package com.apps.test.fake

import com.apps.test.data.ServicesData
import com.apps.test.domain.RemoveDisabledConsents
import com.usercentrics.sdk.UsercentricsServiceConsent

class FakeRemoveNonConsentServicesImplementation(
    private val services: ServicesData = ServicesData(emptyList())
): RemoveDisabledConsents {
    override fun call(
        serviceData: ServicesData,
        consents: List<UsercentricsServiceConsent>
    ): ServicesData {
        return services
    }
}
