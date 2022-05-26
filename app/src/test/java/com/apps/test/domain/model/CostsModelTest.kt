package com.apps.test.domain.model

import org.junit.Assert.assertEquals
import org.junit.Test


internal class CostsModelTest{

    @Test
    fun`retrieves the total cost of the services`(){
        val expected = 8
        val costs = ServicesCostModel(
            listOf(
                ServiceCostModel(
            "Facebook",
            3
                ),
                ServiceCostModel(
                "Google",
                5
                )
            )
        )
        assertEquals(expected, costs.totalCost)
    }
}
