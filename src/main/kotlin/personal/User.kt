package personal
import finance.*

class User() {
    private var accounts = mutableListOf<Account>()
    private var allInfo = AllInfo()

    init {
        login()
    }

    fun showInfo(){
        allInfo.infoToShow()
    }

    fun editAllInfo(){
        allInfo.editMyInfo()
    }

    fun login(){
        println("""
            Hey! Welcome to MyWallet :)
            Here you can have a record and control of your finances and this way realize where your money comes from 
            and more importantly, where it is going...
            
            Is it okay if we start?
            
            You just need to provide us with some information and we will do the rest :D 
            Let's get started!""")

        allInfo.fillBasicInfo()

    }


}