package com.apps.test.domain

import com.apps.test.data.ServicesData
import com.apps.test.domain.model.ServicesCostModel

interface CalculateAllConsentsCost {
    fun call(appliedConsents: ServicesData): ServicesCostModel
}
