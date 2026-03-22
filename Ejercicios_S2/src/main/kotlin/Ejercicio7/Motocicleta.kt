package Ejercicio7

class Motocicleta : Vehiculo {
    override fun mover(): String {
        return """
            ===============================
            La motocicleta se está moviendo
        """.trimIndent()
    }
}