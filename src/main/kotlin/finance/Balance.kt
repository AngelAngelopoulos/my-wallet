package finance

class Balance {
    private var debt = mutableListOf<Debt>()
    private var expenses = mutableListOf<Expense>()
    private var incomes = mutableListOf<Income>()
    private var loans = mutableListOf<Loan>()
}