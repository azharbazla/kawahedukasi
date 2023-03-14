package id.kawahedukasi.tugas6.service;

import id.kawahedukasi.tugas6.model.Item;

import com.opencsv.CSVWriter;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

@ApplicationScoped
public class ExportService {
    public Response exportPdfItem() {
        try {
            //load template jasper
            File file = new File("src/main/resources/tugas6.jrxml");

            //build object jasper report dari load template
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

            //create datasource jasper for all data Item
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(Item.listAll());

//        Map<String, Object> param = new HashMap<>();
//        param.put("DATASOURCE", jrBeanCollectionDataSource);

            //create object jasperPrint
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>() , jrBeanCollectionDataSource);

            //export jasperPrint to byte array
            byte[] jasperResult = JasperExportManager.exportReportToPdf(jasperPrint);

            //return response dengan content type pdf
            return Response.ok()
                    .type("application/pdf")
                    .entity(jasperResult)
                    .header("Content-Disposition", "inline; filename=list_item.pdf")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error exporting PDF.")
                    .build();
        }
    }
    public Response exportExcelItem() {
        try {
            ByteArrayOutputStream outputStream = excelItem();
//        Content-Disposition: attachment; filename="name_of_excel_file.xls"
            return Response.ok()
                .type("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                .header("Content-Disposition", "attachment; filename=\"Item_list_excel.xlsx\"")
                .entity(outputStream.toByteArray()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error exporting Excel.")
                    .build();
        }
    }
    public ByteArrayOutputStream excelItem() {
            //get all data Item
            List<Item> itemList = Item.listAll();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            //create workbook and write data to output stream
            try (XSSFWorkbook workbook = new XSSFWorkbook()) {
                //create sheet
                XSSFSheet sheet = workbook.createSheet("data");

                //set header
                int rownum = 0;
                Row row = sheet.createRow(rownum++);
                row.createCell(0).setCellValue("id");
                row.createCell(1).setCellValue("name");
                row.createCell(2).setCellValue("count");
                row.createCell(3).setCellValue("price");
                row.createCell(4).setCellValue("type");
                row.createCell(5).setCellValue("description");
                row.createCell(6).setCellValue("createdAt");
                row.createCell(7).setCellValue("updateAt");

                //set data
                for(Item Item : itemList){
                    row = sheet.createRow(rownum++);
                    row.createCell(0).setCellValue(Item.getId());
                    row.createCell(1).setCellValue(Item.getName());
                    row.createCell(2).setCellValue(Item.getCount());
                    row.createCell(3).setCellValue(Item.getPrice());
                    row.createCell(4).setCellValue(Item.getType());
                    row.createCell(5).setCellValue(Item.getDescription());
                    row.createCell(6).setCellValue(Item.getCreatedat().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
                    row.createCell(7).setCellValue(Item.getUpdatedat().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
                }

                workbook.write(outputStream);
                return outputStream;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    public Response exportCsvItem() {
        try {
            //get all data Item
            List<Item> itemList = Item.listAll();
            if (itemList == null || itemList.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND).entity("No Item data found.").build();
            }
            File file = File.createTempFile("temp", "");

            // create FileWriter object with file as parameter
            FileWriter outputFile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputFile);

            String[] headers = {"id", "name", "count", "price", "type", "description","createdAt", "updateAt"};
            writer.writeNext(headers);
            for(Item item : itemList){
                String[] data = {
                        item.getId().toString(),
                        item.getName(),
                        item.getCount().toString(),
                        item.getPrice().toString(),
                        item.getType(),
                        item.getDescription(),
                        item.getCreatedat().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")),
                        item.getUpdatedat().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss"))
                };
                writer.writeNext(data);
            }
            writer.close(); //close CSVWriter
            outputFile.close(); //close FileWriter

            return Response.ok()
                    .type("text/csv")
                    .header("Content-Disposition", "attachment; filename=\"Item_list_csv.csv\"")
                    .entity(file)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error exporting CSV.")
                    .build();
        }
    }

}
