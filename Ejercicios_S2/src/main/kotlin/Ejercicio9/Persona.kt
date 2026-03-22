package Ejercicio9

open class Persona {
    private var nombre = ""
    private var edad = 0

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }
    fun setEdad(edad: Int) {
        this.edad = edad
    }
    fun getNombre(): String {
        return nombre
    }
    fun getEdad(): Int {
        return edad
    }
}