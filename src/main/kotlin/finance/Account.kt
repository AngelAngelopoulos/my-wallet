package finance

class Account(private var id: Int, private var name: String): Payable {
    private var currency = "MXN"
    private var totalAmount = 0f
        set(value) {
            field = value
        }
        get() = field

    private var expenses = mutableListOf<Expense>()
        get() = field
        set(value) { field = value }

    private var incomes = mutableListOf<Income>()
        get() = field
        set(value) { field = value }

    private var reports = mutableListOf<Report>()

    init {
        println("Please add an Initial amount:")
        totalAmount = fillCharge()
        println("Your account \"$name\" has been successfully created!!\nNow you can deposit some money here...")
    }

    fun addExpense() {
        var newExp = Expense(12f,"")
        this.expenses.add(newExp)
        applyCharge(-1f * newExp.amount)
    }

    fun addIncome() {
        var newInc = Income(14f, "")
        this.incomes.add(newInc)
        applyCharge(newInc.amount)
    }

    private fun applyCharge(charge: Float)
    {
        this.totalAmount =+ charge
    }

    fun getId(): Int{
        return id
    }

    fun getName(): String{
        return name
    }
}