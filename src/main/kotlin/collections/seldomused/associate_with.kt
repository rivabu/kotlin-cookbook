package collections.collections.seldomused

import java.util.*

// From tweet on @Kotlin feed
// Also, https://kotlinlang.org/docs/reference/whatsnew13.html#associatewith

@Suppress("ReplaceAssociateFunction")
fun <T> repeatAndCapitalizeUsingAssociate(keys: Iterable<T>) =
    keys.associate {
        it to it.toString().repeat(5)
            .capitalize()
    }

fun <T> repeatAndCapitalizeUsingAssociateWith(keys: Iterable<T>) =
    keys.associateWith { it.toString().repeat(5).capitalize() }

fun <T> repeatAndCapitalizeUsingMap(keys: Iterable<T>) =
    keys.map { it.toString().repeat(5).capitalize() }

fun main(args: Array<String>) {
    val keys = 'a'..'f'
    val map = repeatAndCapitalizeUsingAssociate(keys)
    println(map) //{a=Aaaaa, b=Bbbbb, c=Ccccc, d=Ddddd, e=Eeeee, f=Fffff}

    val map1 = repeatAndCapitalizeUsingAssociateWith(keys)
    println(map1) // {a=Aaaaa, b=Bbbbb, c=Ccccc, d=Ddddd, e=Eeeee, f=Fffff}

    val map2 = repeatAndCapitalizeUsingMap(keys)
    println(map2) // {a=Aaaaa, b=Bbbbb, c=Ccccc, d=Ddddd, e=Eeeee, f=Fffff}

}

// extension function, interessant met de if .. else ... constructie
fun String.capitalize(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}
