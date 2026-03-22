package Ejercicio1

class Estudiante(var nombre: String, var carnet: String, var carrera: String, var año : Int) {
    fun mostrarDatos() : String {
        val datos = """
            ============================
            Nombre: $nombre
            Carnet: $carnet
            Carrera: $carrera
            Año: $año
        """.trimIndent()
        println(datos)
        return datos
    }
}

