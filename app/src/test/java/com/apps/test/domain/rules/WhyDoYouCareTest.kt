package com.apps.test.domain.rules

import org.junit.Assert.assertEquals
import org.junit.Test


internal class WhyDoYouCareTest {

    @Test
    fun `apply() - when the services contains "Search terms", "Geographic location" and "Number of page views" returns the service cost with a 27% increase `(){
        val expected = 127
        val services = listOf("Search terms", "Geographic location", "Number of page views", "Some Other Service")
        val serviceCost = 100

        val subject = WhyDoYouCare().apply(services, serviceCost)

        assertEquals(subject, expected)
    }

    @Test
    fun `apply() - when the services contains "Search terms", "Geographic location" returns the service cost with no increase `(){
        val expected = 100
        val services =  listOf("Search terms", "Geographic location", "Some Other Service")
        val serviceCost = 100

        val subject = WhyDoYouCare().apply(services, serviceCost)

        assertEquals(subject, expected)
    }

    @Test
    fun `apply() - when the services are empty returns the service cost`(){
        val expected = 0
        val services = emptyList<String>()
        val serviceCost = 0

        val subject = WhyDoYouCare().apply(services, serviceCost)

        assertEquals(subject, expected)
    }

}