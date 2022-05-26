package com.apps.test.presenter

import com.apps.test.domain.model.CostsModel

interface BaseConverter {
    fun convertCost(costs: CostsModel): CostPresenter
}