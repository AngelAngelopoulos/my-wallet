package finance

import utils.Date

class Expense(amount: Float) : Liability(amount) {

    constructor(amount: Float, note: String) : this(amount) {
        this.amount = amount
        this.note = note
    }

    private val date : String

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



    override fun printAmount() {
        println("----------------------------------------------------------------------------")
        println("Expense")
        println("Date: ${this.date}")
        println("Amount: ${this.amount}")
        //println("Has been payed: ")
        //if (this.paid) print("Yes") else print("No")
        if (this.note.isNotEmpty())
        {
            println("Note: ${this.note}")
        }
        println("----------------------------------------------------------------------------")
    }

}