package id.kawahedukasi.tugas6.controller;

import id.kawahedukasi.tugas6.service.MailService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/mail")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MailController {

    @Inject
    MailService mailService;

    @POST
    public Response sendEmail(Map<String, Object> request) {
        mailService.sendEmail(request.get("email").toString());
        return Response.ok(new HashMap<>()).build();
    }
    @POST
    @Path("/excel")
    public Response sendExcelToEmail(Map<String, Object> request) {
        mailService.sendExcelToEmail(request.get("email").toString());
        return Response.ok(new HashMap<>()).build();
    }

}