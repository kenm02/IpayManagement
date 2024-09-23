import java.time.LocalDate

fun main() {
    val acount: List<BankAcount> = listOf(
        BankAcount(
            accountNumber = "123456789",
            pin = "1234",
            accountName = "John Doe",
            bankName = "ABC Bank",
            cardStype = "Debit",
            balance = 5000.0,
            effectivateDate = LocalDate.of(2023, 1, 1),
            limitDate = LocalDate.of(2028, 1, 1)
        ),
        BankAcount(
            accountNumber = "1234567212",
            pin = "1234",
            accountName = "John Doe",
            bankName = "ABC Bank",
            cardStype = "Debit",
            balance = 5000.0,
            effectivateDate = LocalDate.of(2023, 1, 1),
            limitDate = LocalDate.of(2028, 1, 1)
        ),
        BankAcount(
            accountNumber = "12345672346",
            pin = "1234",
            accountName = "John Doe",
            bankName = "ABC Bank",
            cardStype = "Debit",
            balance = 5000000.0,
            effectivateDate = LocalDate.of(2023, 1, 1),
            limitDate = LocalDate.of(2028, 1, 1)
        ),
        BankAcount(
            accountNumber = "123456724345",
            pin = "1234",
            accountName = "John Doe",
            bankName = "ABC Bank",
            cardStype = "Debit",
            balance = 5000.0,
            effectivateDate = LocalDate.of(2023, 1, 1),
            limitDate = LocalDate.of(2028, 1, 1)
        )
    )


    print(" Enter your account number: ")
    val enteredNumberAcount = readLine()!!
    print("Enter Your PIN account: ")
    val pin = readLine()!!
    for (i in 0 until acount.size) {

        if(enteredNumberAcount == acount[i].accountNumber) { // Check account infor and login
            if (login(acount[i], pin)){
               while (true){
                   println("---------------------------")
                   println("choose your option")
                   println("1. Check your balance ")
                   println("2. Change your PIN")
                   println("3. Withdraw money")
                   println("4.Transfer")
                   println("5. top Up Phone Number")
                   println("6. Add money.")
                   println("7. Finish")
                   print("Your option: ")
                   val option= readLine()!!.toInt()
                   when(option)
                   {
                       FuntionType.BALANCE.value -> println("Your balance ${acount[i].balance}\n")

                       FuntionType.CHANGE_PIN.value-> ChangePin(acount[i])

                       FuntionType.WITHDRAW_MONEY.value ->{
                           if (acount[i].balance < 100000.0) {
                               println("Your balance is not enough to withdraw")
                               break
                           }
                           print("Money do you want to withdraw: ")
                           val amount = readln().toDouble()
                           if(withdrawMoney(acount[i],amount)) println("Transaction successfully, Your new balance: ${acount[i].balance} VND")
                           else println("Please enter amount less than your balance and more than 10.000 VND")
                       }

                       FuntionType.TRANSFER.value -> {
                           println("Enter bank received infomation:")
                           print("Enter bank Number: ")
                           val bankNumber = readln()
                           print("Enter Bank Name: ")
                           val bankName = readln()
                           for (j in 0 until acount.size){
                               if(bankNumber == acount[j].accountNumber && bankName == acount[j].bankName){
                                   println("Acount name: ${acount[j].accountName}")
                                   print("Check information and enter amout: ")
                                   val amount = readln().toDouble()
                                   if (transfer(acount[i], amount)) {
                                       println("Transaction successfully, Your balance: ${acount[i].balance} VND")
                                       acount[j].balance += amount
                                       break
                                   }
                                   println("your amout is invalid")

                               }
                               println("You entered invalid account!")
                           }
                       }

                       FuntionType.TOP_UP.value -> {
                           print("Enter phone number: ")
                           val phone = readln()
                           print("enter amount: ")
                           val amount = readln().toDouble()
                           if(topUpPhoneNumber(acount[i], amount)) println("Transaction successfully, Your balance: ${acount[i].balance} VND")
                           else println("Please enter amount less than your balance and more than 10.000 VND")
                       }

                       FuntionType.ADD_MONEY.value ->{
                           print("Enter amount that you want to add: ")
                           val amount = readln().toDouble()
                           addMoney(acount[i], amount)
                           println("Transaction successfully, Your balance: ${acount[i].balance} VND")
                       }
                       FuntionType.EXIT.value -> return
                   }
               }

            }

        }
    }
        println("Your account number does not exist")
}

