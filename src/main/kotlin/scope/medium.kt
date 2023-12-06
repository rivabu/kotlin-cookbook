//package collections.scope
//
//// https://medium.com/@fatihcoskun/kotlin-scoping-functions-apply-vs-with-let-also-run-816e4efb75f5
//
//Use run() function if you need to compute some value or want to limit the scope of multiple local variables. Use run()
//also if you want to convert explicit parameters to implicit receiver.
//
//
//// RUN
//val inserted: Boolean = run {
//    val person: Person = getPerson() // bij run gaat het om de scope van de local variabelen
//    val personDao: PersonDao = getPersonDao()
//    personDao.insert(person)
//}
//fun printAge(person: Person) = person.run {
//    print(age)
//}
//
//// COMBINE APPLY, ALSO, RUN
//private fun insert(user: User) = SqlBuilder().apply {
//    append("INSERT INTO user (email, name, age) VALUES ")
//    append("(?", user.email)
//    append(",?", user.name)
//    append(",?)", user.age)
//}.also {
//    print("Executing SQL update: $it.")
//}.run {
//    jdbc.update(this) > 0
//}
//
////WITH
//val person: Person = getPerson()
//with(person) {
//    print(name)
//    print(age)
//}
