package personal

class PersonalInfo() : Info() {
    override var infoType = "Personal Information"

    private var name = "--"
    private var age = "--"
    private var gender = "--"

    override suspend fun showInfo() {
        super.showInfo()
        println("""
            Name: $name
            Age: $age
            Gender: $gender""".trimIndent())
        println()
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