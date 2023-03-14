package id.kawahedukasi.tugas6.controller;

import com.opencsv.exceptions.CsvValidationException;
import id.kawahedukasi.tugas6.dto.FileFormDTO;
import id.kawahedukasi.tugas6.model.Item;
import id.kawahedukasi.tugas6.service.ExportService;
import id.kawahedukasi.tugas6.service.ImportService;
import id.kawahedukasi.tugas6.service.ItemService;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemController {
    @Inject
    ItemService itemService;

    @Inject
    ExportService exportService;

    @Inject
    ImportService importService;

    @GET
    public Response findAll(){
        return itemService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return itemService.findById(id);
    }

    @GET
    @Path("/export/pdf")
    @Produces("application/pdf")
    public Response exportPdf() {
        return exportService.exportPdfItem();
    }

    @GET
    @Path("/export/excel")
    @Produces("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    public Response exportExcel() {
        return exportService.exportExcelItem();
    }

    @GET
    @Path("/export/csv")
    @Produces("text/csv")
    public Response exportCsv() {
        return exportService.exportCsvItem();
    }

    @POST
    public Response post(Item item) {
        return itemService.post(item);
    }

    @POST
    @Path("/import/excel")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response importExcel(@MultipartForm FileFormDTO request) {
        try{
            return importService.importExcel(request);
        } catch (IOException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/import/csv")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response importCSV(@MultipartForm FileFormDTO request) {
        try{
            return importService.importCSV(request);
        } catch (IOException | CsvValidationException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Item updatedItem) {
        return itemService.update(id, updatedItem);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        return itemService.delete(id);
    }
}
