package Ejercicio9

class Docente(var materia : String): Persona() {
    fun enseñar() : String {
        return """
                ================================
                El docente ${getNombre()} esta enseñando $materia
            """.trimIndent()
    }
}