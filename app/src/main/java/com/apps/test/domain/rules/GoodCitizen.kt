package com.apps.test.domain.rules

import kotlin.math.roundToInt

const val GOOD_CITIZEN_COST = 0.1

class GoodCitizen: DiscountsInterface {
    override fun apply(services: List<String>, serviceCost: Int): Int {
        return if(services.size <= 4){
            (serviceCost - serviceCost.times(GOOD_CITIZEN_COST)).roundToInt()
        } else serviceCost
    }
}
