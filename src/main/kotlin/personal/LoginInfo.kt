package personal

class LoginInfo (
    override var infoType: String = "Login Information"): Info(){
        private var userName = "Username"
        private var password = "********"

    override fun editInfo() {
        super.editInfo()

        println("Please enter you new Username:")
        println("""Your Username...
                Must be at least 6 characters long
                Can´t contain the word "Username" nor "username" in it (seriously?).
                Must have only alphanumeric (it may contain "_" or "-" special characters tho).""".trimMargin())

        println()

        this.userName = editDataList(mapOf("Username" to userName)).toString()

        if(password == "********") {
            println("Your username was set successfully!")
            println("\nNow you need to enter a password for your account.\n")
            println("""Your password...
                Can´t contain the word "Password" nor "password" in it (com'on!).
                Must be at least 8 characters long.
                Must have at least one uppercase and one lowercase letter.
                Must have at least one numeric character.
                Must have at least one special character from the next: "# $ % * = : _")""".trimIndent())
            println()
            this.password = editDataList(mapOf("Password" to password)).toString()
            println("Your password was set successfully!\n")
            println()
        }
        else println("Your username was changed successfully!\n")
    }

    fun getUserName(): String{
        return userName
    }

    fun getPassword(): String{
        return password
    }
}


