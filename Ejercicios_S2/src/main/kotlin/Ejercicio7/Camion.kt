package Ejercicio7

class Camion : Vehiculo {
    override fun mover(): String {
        return """
            ===============================
            El camion se está moviendo
        """.trimIndent()
    }
}