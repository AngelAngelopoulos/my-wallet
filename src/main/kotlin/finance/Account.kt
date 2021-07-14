package finance

class Account(private var id: String, private var name: String) {
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
        println("Your account $name has been successfully created!!\nNow you can deposit some money here...")
    }

    fun addExpense(expense: Expense) {
        this.expenses.add(expense)
        applyCharge(-1f * expense.amount)
    }

    fun addIncome(income: Income) {
        this.incomes.add(income)
        applyCharge(income.amount)
    }

    private fun applyCharge(charge: Float)
    {
        this.totalAmount =+ charge
    }
}