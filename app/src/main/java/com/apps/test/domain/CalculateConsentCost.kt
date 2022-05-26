package com.apps.test.domain

interface CalculateConsentCost {
    fun call(services: List<String>): Int
}
