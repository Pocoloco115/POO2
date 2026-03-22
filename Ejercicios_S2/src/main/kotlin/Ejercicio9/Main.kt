package Ejercicio9
import utils.FileUtils

fun main(){
    val docente = Docente("Matemáticas")
    docente.setNombre("María López")
    docente.setEdad(30)
    val estudiante = Estudiante("Ingeniería de Software")
    estudiante.setNombre("Juan Pérez")
    estudiante.setEdad(20)
    var outputFile = FileUtils.createOutputFile("src/main/kotlin/Ejercicio9/output.txt")
    var stringBuilder = StringBuilder()
    stringBuilder.appendLine("Personas creadas")
    listOf(docente, estudiante).forEach {
        val mensaje = when(it){
            is Docente -> it.enseñar()
            is Estudiante -> it.estudiar()
            else -> "Persona desconocida"
        }
        println(mensaje)
        stringBuilder.appendLine(mensaje)
    }
    outputFile.writeText(stringBuilder.toString())
}
