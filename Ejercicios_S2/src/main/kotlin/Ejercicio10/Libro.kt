package Ejercicio10

class Libro (var titulo: String, var autor: String, var añoPublicacion: Int) {
    fun mostrarInformacion() : String {
        return """
            ================================
            Título: $titulo
            Autor: $autor
            Páginas: $añoPublicacion
        """.trimIndent()
    }
}