package Ejercicio2

import utils.FileUtils

fun main() {
    val producto1 = Producto("arroz", 9.99, 10)
    val producto2 = Producto("frijoles", 19.99, 20)
    val producto3 = Producto("azucar", 29.99, 15)
    val producto4 = Producto("aceite", 29.99, 30)
    val producto5 = Producto("jabon", 25.99, 25)

    val outputFile = FileUtils.createOutputFile("src/main/kotlin/Ejercicio2//producto.txt")
    val stringBuilder = StringBuilder()
    stringBuilder.appendLine("Productos creados")
    listOf(producto1, producto2, producto3).forEach {
        val datos = it.mostrarDatos()
        println(datos)
        stringBuilder.appendLine(datos)
    }
    outputFile.writeText(stringBuilder.toString())

}