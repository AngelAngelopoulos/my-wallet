package personal
import finance.*

class User() {
    private var accounts = mutableListOf<Account>()
    private var personalInfo = PersonalInfo()

    init {
        personalInfo.fillBasicInfo()
    }

    fun showInfo(){
        personalInfo.infoToShow()
    }

    fun editPersonalInfo(){
        personalInfo.editMyInfo()
    }

}