package id.kawahedukasi.tugas6.service;

import id.kawahedukasi.tugas6.dto.FileFormDTO;
import id.kawahedukasi.tugas6.model.Item;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ApplicationScoped
public class ImportService {
    @Transactional
    public Response importExcel(FileFormDTO request) throws IOException {

        //create object array input
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(request.file);

        //create new workbook by byteArrayInputStream
        XSSFWorkbook workbook = new XSSFWorkbook(byteArrayInputStream);

        //get sheet "data"
        XSSFSheet sheet = workbook.getSheetAt(0);

        //remove header excel
        sheet.removeRow(sheet.getRow(0));


        List<Item> toPersist = new ArrayList<>();
        //for each row
        for (Row row : sheet) {
            Item item = new Item();
            item.setName(row.getCell(0).getStringCellValue());
            item.setCount(row.getCell(1).getNumericCellValue());
            item.setPrice(row.getCell(2).getNumericCellValue());
            item.setType(row.getCell(3).getStringCellValue());
            item.setDescription(row.getCell(4).getStringCellValue());
            toPersist.add(item);
        }
        Item.persist(toPersist);
        return Response.status(Response.Status.CREATED).entity(new HashMap<>()).build();
    }

    @Transactional
    public Response importCSV(FileFormDTO request) throws IOException, CsvValidationException {
        //create object array input
        File file = File.createTempFile("temp", "");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(request.file);


            CSVReader reader = new CSVReader(new FileReader(file));
            String[] nextLine;
            reader.skip(1);

            List<Item> toPersist = new ArrayList<>();
            while ((nextLine = reader.readNext()) != null) {
                Item item = new Item();
                item.setName(nextLine[0].trim());
                item.setCount(Double.parseDouble(nextLine[1].trim()));
                item.setPrice(Double.parseDouble(nextLine[2].trim()));
                item.setType(nextLine[3].trim());
                item.setDescription(nextLine[4].trim());
                toPersist.add(item);

                Item.persist(toPersist);

            }
        }
        return Response.status(Response.Status.CREATED).entity(new HashMap<>()).build();
    }
}
