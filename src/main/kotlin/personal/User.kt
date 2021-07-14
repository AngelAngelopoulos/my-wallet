package personal
import finance.*

class User() {
    private var accounts = mutableListOf<Account>()
    private var allInfo = AllInfo()

    init {
        allInfo.fillBasicInfo()
    }

    fun showInfo(){
        allInfo.infoToShow()
    }

    fun editAllInfo(){
        allInfo.editMyInfo()
    }

}