package highorder

/*
Retry account operations
Create a retry function that allows retrying to deposit money to an account until the operation succeeds, for a given number of times. The retry function should work with any function that returns an account. If the number of retries is not specified, it should retry until it succeeds.

Use main function as a guideline on how retry can be used.

Have a look at Util.kt for the rest of the implementation.

 Hint 1
Think about higher order functions.
 Hint 2
Would a recursive implementation be easier to read?
*/

/* observaties
1.  als je de '=' notatie gebruik, wordt automatisch de laatste regel gereturned
2. kijk naar de notatie: f: () -> Account

 */
fun retry(times: Int = 0, account: Account, f: (Account) -> Account): Account {
    if (times == 1)
        return f(account)
    else
        try {
            return f(account)
        } catch (e: Exception) {
            println("here")
            return retry(times - 1, account, f)
        }
}

fun operation(account: Account): Account {
    fail(95)
    account.deposit("3.5".toBigDecimal())
    return account
}

fun main() {
    val account =
        Account("NL77BBBB1234567812345678", "Current Account", "EUR", "100".toBigDecimal())

    val updatedAccount = retry(0, account, ::operation)

    println(updatedAccount.balance)
}