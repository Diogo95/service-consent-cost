package com.apps.test.domain.rules

import org.junit.Assert.assertEquals
import org.junit.Test

internal class BankingSnoopyTest{

    @Test
    fun `apply() - when the services contains "Purchase activity", "Bank details" and "Credit and debit card number" returns the service cost with a 10% increase `(){
        val expected = 165
        val services = listOf("Purchase activity", "Bank details", "Credit and debit card number", "Some Other Service")
        val serviceCost = 150

        val subject = BankingSnoopy().apply(services, serviceCost)

        assertEquals(subject , expected)
    }

    @Test
    fun `apply() - when the services contains "Purchase activity" and "Bank details" returns the service cost with no increase `(){
        val expected = 100
        val services = listOf("Purchase activity", "Bank details", "Some Other Service")
        val serviceCost = 100

        val subject = BankingSnoopy().apply(services, serviceCost)

        assertEquals(subject , expected)
    }

    @Test
    fun `apply() - when the services are empty returns the service cost`(){
        val expected = 0
        val services = emptyList<String>()
        val serviceCost = 0

        val subject = BankingSnoopy().apply(services, serviceCost)

        assertEquals(subject , expected)
    }
}