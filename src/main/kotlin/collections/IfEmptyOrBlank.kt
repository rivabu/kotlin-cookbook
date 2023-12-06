package collections

fun onSaleProductsIfEmptyCollection(products: List<Product>) =
    products.filter { it.onSale }
        .map { it.name }
        .ifEmpty { listOf("none") }
        .joinToString(separator = ", ")

fun onSaleProductsIfEmptyString(products: List<Product>) =
    products.filter { it.onSale }
        .joinToString(separator = ", ")
        { it.name }
        .ifEmpty { "none" }

fun onSaleProductsIfEmptyString2(products: List<Product>) =
    products.filter { it.onSale }
        .joinToString(separator = "| ")
        { it.name }

fun main() {
    val widget = Product("Oscillation Overthruster", 10.0)
    val tpsReportCoverSheet = Product(
        "TPS Report Cover Sheet",
        0.25, true
    )
    val fluxCapacitor = Product("Flux Capacitor", 29.95)
    val products = listOf(widget, tpsReportCoverSheet, fluxCapacitor)
    println(onSaleProductsIfEmptyCollection(products)) // TPS Report Cover Sheet

    tpsReportCoverSheet.onSale = false
    println(onSaleProductsIfEmptyCollection(products))
    tpsReportCoverSheet.onSale = true
    widget.onSale = true
    println("bla ${onSaleProductsIfEmptyString2(products)}")
}