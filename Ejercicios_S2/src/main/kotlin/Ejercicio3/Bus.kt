package Ejercicio3

class Bus(var numeroRuta : Int, var capacidad : Int, var conductor : String) {
    fun iniciarRuta() : String {
        return """
            ====================================================================================================
            El bus con número de ruta $numeroRuta ha iniciado su recorrido con el conductor $conductor.
            """.trimIndent()
    }
}