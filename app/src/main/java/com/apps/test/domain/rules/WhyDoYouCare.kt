package com.apps.test.domain.rules

import kotlin.math.roundToInt

const val WHY_DO_YOU_CARE_COST = 1.27

class WhyDoYouCare: DiscountsInterface {
    override fun apply(services: List<String>, serviceCost: Int): Int {
        return if(services.contains("Search terms") &&
            services.contains("Geographic location") &&
            services.contains("Number of page views"))
            serviceCost.times(WHY_DO_YOU_CARE_COST).roundToInt()
        else serviceCost
    }
}