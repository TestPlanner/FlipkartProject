package steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellReader {

    public static String excelReader() {
        StringBuilder promptMessageBuilder = new StringBuilder("Please write API test cases in proper format for the following details:\n");

        try {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\Admin\\eclipse\\apiData.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip header row
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            // Reading each row of the Excel sheet
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Read API Endpoint
                Cell endpointCell = row.getCell(0);
                String endpoint = endpointCell != null ? endpointCell.getStringCellValue() : "";

                // Read Request Method
                Cell methodCell = row.getCell(1);
                String method = methodCell != null ? methodCell.getStringCellValue() : "";

                // Read Parameters
                Cell parametersCell = row.getCell(2);
                String parameters = parametersCell != null ? parametersCell.getStringCellValue() : "";

                // Read Status Code
                Cell statusCodeCell = row.getCell(3);
                int statusCode = statusCodeCell != null ? (int) statusCodeCell.getNumericCellValue() : 0;

                // Read Request Body
                Cell requestBodyCell = row.getCell(4);
                String requestBody = requestBodyCell != null ? requestBodyCell.getStringCellValue() : "";

                // Read Response Body
                Cell responseBodyCell = row.getCell(5);
                String responseBody = responseBodyCell != null ? responseBodyCell.getStringCellValue() : "";

                // Construct API details
                String apiDetails = String.format("Endpoint: %s\nMethod: %s\nParameters: %s\nStatus Code: %d\nRequest Body: %s\nResponse Body: %s\n\n",
                        endpoint, method, parameters, statusCode, requestBody, responseBody);

                // Append API details to prompt message
                promptMessageBuilder.append(apiDetails);
            }

            file.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Generate final prompt message
        String promptMessage = promptMessageBuilder.toString();
        System.out.println("Prompt message to request API test cases:\n" + promptMessage);
        return promptMessage;
    }
}