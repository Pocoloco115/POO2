package Ejercicio10
import utils.FileUtils
fun main(){
    val libro1 = Libro("Cien años de soledad", "Gabriel García Márquez", 1967)
    val libro2 = Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 1605)
    val libro3 = Libro("La sombra del viento", "Carlos Ruiz Zafón", 2001)
    val libro4 = Libro("El amor en los tiempos del cólera", "Gabriel García Márquez", 1985)

    val outputFile = FileUtils.createOutputFile("src/main/kotlin/Ejercicio10/output.txt")
    val stringBuilder = StringBuilder()
    stringBuilder.appendLine("Libros creados")
    listOf(libro1, libro2, libro3, libro4).forEach {
        val mensaje = it.mostrarInformacion()
        println(mensaje)
        stringBuilder.appendLine(mensaje)
        stringBuilder.appendLine("================================================================")
    }
    outputFile.writeText(stringBuilder.toString())
}