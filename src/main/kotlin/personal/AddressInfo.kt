package personal

class AddressInfo : Info() {
    override var infoType= "Address Information"
    private var street = "--"
    private var number = "--"
    private var neighborhood = "--"
    private var city = "--"
    private var state = "--"
    private var country = "Mexico"

    override suspend fun showInfo(){
        super.showInfo()
        println("""
            $street $number, $neighborhood, $city, $state, $country""".trimIndent())
        println()
    }

    override fun editInfo() {
        super.editInfo()
        println("Please enter the required data about your $infoType...\n")

        var i = 0
        val required = mapOf("Street" to street, "Number" to number, "Neighborhood" to neighborhood, "City" to city, "State" to state)
        val res = editDataList(required)

        street = res[i++]
        number = res[i++]
        neighborhood = res[i++]
        city = res[i++]
        state = res[i]

        println()
    }

}