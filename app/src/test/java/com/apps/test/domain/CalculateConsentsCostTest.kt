package com.apps.test.domain

import com.apps.test.data.ServicesCost
import com.apps.test.domain.rules.FakeDiscounts
import org.junit.Assert.assertEquals
import org.junit.Test


internal class CalculateConsentsCostTest{

    @Test
    fun `call() - when it receives a list of services then returns the service cost`(){
        val expected = 8
        val services = listOf(
            "Configuration of app setting",
            "IP address",
            "User behaviour",
            "User agent"
        )

        val fakeBankingSnoopy = FakeDiscounts(0.0)
        val fakeGoodCitizen = FakeDiscounts(0.0)
        val fakeWhyDoYouCare = FakeDiscounts(0.0)

        val subject = CalculateConsentCostImplementation(ServicesCost(), fakeBankingSnoopy, fakeGoodCitizen, fakeWhyDoYouCare).call(services)
        assertEquals(subject, expected)
    }

    @Test
    fun `call() - when it receives an empty list returns 0`(){
        val expected = 0
        val services = emptyList<String>()

        val fakeBankingSnoopy = FakeDiscounts(0.0)
        val fakeGoodCitizen = FakeDiscounts(0.0)
        val fakeWhyDoYouCare = FakeDiscounts(0.0)

        val subject = CalculateConsentCostImplementation(ServicesCost(), fakeBankingSnoopy, fakeGoodCitizen, fakeWhyDoYouCare).call(services)
        assertEquals(subject, expected)
    }
}
