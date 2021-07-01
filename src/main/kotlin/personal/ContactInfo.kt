package personal

class ContactInfo: Info() {
    override var infoType= "Contact Information"
    private var phoneNumber = ""
    private var email = ""
    private var facebook = ""
    private var instagram = ""
    private var linkedin = ""

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
        println("Please enter the required data about your contact info...\nPhone number: ")
        phoneNumber = fillData("Phone Number")
        println("Email:")
        email = fillData("Email")
        println("Facebook:")
        facebook = fillData("Facebook")
        println("Instagram:")
        instagram = fillData("Instagram")
        println("Linkedin:")
        linkedin = fillData("Linkedin")
    }
}