package Ejercicio8
import utils.FileUtils
fun main(){
    val pedido1 = Pedido("Carlos", "Tacos", 50.0)
    val pedido2 = Pedido("Ana", "Enchiladas", 70.0)
    val pedido3 = Pedido("Esteban", "Carne asada", 50.0)

    val outputFile = FileUtils.createOutputFile("src/main/kotlin/Ejercicio8/output.txt")
    val stringBuilder = StringBuilder()
    stringBuilder.appendLine("Pedidos creados")
    listOf(pedido1, pedido2, pedido3).forEach {
        val mensaje = it
        println(mensaje)
        stringBuilder.appendLine(mensaje)
        stringBuilder.appendLine("================================================================")
    }
    outputFile.writeText(stringBuilder.toString())
}