package com.apps.test.domain

import com.apps.test.data.ServicesData
import com.usercentrics.sdk.UsercentricsServiceConsent

interface RemoveDisabledConsents {
    fun call(serviceData: ServicesData, consents: List<UsercentricsServiceConsent>): ServicesData
}
