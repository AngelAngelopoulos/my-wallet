package finance

import utils.Date

class Income() : Charge() {

    override var chargeType = "Income"

    private var amount: Float = 0.0f
    private val date: String = Date().now()
    private var note: String = ""
        set(value) {
            field = value
        }
        get() = field

    private var category: String = ""

//    constructor(amount: Float, note: String, category: String): this(amount, category) {
//        this.amount = fillCharge()
//        //Categorias e ingresos =/= categorias de gatos
//        this.category = fillCategory(Categories.incomeOptions)
//        this.note = fillNote()
//    }

    init {
        println("Enter the amount:")
        this.amount = fillCharge()
        println("Choose a category: ")
        this.category = fillCategory(Categories.incomeOptions)
        println("Write a note")
        this.note = fillNote()

        println("Income created at ${this.date}")
    }

    fun getCategory(): String{
        return this.category
    }

    fun getAmount(): Float{
        return this.amount
    }

}