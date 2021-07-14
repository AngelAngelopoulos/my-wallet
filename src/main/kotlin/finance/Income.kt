package finance

import utils.Date

class Income() : Charge() {

    override var chargeType = "Income"
    override var currency = "MXN"

    private var amount: Float = 0.0f
    private val date: String = Date().now()
    private var note: String = ""
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

        println()
        println("Income created at $date")
        println("$amount $currency in category $category.")
    }

    fun getCategory(): String{
        return this.category
    }

    fun getAmount(): Float{
        return this.amount
    }

    fun getDate(): String {
        return this.date
    }

    override fun showInfo(){
        super.showInfo()
        println("""
            Created at: $date
            Amount: $amount
            Category: $category
            Note: $note
        """.trimIndent())
        println()
    }

}