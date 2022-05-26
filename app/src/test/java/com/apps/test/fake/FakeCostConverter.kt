package com.apps.test.fake

import com.apps.test.domain.model.CostsModel
import com.apps.test.presenter.BaseConverter
import com.apps.test.presenter.CostPresenter

class FakeCostPresenter(
    private val presenter: CostPresenter = CostPresenter("", 0)
): BaseConverter {
    override fun convertCost(costs: CostsModel): CostPresenter {
        return presenter
    }
}
