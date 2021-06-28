package finance

import utils.Date

class Debt(amount: Float) : Liability(amount) {

    constructor(amount: Float, note: String) : this(amount) {
        this.amount = amount
        this.note = note
    }

    private val date: String

    init {
        this.date = Date().now()
        this.amount = amount
        println("Debt created at ${this.date}")
    }

    private var note: String = ""
        set(value) {
            field = value
        }
        get() = field


    override var paid: Boolean = false
        get() = field
        set(value) {
            field = value
        }


    override fun printAmount() {
        println("----------------------------------------------------------------------------")
        println("Debt")
        println("Date: ${this.date}")
        println("Amount: ${this.amount}")
        print("Has been payed: ")
        if (this.paid) print("Yes\n") else print("No\n")
        if (this.note.isNotEmpty()) {
            println("Note: ${this.note}")
        }
        println("----------------------------------------------------------------------------")
    }
}