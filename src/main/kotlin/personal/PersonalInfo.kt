package personal

class PersonalInfo : Info() {
    private var age = 0
    private var gender = ""
    private var contact = ContactInfo()
    private var address = AddressInfo()
    private var business = BusinessInfo()
    private var other = OtherInfo()
}