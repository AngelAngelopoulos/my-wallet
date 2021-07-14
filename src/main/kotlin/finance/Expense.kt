package finance

import utils.Date

class Expense(  override var amount: Float, category: String) : Charge(amount) {

    constructor(amount: Float, note: String, category: String): this(amount, category) {
        this.amount = fillCharge()
        this.category = fillCategoryExpenses()
        this.note = fillNote()
    }

    private val date: String

    init {
        this.date = Date().now()
        this.amount = amount
        println("Expense created at ${this.date}")
    }

    private var note: String = ""
        set(value) {
            field = value
        }
        get() = field

    private var category: String = ""
        set(value) {
            field = value
        }
        get() = field

}