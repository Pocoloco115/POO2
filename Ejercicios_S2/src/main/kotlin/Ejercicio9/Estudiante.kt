package Ejercicio9

class Estudiante(var carrera : String): Persona() {
    fun estudiar() : String {
        return """
                ================================
                El estudiante ${getNombre()} está estudiando $carrera
            """.trimIndent()
    }
}