package com.apps.test.presenter

import com.apps.test.domain.model.ServicesCostModel

interface BaseConverter {
    fun convertCost(costs: ServicesCostModel): CostPresenter
}