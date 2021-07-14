package personal
import finance.*

class User() : Fillable{
    private var accounts = mutableListOf<Account>()
    private var allInfo = AllInfo()

    var loggedIn = false

    init {
        println("""
            Hey! Welcome to MyWallet :)
            
            Here you can have a record and control of your finances and in this way realize where your money comes from and more importantly...
            where it is going!
            
            Is it okay if we start?
            You just need to provide us with some information and we will do the rest :D 
            Let's get started!""".trimIndent())
        println()
    }

    suspend fun showUserInfo(){
        allInfo.infoToShow()
    }

    fun editAllInfo(){
        allInfo.editMyInfo()
    }

    fun signUp(){
        allInfo.fillLoginInfo()
    }

    fun logIn(): Boolean {

        var user: String
        var pass: String

        println("Now, let´s log in!\nPlease enter your username & password.\n")

        val getUsr = allInfo.getLoginInfo()[0].replace("[", "").replace("]", "")
        val getPss = allInfo.getLoginInfo()[1].replace("[", "").replace("]", "")

        while (!loggedIn) {

            println("User: ")
            user = fillData("User", "")
            println("Password")
            pass = fillData("Password")

            loggedIn = (user == getUsr && pass == getPss)

            if (!loggedIn) println("Your username or password are incorrect. Please enter your correct info.\n")
            else {
                println("Logged in!")
                loggedIn = true
            }
        }
        return true
    }

    fun logOut(){

        println("""
            Are you sure? (Y/N)""")
        val res = readLine()

        if(!res.isNullOrEmpty() && res.lowercase() == "y")  loggedIn = false

    }

    fun addAccount(){

        println("Let's add a new account!\n")
        println("""Please, write a name for your account.
            Some examples are: 
            "Main account", "Savings", "My bank1", "Cash" etc... """)

        val newId = accounts.size
        val name = fillData("Account Name")

        val newAccount = Account(newId, name)

        accounts.add(newAccount)
    }

    fun addExpense(){
        try{
            accounts[ selectAccount()-1 ].addExpense()
        } catch(e: Exception){
            println("Operation Cancelled.")
        }
    }

    fun addIncome(){
        try{
            accounts[ selectAccount() -1 ].addIncome()
        } catch (e: Exception){
            println("Operation Cancelled")
        }
    }

    // Regresa el id de la cuenta que elija el usuario + 1
    private fun selectAccount(): Int{

        val options: MutableMap<String, String> = accounts.associate { (it.getId()+1).toString() to it.getName() }.toMutableMap()

        options["0"] = "Cancel"

        val getResponse = {
            println("""
            Please, select an account ( cancel)""")
            options.forEach { (k, v) -> println("$k) $v") }
            chooseOption( options)
        }
        return getResponse().toInt()
    }

    suspend fun showAccMovements(){
        try{
            val acc = selectAccount()-1
            accounts[ acc ].showInfo()
        } catch(e: Exception){
            println("Operation Cancelled.")
        }
    }

    suspend fun printReport() {

        try{
            val acc = selectAccount()-1
            accounts[ acc ].generateNewReport()
        } catch(e: Exception){
            println("Operation Cancelled.")
            println(e.message)
        }
    }

}