
    fun login(account: BankAcount, enteredPin: String): Boolean {
        return  account.pin== enteredPin // && enteredAcountNumber== account.accountNumber enteredAcountNumber: String,
    }

    fun balanceCheck(account: BankAcount):Double{
        return account.balance
    }

    fun ChangePin(account:BankAcount){
        print("Enter your old Pin:")
        var oldPin= readLine()!!
        print("Enter your new PIN: ")
        var newPin= readLine()!!
        if(oldPin == account.pin){
            account.pin = newPin
            println("Change PIN successfully")
        }else println("You entered the PIN was wrong. please try again")

    }

    fun withdrawMoney(account:BankAcount,amount:Double):Boolean =
         if(amount <= account.balance && amount >= 10000.0){
            account.balance -= amount
            true
        }else  false


   fun transfer(account:BankAcount, amount:Double):Boolean =if(amount <= account.balance && amount >= 10000.0){
           account.balance -= amount
            true
       }else false

    fun topUpPhoneNumber(account:BankAcount,amount: Double):Boolean =
       if(amount <= account.balance && amount >= 10000.0){
           account.balance -= amount
            true
       }else  false

    fun addMoney(account:BankAcount,amount:Double):Double{
        account.balance += amount
        return account.balance
    }

