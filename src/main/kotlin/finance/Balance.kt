package finance

class Balance {
    private var debts = mutableListOf<Debt>()
        get() = field
        set(value) { field = value }

    private var expenses = mutableListOf<Expense>()
        get() = field
        set(value) { field = value }

    private var incomes = mutableListOf<Income>()
        get() = field
        set(value) { field = value }

    private var loans = mutableListOf<Loan>()
        get() = field
        set(value) { field = value }

    fun addDebt(debt: Debt) {
        this.debts.add(debt)
    }

    fun addExpense(expense: Expense) {
        this.expenses.add(expense)
    }

    fun addIncome(income: Income) {
        this.incomes.add(income)
    }

    fun addLoan(loan: Loan) {
        this.loans.add(loan)
    }

    fun getTotalDebt() : Float
    {
        var res = 0f
        for (debt in this.debts)
        {
            res += debt.amount
        }
        return res
    }

    fun getTotalExpense() : Float
    {
        var res = 0f
        for (expense in this.expenses)
        {
            res += expense.amount
        }
        return res
    }

    fun getTotalIncome() : Float
    {
        var res = 0f
        for (income in this.incomes)
        {
            //res += income.amount
        }
        return res
    }

    fun getTotalLoan() : Float
    {
        var res = 0f
        for (loan in this.loans)
        {
            //res += loan.amount
        }
        return res
    }

    fun printBalance()
    {
        println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+")
        println("Liabilities")
        println("..............................................................")
        println("Debts")
        println("..............................................................")
        for (debt in debts)
        {
            debt.printAmount()
        }
        println("Total debt: ${getTotalDebt()}")
        println("..............................................................")
        println("Expenses")
        println("..............................................................")
        for (expense in expenses)
        {
            expense.printAmount()
        }
        println("Total expense: ${getTotalExpense()}")
        println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+")
        println("Assets")
        println("..............................................................")
        println("Income")
        println("..............................................................")
        for (income in incomes)
        {
            //income.printAmount()
        }
        println("Total income: ${getTotalIncome()}")
        println("..............................................................")
        println("Loan")
        println("..............................................................")
        for (loan in loans)
        {
            //income.printAmount()
        }
        println("Total loan: ${getTotalLoan()}")



    }

}