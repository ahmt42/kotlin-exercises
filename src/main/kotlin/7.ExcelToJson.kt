import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File
import java.io.FileInputStream

fun main() {
    //val excelFile = File("path/to/excel/file.xlsx")
    val excelFile = File("./files/hasta.xlsx")
    val jsonFile = File("./files/hasta.json")
    excelToJson(excelFile, jsonFile)
}

fun excelToJson(excelFile: File, jsonFile: File) {
    val workbook = WorkbookFactory.create(FileInputStream(excelFile))
    val sheet = workbook.getSheetAt(0)
    val rows = sheet.iterator()
    val data = mutableListOf<Map<String, Any>>()

    while (rows.hasNext()) {
        val row = rows.next()
        val cells = row.cellIterator()
        val obj = mutableMapOf<String, Any>()

        while (cells.hasNext()) {
            val cell = cells.next()
            val columnIndex = cell.columnIndex
            val columnName = sheet.getRow(0).getCell(columnIndex).stringCellValue

            obj[columnName] = when (cell.cellType) {
                CellType.STRING -> cell.stringCellValue
                CellType.NUMERIC -> if (DateUtil.isCellDateFormatted(cell)) cell.dateCellValue else cell.numericCellValue
                CellType.BOOLEAN -> cell.booleanCellValue
                else -> ""
            }

            println(obj[columnName])
        }

        data.add(obj)
    }

    val json = ObjectMapper().writeValueAsString(data)
    jsonFile.writeText(json)
}