package Ejercicio4

fun main() {
    val programador1 = Programador("Kotlin")
    programador1.setNombre("Juan Perez")
    programador1.setSalario(50000.0)

    val programador2 = Programador("Java")
    programador2.setNombre("Maria Gomez")
    programador2.setSalario(60000.0)

    val outputFile = utils.FileUtils.createOutputFile("src/main/kotlin/Ejercicio4/output.txt")
    val stringBuilder = StringBuilder()
    stringBuilder.appendLine("Programadores creados")

    listOf(programador1, programador2).forEach {
        val datos = it.mostrarDatos()
        println(datos)
        stringBuilder.appendLine(datos)
    }

    outputFile.writeText(stringBuilder.toString())
}