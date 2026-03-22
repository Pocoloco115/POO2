package Ejercicio1

import utils.FileUtils

fun main() {
    val estudiante1 = Estudiante("Juan Perez", "20210001", "Ingeniería en Sistemas", 2021)
    val estudiante2 = Estudiante("Maria Gomez", "20210002", "Medicina", 2020)
    val estudiante3 = Estudiante("Carlos Lopez", "20210003", "Derecho", 2019)
    val outputFile = FileUtils.createOutputFile("src/main/kotlin/Ejercicio1/output.txt")
    val stringBuilder = StringBuilder()
    stringBuilder.appendLine("Estudiantes creados")
    listOf(estudiante1, estudiante2, estudiante3).forEach {
        val datos = it.mostrarDatos()
        stringBuilder.appendLine(datos)
    }
    outputFile.writeText(stringBuilder.toString())
}