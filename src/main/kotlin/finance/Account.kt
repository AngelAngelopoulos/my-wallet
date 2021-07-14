package finance

import utils.SearchAsync

class Account(private var id: Int, private var name: String): Payable {
    private var currency = "MXN"
    private var initialAmount = 0f
    private var totalAmount = 0f
    private var expenses = mutableListOf<Expense>()
    private var incomes = mutableListOf<Income>()
    private var reports = mutableListOf<Report>()

    init {
        println("Please add an Initial amount:")
        initialAmount = fillCharge()
        totalAmount = initialAmount
        println("Your account \"$name\" has been successfully created!!\nNow you can deposit some money here...")
    }

    fun addExpense() {
        val newExp = Expense()
        //println("to account $name")
        //println("${newExp.getAmount()}${currency} to ${this.name} in category ${newExp.getCategory()}.")
        this.expenses.add(newExp)
        applyCharge(-1f * newExp.getAmount())
    }

    fun addIncome() {
        val newInc = Income()
        //println("to account $name")
        //println("${newInc.getAmount()}${currency} to ${this.name} in category ${newInc.getCategory()}.")
        this.incomes.add(newInc)
        applyCharge(newInc.getAmount())
    }

    private fun applyCharge(charge: Float)
    {
        this.totalAmount += charge
        println("New balance in account $name is: $totalAmount $currency.")
    }

    fun getId(): Int{
        return id
    }

    fun getName(): String{
        return name
    }

    suspend fun showInfo(){
        SearchAsync.searchInfo()
        println("""
            ----------------For account $name:----------------
            
            Initial balance: $initialAmount $currency
            Actual balance: $totalAmount $currency
            """.trimIndent())
        println()

        if(incomes.isEmpty()) println("No incomes yet. There is nothing to show.")
        else incomes.forEach { it.showInfo() }

        if(expenses.isEmpty()) println("No expenses yet. There is nothing to show.")
        else expenses.forEach { it.showInfo() }
    }

    fun generateReport()
    {

    }
}