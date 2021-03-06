package personal
import utils.SearchAsync

class AllInfo(): Info() {
    override var infoType = "All Information"
    private var personalInfo = PersonalInfo()
    private var contact = ContactInfo()
    private var address = AddressInfo()
    private var business = BusinessInfo()
    private var loginInfo = LoginInfo()

    private val options = mapOf("a" to "All", "b" to "Basic info", "c" to "Contact info", "d" to "Address info", "e" to "Business info", "0" to "Cancel")

    fun fillLoginInfo(){
        loginInfo.editInfo()
    }

    fun fillBasicInfo(){
        personalInfo.editInfo()
    }

    suspend fun infoToShow() {
        // El map de las opciones se repetía en ambas funciones así que se colocó como propiedad de la clase.
        val getResponse = {
            println("""
            What info do you want to see? (0 cancel)""")
            options.forEach { (k, v) -> println("$k) $v") }
            chooseOption( options)
        }

        when(getResponse()){
            "a" -> {
                SearchAsync.searchInfo()
                println("\nAll info will be shown...\n")
                loginInfo.showInfo()
                personalInfo.showInfo()
                contact.showInfo()
                address.showInfo()
                business.showInfo()
            }
            "b" -> {
                SearchAsync.searchInfo()
                personalInfo.showInfo()
            }
            "c" -> {
                SearchAsync.searchInfo()
                contact.showInfo()
            }
            "d" -> {
                SearchAsync.searchInfo()
                address.showInfo()
            }
            "e" -> {
                SearchAsync.searchInfo()
                business.showInfo()
            }
            else -> println("No info to show")
        }
    }

    fun editMyInfo(){
        // El map de las opciones se repetía en ambas funciones así que se colocó como propiedad de la clase.
        val getResponse = {
            println("""
            What info do you want to edit? (0 cancel)""")
            options.forEach { (k, v) -> println("$k) $v") }
            chooseOption( options)
        }

        when(getResponse()){
            "a" -> {println("\nAll info will be edited...\n")
                personalInfo.editInfo()
                contact.editInfo()
                address.editInfo()
                business.editInfo()
            }
            "b" -> personalInfo.editInfo()
            "c" -> contact.editInfo()
            "d" -> address.editInfo()
            "e" -> business.editInfo()
            else -> println("No info to edit")
        }
    }

    fun getLoginInfo(): List<String>{
        return listOf(loginInfo.getUserName(), loginInfo.getPassword())
    }
}