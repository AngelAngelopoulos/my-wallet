package financial

import utils.Date

class Expense() : Charge() {

    override var chargeType = "Expense"
    override var currency = "MXN"

    private var amount: Float = 0.0f
    private val date: String = Date().now()
    private var category: String = ""
    private var note: String = ""


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

        println()
        println("Expense created at $date")
        print("$amount $currency in category $category ")
    }

    fun getCategory(): String {
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