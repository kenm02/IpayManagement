import java.time.LocalDate

data class BankAcount
    (
     val accountNumber: String,
     var pin : String,
     val accountName: String,
     val bankName: String,
     val cardStype: String,
     var balance: Double,
     val effectivateDate: LocalDate,
     val limitDate: LocalDate
    )
