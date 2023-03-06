package id.kawahedukasi.tugas6.controller;

import id.kawahedukasi.tugas6.model.Item;
import id.kawahedukasi.tugas6.service.ItemService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemController {
    @Inject
    ItemService itemService;

    @GET
    public Response findAll(){
        return itemService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return itemService.findById(id);
    }

    @POST
    public Response post(Item item) {
        return itemService.post(item);
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
