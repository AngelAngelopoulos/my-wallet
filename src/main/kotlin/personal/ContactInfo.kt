package personal

class ContactInfo: Info() {
    override var infoType= "Contact Information"
    private var phoneNumber = "--"
    private var email = "--"
    private var facebook = "--"
    private var instagram = "--"
    private var linkedin = "--"

    override fun showInfo(){
        super.showInfo()
        println("""
            Phone number: $phoneNumber
            Email: $email
            Facebook: $facebook
            Instagram: $instagram
            Linkedin: $linkedin""".trimIndent())
        println()
    }

    override fun editInfo() {
        super.editInfo()
        println("Please enter the required data about your $infoType...")

        var i = 0
        val required = mapOf("Phone Number" to phoneNumber, "Email" to email, "Facebook" to facebook, "Instragram" to instagram, "Linkedin" to linkedin)
        val res = editDataList(required)

        phoneNumber = res[i++]
        email = res[i++]
        facebook = res[i++]
        instagram = res[i++]
        linkedin = res[i]

        println()
    }
}