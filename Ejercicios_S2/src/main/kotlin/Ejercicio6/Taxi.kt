package Ejercicio6

class Taxi(var placa : String, var conductor : String, var modelo : String){
    fun iniciarServicio() : String {
        return """
            ====================================================================================================
            El taxi con placa $placa ha iniciado su servicio con el conductor $conductor y modelo $modelo.
            """.trimIndent()
    }
}