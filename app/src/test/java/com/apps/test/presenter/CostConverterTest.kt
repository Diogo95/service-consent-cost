package com.apps.test.presenter

import com.apps.test.domain.model.CostsModel
import com.apps.test.domain.model.ServiceCostModel
import org.junit.Assert.assertEquals
import org.junit.Test


internal class CostConverterTest{

    @Test
    fun `call() - when it receives a CostModel returns a string presenter`(){
        val expected = CostPresenter("""
            Facebook = 6
            Google = 4
            Total = 10
        """.trimIndent(),
            10
        )

        val cost = CostsModel(
            listOf(
                ServiceCostModel(
                    "Facebook",
                    6
                ),
                ServiceCostModel(
                    "Google",
                    4
                )
            )
        )

        val subject = CostConverter()
        val result = subject.convertCost(cost)

        assertEquals(expected, result)
    }
}
