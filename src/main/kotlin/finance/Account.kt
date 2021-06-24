package finance

class Account {
    private var id = ""
    private var name = ""
    private var currency = ""
    private var balance = Balance()
    private var reports = mutableListOf<Report>()
}