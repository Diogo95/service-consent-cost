package com.apps.test.domain.rules

import java.lang.Math.round
import kotlin.math.roundToInt

const val BANKING_SNOOPY_COST = 1.1

class BankingSnoopy: DiscountsInterface {
    override fun apply(services: List<String>, serviceCost: Int): Int {
        return if(services.contains("Purchase activity") &&
            services.contains("Bank details") &&
            services.contains("Credit and debit card number"))
            serviceCost.times(BANKING_SNOOPY_COST).roundToInt()
        else serviceCost
    }
}