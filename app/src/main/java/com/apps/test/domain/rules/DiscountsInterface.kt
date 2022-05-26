package com.apps.test.domain.rules

interface DiscountsInterface {
    fun apply(services: List<String>, serviceCost: Int): Int
}