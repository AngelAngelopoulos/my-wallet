package finance
import utils.*

open class Liability(amount: Float)  {
    open var amount: Float = 0f
        set(value) {
            field = value
        }
        get() = field

    open var paid = false


    open fun isPaid() : Boolean
    {
        return this.paid
    }

    open fun payTotal()
    {
        this.amount = 0f
        this.paid = true
    }

    open fun payPartial(amount: Float)
    {
        this.amount += amount
    }

    open fun printAmount() {
        println("The total amount as Liability is: $amount")
    }
}