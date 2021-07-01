package personal

class AddressInfo : Info() {
    override var infoType= "Address Information"
    private var street = ""
    private var number = ""
    private var neighborhood = ""
    private var city = ""
    private var state = ""
    private var country = "Mexico"

    override fun showInfo(){
        super.showInfo()
        println("""
            $street $number, $neighborhood, $city, $state, $country""".trimIndent())
        println()
    }

    override fun editInfo() {
        super.editInfo()
        println("Please enter the required data about your address...\nStreet: ")
        street = fillData("Street")
        println("Number:")
        number = fillData("Number")
        println("Neighborhood:")
        neighborhood = fillData("Neighborhood")
        println("City:")
        city = fillData("City")
        println("State:")
        state = fillData("State")
    }

}