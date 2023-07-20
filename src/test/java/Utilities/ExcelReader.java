package Utilities;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.xssf.usermodel.*;
import org.javatuples.Quintet;

public class ExcelReader {
    public Sheet GetSheetByName(String excelFilePath, String sheetName)
            throws IOException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        Sheet sheet = GetWorkBook(excelFilePath).getSheet(sheetName);
        return sheet;
    }

    private Sheet GetSheetByIndex(String excelFilePath, int sheetNumber)
            throws IOException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        Sheet sheet = GetWorkBook(excelFilePath).getSheetAt(sheetNumber);
        return sheet;
    }

    private Workbook GetWorkBook(String excelFilePath)
            throws IOException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        return WorkbookFactory.create(new File(excelFilePath));
    }

    public List<Map<String, String>> ReadSheet(Sheet sheet) {
        Row row;
        int totalRow = sheet.getPhysicalNumberOfRows();
        List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
        int headerRowNumber = GetHeaderRowNumber(sheet);
        if (headerRowNumber != -1) {
            int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
            int setCurrentRow = 1;
            for (int currentRow = setCurrentRow; currentRow <= totalRow; currentRow++) {
                row = GetRow(sheet, sheet.getFirstRowNum() + currentRow);
                LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                    columnMapdata.putAll(GetCellValue(sheet, row, currentColumn));
                }
                excelRows.add(columnMapdata);
            }
        }
        return excelRows;
    }

    private int GetHeaderRowNumber(Sheet sheet) {
        Row row;
        int totalRow = sheet.getLastRowNum();
        for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
            row = GetRow(sheet, currentRow);
            if (row != null) {
                int totalColumn = row.getLastCellNum();
                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                    Cell cell;
                    cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                   if (cell.getCellType() == CellType.STRING) {
                        return row.getRowNum();

                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        return row.getRowNum();

                    } else if (cell.getCellType() == CellType.BOOLEAN) {
                        return row.getRowNum();
                    } else if (cell.getCellType() == CellType.ERROR) {
                        return row.getRowNum();
                    }
                }
            }
        }
        return (-1);
    }

    private Row GetRow(Sheet sheet, int rowNumber) {
        return sheet.getRow(rowNumber);
    }

    private LinkedHashMap<String, String> GetCellValue(Sheet sheet, Row row, int currentColumn) {

        LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
        Cell cell;
        if (row == null) {
            if (sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .getCellType() != CellType.BLANK) {
                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
                        .getStringCellValue();
                columnMapdata.put(columnHeaderName, "");
            }
        } else {
            cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if(cell.getCellType() == CellType.FORMULA)
            {
                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                        .getStringCellValue();

                switch (cell.getCachedFormulaResultType()) {
                    case BOOLEAN:
                        columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
                        break;
                    case NUMERIC:
                        columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
                        break;
                    case STRING:
                        columnMapdata.put(columnHeaderName, cell.getRichStringCellValue().toString());
                        break;
                }
            }
            else if (cell.getCellType() == CellType.STRING) {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, cell.getStringCellValue());
                }
            } else if (cell.getCellType() == CellType.NUMERIC) {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
                }
            } else if (cell.getCellType() == CellType.BLANK) {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, "");
                }
            } else if (cell.getCellType() == CellType.BOOLEAN) {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
                }
            } else if (cell.getCellType() == CellType.ERROR) {
                if (sheet.getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != CellType.BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
                }
            }
        }
        return columnMapdata;
    }

    public void CreateExcel(List<Quintet<String, String, String, String, String>> excelData, String columnNames, String fileName) {
        try {
            FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
            Properties prop = new Properties();
            prop.load(fileInput);

            //Create workbook in .xlsx format
            Workbook workbook = new XSSFWorkbook();
            //For .xsl workbooks use new HSSFWorkbook();
            //Create Sheet
            Sheet sh = workbook.createSheet("Report Data");

            //Create top row with column headings
            String[] columnHeadings = columnNames.split(",");
            //We want to make it bold with a foreground color.
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 12);
            headerFont.setColor(IndexedColors.BLACK.index);
            //Create a CellStyle with the font
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
            //Create the header row
            Row headerRow = sh.createRow(0);
            //Iterate over the column headings to create columns
            for (int headerCounter = 0; headerCounter < columnHeadings.length; headerCounter++) {
                Cell cell = headerRow.createCell(headerCounter);
                cell.setCellValue(columnHeadings[headerCounter]);
                cell.setCellStyle(headerStyle);
            }
            //Freeze Header Row
            sh.createFreezePane(0, 1);
            //Fill data
            CreationHelper creationHelper = workbook.getCreationHelper();

            //We want to make it bold with a foreground color.
            Font rowCellFont = workbook.createFont();
            //dateStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd/MM/yyyy"));
            int rownum = 1;
            for (int dataCounter = 0; dataCounter < excelData.stream().count(); dataCounter++) {
                //System.out.println("rownum-before"+(rownum));
                Row row = sh.createRow(rownum++);

                for (int dataValuesCounter = 0; dataValuesCounter < excelData.get(dataCounter).getSize(); dataValuesCounter++) {
                    //System.out.println("rownum-after"+(rownum));
                    if (excelData.get(dataCounter).getValue(dataValuesCounter).toString().toLowerCase().equals("pass")) {
                        CellStyle rowCellStyle = workbook.createCellStyle();
                        rowCellFont.setColor(IndexedColors.WHITE.index);
                        Cell customCell = row.createCell(dataValuesCounter);
                        customCell.setCellValue(excelData.get(dataCounter).getValue(dataValuesCounter).toString());
                        rowCellStyle.setFont(rowCellFont);
                        rowCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        rowCellStyle.setFillForegroundColor(IndexedColors.GREEN.index);
                        customCell.setCellStyle(rowCellStyle);
                        customCell = null;
                        rowCellStyle = null;
                    } else if (excelData.get(dataCounter).getValue(dataValuesCounter).toString().toLowerCase().equals("fail")) {
                        CellStyle rowCellStyle = workbook.createCellStyle();
                        rowCellFont.setColor(IndexedColors.WHITE.index);
                        Cell customCell = row.createCell(dataValuesCounter);
                        customCell.setCellValue(excelData.get(dataCounter).getValue(dataValuesCounter).toString());
                        rowCellStyle.setFont(rowCellFont);
                        rowCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        rowCellStyle.setFillForegroundColor(IndexedColors.RED.index);
                        customCell.setCellStyle(rowCellStyle);
                        customCell = null;
                        rowCellStyle = null;
                    } else
                        row.createCell(dataValuesCounter).setCellValue(excelData.get(dataCounter).getValue(dataValuesCounter).toString());
                }
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss", Locale.ENGLISH).withZone(ZoneOffset.UTC);
            LocalDateTime dateTime = LocalDateTime.now();
            String formatDateTime = dateTime.format(formatter);

            String excelFileName = fileName + "_" + GetReportStatus(excelData) + "_" + formatDateTime + ".xlsx";
            String reportPath = (System.getProperty("publishExcelReportPath") != null ? System.getProperty("publishExcelReportPath") : prop.getProperty("publishExcelReportPath")) + excelFileName;
            // .xlsx is the format for Excel Sheets...
            // writing the workbook into the file...
            FileOutputStream fileOut = new FileOutputStream(new File(reportPath));
            workbook.write(fileOut);
//closing the Stream
            fileOut.close();
//closing the workbook
            workbook.close();
            formatter = null;
            dateTime = null;
            excelFileName = "";
            reportPath = "";

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void CreateExcelWithListMap(List<Map<String, String>> excelData, String columnNames, String fileName) {
        try {
            FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
            Properties prop = new Properties();
            prop.load(fileInput);

            //Create workbook in .xlsx format
            Workbook workbook = new XSSFWorkbook();
            //For .xsl workbooks use new HSSFWorkbook();
            //Create Sheet
            Sheet sh = workbook.createSheet("Report Data");

            //Create top row with column headings
            String[] columnHeadings = columnNames.split(",");
            //We want to make it bold with a foreground color.
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 12);
            headerFont.setColor(IndexedColors.BLACK.index);
            //Create a CellStyle with the font
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
            //Create the header row
            Row headerRow = sh.createRow(0);
            //Iterate over the column headings to create columns
            for (int headerCounter = 0; headerCounter < columnHeadings.length; headerCounter++) {
                Cell cell = headerRow.createCell(headerCounter);
                cell.setCellValue(columnHeadings[headerCounter]);
                cell.setCellStyle(headerStyle);
            }
            //Freeze Header Row
            sh.createFreezePane(0, 1);
            //Fill data
            CreationHelper creationHelper = workbook.getCreationHelper();

            //We want to make it bold with a foreground color.
            Font rowCellFont = workbook.createFont();
            //dateStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd/MM/yyyy"));
            int rownum = 1;
            int cellCounter = 0;
            for (int dataCounter = 0; dataCounter < excelData.stream().count(); dataCounter++) {
                //System.out.println("rownum-before"+(rownum));
                Row row = sh.createRow(rownum++);
                cellCounter = 0;
                for (Map.Entry<String, String> cellData : excelData.get(dataCounter).entrySet()) {
                    //System.out.println("rownum-after"+(rownum));
                    if (cellData.getValue().toLowerCase().equals("pass")) {
                        CellStyle rowCellStyle = workbook.createCellStyle();
                        rowCellFont.setColor(IndexedColors.WHITE.index);
                        Cell customCell = row.createCell(cellCounter);
                        customCell.setCellValue(cellData.getValue());
                        rowCellStyle.setFont(rowCellFont);
                        rowCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        rowCellStyle.setFillForegroundColor(IndexedColors.GREEN.index);
                        customCell.setCellStyle(rowCellStyle);
                        customCell = null;
                        rowCellStyle = null;
                    } else if (cellData.getValue().toLowerCase().equals("fail")) {
                        CellStyle rowCellStyle = workbook.createCellStyle();
                        rowCellFont.setColor(IndexedColors.WHITE.index);
                        Cell customCell = row.createCell(cellCounter);
                        customCell.setCellValue(cellData.getValue());
                        rowCellStyle.setFont(rowCellFont);
                        rowCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        rowCellStyle.setFillForegroundColor(IndexedColors.RED.index);
                        customCell.setCellStyle(rowCellStyle);
                        customCell = null;
                        rowCellStyle = null;
                    } else
                        row.createCell(cellCounter).setCellValue(cellData.getValue());

                    cellCounter++;
                }
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss", Locale.ENGLISH).withZone(ZoneOffset.UTC);
            LocalDateTime dateTime = LocalDateTime.now();
            String formatDateTime = dateTime.format(formatter);

            String excelFileName = fileName + "_" + GetReportStatusWithMapList(excelData) + "_" + formatDateTime + ".xlsx";
            String reportPath = (System.getProperty("publishExcelReportPath") != null ? System.getProperty("publishExcelReportPath") : prop.getProperty("publishExcelReportPath")) + excelFileName;
            // .xlsx is the format for Excel Sheets...
            // writing the workbook into the file...
            FileOutputStream fileOut = new FileOutputStream(new File(reportPath));
            workbook.write(fileOut);
//closing the Stream
            fileOut.close();
//closing the workbook
            workbook.close();
            formatter = null;
            dateTime = null;
            excelFileName = "";
            reportPath = "";

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String GetReportStatus(List<Quintet<String, String, String, String, String>> resultReport) {
        try {
            var reportStatus = resultReport.stream().filter(result -> result.toString().toLowerCase().contains("fail")).toList();

            if (reportStatus.stream().count() > 0)
                return "Fail";
            else
                return "Pass";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Fail";
        }
    }

    public String GetReportStatusWithMapList(List<Map<String, String>> resultReport) {
        try {
            var reportStatus = resultReport.stream().filter(result -> result.toString().toLowerCase().contains("fail")).toList();

            if (reportStatus.stream().count() > 0)
                return "Fail";
            else
                return "Pass";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Fail";
        }
    }
}