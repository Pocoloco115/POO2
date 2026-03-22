package Ejercicio2

class Producto(var nombre : String, var precio: Double, var cantidad: Int) {

     fun mostrarDatos(): String {
         val datos = """
             ============================
             Nombre: $nombre
             Precio: $precio
             Cantidad: $cantidad
         """.trimIndent()
         return datos
     }
}
