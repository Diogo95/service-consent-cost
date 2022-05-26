package com.apps.test.domain

import com.usercentrics.sdk.UsercentricsServiceConsent
import com.usercentrics.sdk.UsercentricsUserInteraction
import org.junit.Assert.assertEquals
import org.junit.Test


internal class RetrieveConsentsTest{

    @Test
    fun`call() - returns all the consents when its an ACCEPT_ALL interaction`(){
        val expected = listOf(
            UsercentricsServiceConsent(
                "id1",
                true,
                emptyList(),
                null,
                "name1",
                "version",
                false
            ),
            UsercentricsServiceConsent(
                "id2",
                true,
                emptyList(),
                null,
                "name2",
                "version",
                false
            )
        )
        val consents = listOf(
            UsercentricsServiceConsent(
                "id1",
                true,
                emptyList(),
                null,
                "name1",
                "version",
                false
            ),
            UsercentricsServiceConsent(
                "id2",
                true,
                emptyList(),
                null,
                "name2",
                "version",
                false
            )
        )

        val subject = RetrieveEnabledConsentsImplementation()
        val result = subject.getConsents(UsercentricsUserInteraction.ACCEPT_ALL, consents)

        assertEquals(result, expected)
    }

    @Test
    fun`call() - returns only the consents with status a true when its a GRANULAR interaction`(){
        val expected = listOf(
            UsercentricsServiceConsent(
                "id1",
                true,
                emptyList(),
                null,
                "name1",
                "version",
                false
            )
        )
        val consents = listOf(
            UsercentricsServiceConsent(
                "id1",
                true,
                emptyList(),
                null,
                "name1",
                "version",
                false
            ),
            UsercentricsServiceConsent(
                "id2",
                false,
                emptyList(),
                null,
                "name2",
                "version",
                false
            )
        )

        val subject = RetrieveEnabledConsentsImplementation()
        val result = subject.getConsents(UsercentricsUserInteraction.GRANULAR, consents)

        assertEquals(result, expected)
    }

    @Test
    fun`call() - returns only the consents with status a true when its a NO_INTERACTION interaction`(){
        val expected = listOf(
            UsercentricsServiceConsent(
                "id1",
                true,
                emptyList(),
                null,
                "name1",
                "version",
                false
            )
        )
        val consents = listOf(
            UsercentricsServiceConsent(
                "id1",
                true,
                emptyList(),
                null,
                "name1",
                "version",
                false
            ),
            UsercentricsServiceConsent(
                "id2",
                false,
                emptyList(),
                null,
                "name2",
                "version",
                false
            )
        )

        val subject = RetrieveEnabledConsentsImplementation()
        val result = subject.getConsents(UsercentricsUserInteraction.NO_INTERACTION, consents)

        assertEquals(result, expected)
    }

    @Test
    fun`call() - returns only the consents with status a true when its a DENY_ALL interaction`(){
        val expected = listOf(
            UsercentricsServiceConsent(
                "id1",
                true,
                emptyList(),
                null,
                "name1",
                "version",
                false
            )
        )
        val consents = listOf(
            UsercentricsServiceConsent(
                "id1",
                true,
                emptyList(),
                null,
                "name1",
                "version",
                false
            ),
            UsercentricsServiceConsent(
                "id2",
                false,
                emptyList(),
                null,
                "name2",
                "version",
                false
            )
        )

        val subject = RetrieveEnabledConsentsImplementation()
        val result = subject.getConsents(UsercentricsUserInteraction.DENY_ALL, consents)

        assertEquals(result, expected)
    }
}
