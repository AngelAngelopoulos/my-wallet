package finance

class Account {
    private var id = ""
    private var name = ""
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

    constructor(id: String, name: String){
        this.id = id
        this.name = name
        println("Your account $name has been successfully created!!\nNow you can deposit some money here...")
    }

    fun addExpense(expense: Expense) {
        this.expenses.add(expense)
        applyCharge(-1f * expense.amount);
    }

    fun addIncome(income: Income) {
        this.incomes.add(income)
        applyCharge(income.amount);

    }

    private fun applyCharge(charge: Float)
    {
        this.totalAmount =+ charge
    }

    fun chooseOption(options: Map<String, String>): String{

        var res= readLine()?.lowercase()

        while (!options.containsKey(res)) {
            println("Please enter a valid value.")
            options.forEach { (k, v) -> println("$k) $v") }
            res = readLine()?.lowercase()
        }
        // Elvis ?:p
        return res?: "0"
    }



}