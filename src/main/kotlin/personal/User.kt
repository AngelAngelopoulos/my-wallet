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

    fun showInfo(){
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
        loggedIn = false
    }
}