package com.apps.test.domain.rules

import org.junit.Assert
import org.junit.Test


internal class GoodCitizenTest{

    @Test
    fun `apply() - when there is equal to 4 services then returns the service cost with a 10% decrease `(){
        val expected = 90
        val services = listOf("Purchase activity", "Bank details", "Credit and debit card number", "Some Other Service")
        val serviceCost = 100

        val subject = GoodCitizen().apply(services, serviceCost)

        Assert.assertEquals(subject, expected)
    }

    @Test
    fun `apply() - when there is equal to 3 services then returns the service cost with a 10% decrease `(){
        val expected = 90
        val services = listOf("Purchase activity", "Bank details", "Some Other Service")
        val serviceCost = 100

        val subject = GoodCitizen().apply(services, serviceCost)

        Assert.assertEquals(subject, expected)
    }

    @Test
    fun `apply() - when there is equal to 5 services then returns the service cost with no decrease `(){
        val expected = 100
        val services = listOf("Purchase activity", "Bank details", "Credit and debit card number", "Some Other Service", "One More Service")
        val serviceCost = 100

        val subject = GoodCitizen().apply(services, serviceCost)

        Assert.assertEquals(subject, expected)
    }
}