package finance

class Account {
    private var id = ""
    private var name = ""
    private var currency = "MXN"
    private var totalAmount = 0
    var balance = Balance()
    private var reports = mutableListOf<Report>()

    constructor(id: String, name: String){
        this.id = id
        this.name = name
        println("Your account $name has been successfully created!!\nNow you can deposit some money here...")
    }

    constructor(id: String, name: String, currency: String):this(id, name){
        this.currency = currency
    }

    constructor(id: String, name: String, currency: String, balance: Balance): this(id,name, currency){
        this.balance = balance
    }

    constructor(id: String, name: String, currency: String, balance: Balance, reports: Report): this(id,name,currency, balance){
        this.reports.add(reports)
    }
}