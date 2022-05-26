package com.apps.test.data

class ServicesCost {
    companion object {
        val cost = mapOf(
            "Configuration of app setting" to 1,
            "IP address" to 2,
            "User behaviour" to 2,
            "User agent" to 3,
            "App crashes" to -2,
            "Browser information" to 3,
            "Credit and debit card number" to 4,
            "First Name" to 6,
            "Geographic location" to 7,
            "Date and time of visit" to 1,
            "Advertising identifier" to 2,
            "Bank details" to 5,
            "Purchase activity" to 6,
            "Internet service provider" to 4,
            "JavaScript support" to -1
        )
    }
    fun retrieveServiceCost(serviceName: String): Int {
        return cost[serviceName] ?: 0
    }
}