package personal

class PersonalInfo() : Info() {
    override var infoType = "Personal Information"

    private var name = "--"
    private var age = "--"
    private var gender = "--"
    private var contact = ContactInfo()
    private var address = AddressInfo()
    private var business = BusinessInfo()
    private var other = OtherInfo()

    fun fillBasicInfo(){
        println("Please enter the following information:")

        var i = 0
        val required = mapOf("Name" to name, "Age" to age, "Gender" to gender)
        val res = editDataList(required)

        this.name = res[i++]
        this.age = res[i++]
        this.gender = res[i]
    }

    override fun showInfo() {
        super.showInfo()
        println("""
            Name: $name
            Age: $age
            Gender: $gender""".trimIndent())
        println()
    }

    fun infoToShow() {

        val options = mapOf("a" to "All", "b" to "Basic info", "c" to "Contact info", "d" to "Address info", "e" to "Business info", "0" to "Cancel")

        val getResponse = {
            println("""
            What info do you want to see? (0 cancel)""")
            options.forEach { (k, v) -> println("$k) $v") }
            chooseOption( options)
        }

        when(getResponse()){
            "a" -> {println("\nAll info will be shown...\n")
                this.showInfo()
                contact.showInfo()
                address.showInfo()
                business.showInfo()
            }
            "b" -> this.showInfo()
            "c" -> contact.showInfo()
            "d" -> address.showInfo()
            "e" -> business.showInfo()
        else -> println("No info to show")
        }
    }

    fun editMyInfo(){
        val options = mapOf("a" to "All", "b" to "Basic info", "c" to "Contact info", "d" to "Address info", "e" to "Business info", "0" to "Cancel")

        val getResponse = {
            println("""
            What info do you want to edit? (0 cancel)""")
            options.forEach { (k, v) -> println("$k) $v") }
            chooseOption( options)
        }

        when(getResponse()){
            "a" -> {println("\nAll info will be edited...\n")
                this.editInfo()
                contact.editInfo()
                address.editInfo()
                business.editInfo()
            }
            "b" -> this.editInfo()
            "c" -> contact.editInfo()
            "d" -> address.editInfo()
            "e" -> business.editInfo()
            else -> println("No info to edit")
        }

    }

    override fun editInfo(){
        super.editInfo()
        println("Please enter the required data about your Basic $infoType...")

        var i=0
        val required = mapOf("Name" to name, "Age" to age, "Gender" to gender)
        val res = editDataList(required)

        this.name = res[i++]
        this.age = res[i++]
        this.gender = res[i]

        println()
    }

}