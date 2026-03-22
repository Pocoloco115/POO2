package Ejercicio6

fun main() {
    val taxi1 = Taxi("1J-9520", "Travis Bickle", "Checker Marathon")
    val taxi2 = Taxi("XYZ789", "Maria Gomez", "Honda Accord")

    val outputFile = utils.FileUtils.createOutputFile("src/main/kotlin/Ejercicio6/output.txt")
    val stringBuilder = StringBuilder()
    stringBuilder.appendLine("Taxis creados")
    listOf(taxi1, taxi2).forEach {
        val mensaje = it.iniciarServicio()
        println(mensaje)
        stringBuilder.appendLine(mensaje)
    }
    outputFile.writeText(stringBuilder.toString())
}