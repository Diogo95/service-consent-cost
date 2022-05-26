package com.apps.test.data

data class ServicesData(
    val servicesData: List<ServiceData>
)

data class ServiceData(
    val id: String,
    val name: String,
    val data: List<String>
)

