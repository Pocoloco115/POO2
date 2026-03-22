package Ejercicio5

class CuentaBancaria (private var numeroDeCuenta : Int, private var saldo : Double){
    fun depositar(monto : Double) {
        saldo += monto
    }
    fun retirar(monto : Double) {
        if (monto <= saldo) {
            saldo -= monto
        } else {
            println("Saldo insuficiente para retirar $monto")
        }
    }
    fun mostrarSaldo() : String {
        return "El saldo actual de la cuenta $numeroDeCuenta es: $saldo"
    }
}