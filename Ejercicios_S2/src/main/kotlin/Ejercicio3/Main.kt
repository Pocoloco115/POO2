package Ejercicio3

fun main() {
    val bus1 = Bus(101, 50, "Juan Perez")
    val bus2 = Bus(202, 40, "Maria Gomez")

    val outputFile = utils.FileUtils.createOutputFile("src/main/kotlin/Ejercicio3/output.txt")
    val stringBuilder = StringBuilder()
    stringBuilder.appendLine("Rutas de buses creadas")
    listOf(bus1, bus2).forEach {
        val mensaje = it.iniciarRuta()
        println(mensaje)
        stringBuilder.appendLine(mensaje)
    }
    outputFile.writeText(stringBuilder.toString())
}