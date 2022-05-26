package com.apps.test.fake

import com.apps.test.domain.CalculateConsentCost

class FakeCalculateConsentsCostImplementation(
    private val costs: List<Int> = emptyList()
): CalculateConsentCost {
    override fun call(services: List<String>): Int {
        val cost = costs[count]
        count++
        return cost
    }
    private var count = 0
}