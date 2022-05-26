package com.apps.test.domain.rules

class FakeDiscounts(private val discountToApply: Double): DiscountsInterface {
    override fun apply(services: List<String>, serviceCost: Int): Int {
        return (serviceCost + serviceCost.times(discountToApply)).toInt()
    }
}