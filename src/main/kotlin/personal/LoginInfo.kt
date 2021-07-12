package personal

data class LoginInfo (
    override var infoType: String = "Login Information"): Info(){
        private var userName = "--"
        private var password = "--"

    override fun editInfo() {
        super.editInfo()

        println("Please enter you new Username:")
        this.userName = fillData("Username", userName)

        if(password == "--") {
            println("Your username was set successfully!")
            println("\nNow you need to enter a password for your account.\n")
            println("""Your password:
                Needs to be at least 8 characters long.
                Must have at least one numeric character.
                Must have at least one special character from the next: "# $ % * = : _")""".trimIndent())
            println()
            this.password = fillData("Password")
            println("Your password was set successfully!")
        }
        else println("Your username was changed successfully!")
    }
}


