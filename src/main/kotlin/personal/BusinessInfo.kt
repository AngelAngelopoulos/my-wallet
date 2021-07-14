package personal

class BusinessInfo : Info() {
    override var infoType= "Business Information"
    private var company = "--"
    private var position = "--"
    private var salary = "--"
    private var businessContactInfo = ContactInfo()

    init {
        businessContactInfo.infoType = "Business Contact Information"
    }

    override suspend fun showInfo(){
        super.showInfo()
        println("""
            Company: $company
            Position: $position
            Salary: $salary""".trimIndent())

        businessContactInfo.showInfo()

        println()
    }

    override fun editInfo() {
        super.editInfo()
        println("Please enter the required data about your $infoType...")

        var i = 0
        val required = mapOf("Company" to company, "Position" to position, "Salary" to salary)
        val res = editDataList(required)

        company = res[i++]
        position = res[i++]
        salary = res[i]

        businessContactInfo.editInfo()

        println()
    }
}