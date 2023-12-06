package collections

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

internal class AssociateWithKtTest {
    private val keys = 'a'..'e'
    private val answer = mapOf(
        'a' to "Aaaaa",
        'b' to "Bbbbb",
        'c' to "Ccccc",
        'd' to "Ddddd",
        'e' to "Eeeee")

    @Test
    fun repeatAndCapitalizeUsingAssociate() {
        assertThat(collections.collections.seldomused.repeatAndCapitalizeUsingAssociate(keys), `is`(answer))
    }

    @Test
    fun repeatAndCapitalizeUsingAssociateWith() {
        assertThat(collections.collections.seldomused.repeatAndCapitalizeUsingAssociateWith(keys), `is`(answer))
    }
}