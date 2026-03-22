package utils
import java.io.File
object FileUtils {
    fun createOutputFile(fileName: String):File {
        val outputFile = File(fileName)
        if (!outputFile.exists()) {
            outputFile.createNewFile()
        }
        return outputFile
    }
}