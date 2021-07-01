package personal

abstract class Info : Fillable{
    abstract var infoType: String

    open fun showInfo(){
        println("Next info will be shown: $infoType.")
    }

    open fun editInfo(){
        println("Next info will be edited: $infoType")
    }
}