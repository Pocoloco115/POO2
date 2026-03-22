package Ejercicio4

open class Empleado{
    private var nombre : String = ""
    private var salario : Double = 0.0

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }
    fun setSalario(salario: Double) {
        this.salario = salario
    }
    fun getNombre(): String {
        return nombre
    }
    fun getSalario(): Double {
        return salario
    }
}
