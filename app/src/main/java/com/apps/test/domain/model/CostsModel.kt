package com.apps.test.domain.model

data class CostsModel(
    val serviceCost: List<ServiceCostModel>
){
    val totalCost = run {
        var totalCost = 0
        serviceCost.forEach { totalCost += it.cost }
        totalCost
    }
}

data class ServiceCostModel(
    val name: String,
    val cost: Int
)
