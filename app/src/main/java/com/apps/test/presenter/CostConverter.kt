package com.apps.test.presenter

import com.apps.test.domain.model.CostsModel

class CostConverter: BaseConverter {
    override fun convertCost(costs: CostsModel): CostPresenter {
        val presenter = StringBuilder()
        costs.serviceCost.forEach {
            presenter.append("${it.name} = ${it.cost}\n")
        }
        presenter.append("Total = ${costs.totalCost}")
        return CostPresenter(presenter.toString(), costs.totalCost)
    }
}
