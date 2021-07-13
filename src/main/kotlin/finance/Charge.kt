package finance

abstract class Charge(): Payable {

    abstract var chargeType: String
    abstract var currency: String

    open fun showInfo(){
        println("""---------Next $chargeType will be shown:---------""")
        println()
    }


}