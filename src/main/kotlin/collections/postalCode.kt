package collections.collections

data class MeteringPointEntity(
    val operatorEan: String,
    val operatorName: String,
    val productType: ProductType?,
)

enum class ProductType {
    ELK,    //Electricity
    GAS     //Gas
}

data class GridOperatorProductsDto(
    val ean: String,
    val name: String,
    var productTypes: Set<ProductType?>
)

fun main() {
    var entityEan1Gas = MeteringPointEntity("ean1", "Liander", ProductType.GAS)
    var entityEan1Elk = MeteringPointEntity("ean1", "Liander", ProductType.ELK)
    var entityEan2Gas = MeteringPointEntity("ean2", "Liander", ProductType.GAS)
    var entityEan2Null = MeteringPointEntity("ean2", "Liander", null)
    var entities = mutableListOf(entityEan1Gas, entityEan1Elk, entityEan2Gas, entityEan2Null)

    println(findByPostalCode_1(entities))
    println(findByPostalCode_2(entities))
}

fun findByPostalCode_1(entities: List<MeteringPointEntity>): List<GridOperatorProductsDto> {
    val gridOperators = mutableListOf<GridOperatorProductsDto>()
    entities.groupBy { it.operatorEan }.forEach {
        val products = mutableSetOf<ProductType>()
        it.value.map {
            it.productType?.let { products.add(it) }
        }
        gridOperators.add(GridOperatorProductsDto(it.key, it.value[0].operatorName, products))
    }
    return gridOperators

}

fun findByPostalCode_2(entities: List<MeteringPointEntity>): List<GridOperatorProductsDto> {
    return entities.groupBy { it.operatorEan }.map { (key, operators) ->
        val (ean, name) = operators.first()
        GridOperatorProductsDto(ean, name, operators.mapNotNull { it.productType }.toSet())
    }
}
