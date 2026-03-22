package Ejercicio5

fun main() {
    val cuenta1 = CuentaBancaria(123456, 1000.0)
    var outputFile = utils.FileUtils.createOutputFile("src/main/kotlin/Ejercicio5/output.txt")
    var stringBuilder = StringBuilder()
    stringBuilder.appendLine("Primer estado de la cuenta")
    stringBuilder.appendLine(cuenta1.mostrarSaldo())
    stringBuilder.appendLine("==============================================================")
    println(cuenta1.mostrarSaldo())
    cuenta1.depositar(500.0)
    stringBuilder.appendLine("Estado de la cuenta después del depósito")
    stringBuilder.appendLine(cuenta1.mostrarSaldo())
    stringBuilder.appendLine("==============================================================")
    println(cuenta1.mostrarSaldo())
    cuenta1.retirar(200.0)
    stringBuilder.appendLine("Estado de la cuenta después del retiro")
    stringBuilder.appendLine(cuenta1.mostrarSaldo())
    stringBuilder.appendLine("==============================================================")
    println(cuenta1.mostrarSaldo())
    cuenta1.retirar(1500.0)
    outputFile.writeText(stringBuilder.toString())
}