package personal

class BusinessInfo : Info() {
    override var infoType= "Business Information"
    private var company = ""
    private var position = ""
    private var salary = ""
    private var businessContactInfo = ContactInfo()

    override fun showInfo(){
        super.showInfo()
        println("""
            Company: $company
            Position: $position
            Salary: $salary""".trimIndent())
        println()
    }

    override fun editInfo() {
        super.editInfo()
        println("Please enter the required data about your business...\nCompany: ")
        company = fillData("Company")
        println("Position:")
        position = fillData("Position")
        println("Salary:")
        salary = fillData("Salary")
// FALTA
    }
}