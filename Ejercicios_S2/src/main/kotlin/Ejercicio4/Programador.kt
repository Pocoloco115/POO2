package Ejercicio4

class Programador(var lenguaje : String) : Empleado() {
    fun mostrarDatos(): String {
        val datos = """
                ============================
                Nombre: ${getNombre()}
                Salario: ${getSalario()}
                Lenguaje de Programación: $lenguaje
            """.trimIndent()
        return datos
    }
}