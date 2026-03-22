package Ejercicio7
import utils.FileUtils
fun main() {
    val motocicleta = Motocicleta()
    val camion = Camion()
    var outputFile = FileUtils.createOutputFile("src/main/kotlin/Ejercicio7/output.txt")
    var stringBuilder = StringBuilder()
    stringBuilder.appendLine("Vehículos creados")
    listOf(motocicleta, camion).forEach {
        val mensaje = it.mover()
        println(mensaje)
        stringBuilder.appendLine(mensaje)
    }
    outputFile.writeText(stringBuilder.toString())
}