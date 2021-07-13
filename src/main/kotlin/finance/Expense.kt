package finance

import utils.Date

class Expense() : Charge() {

    override var chargeType = "Expense"

    private var amount: Float = 0.0f
    private val date: String = Date().now()
    private var category: String = ""

    private var note: String = ""
        set(value) {
            field = value
        }
        get() = field

//    constructor(amount: Float, note: String, category: String): this(amount, category) {
//        this.amount = fillCharge()
//        this.category = fillCategory(Categories.expendOptions)
//        this.note = fillNote()
//    }

    init {
        println("Enter the amount:")
        this.amount = fillCharge()
        println("Choose a category: ")
        this.category = fillCategory(Categories.expendOptions)
        println("Write a note")
        this.note = fillNote()

        println("Expense created at ${this.date}")
    }

    fun getCategory(): String {
        return this.category
    }

    fun getAmount(): Float{
        return this.amount
    }


}