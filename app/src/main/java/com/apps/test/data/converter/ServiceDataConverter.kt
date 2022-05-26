package com.apps.test.data.converter

import com.apps.test.data.ServicesData
import com.usercentrics.sdk.v2.settings.data.UsercentricsService

interface ServiceDataConverter {
    fun convert(servicesData: List<UsercentricsService>): ServicesData
}
