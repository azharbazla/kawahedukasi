package id.kawahedukasi.tugas6.controller;

import id.kawahedukasi.tugas6.model.Item;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.List;

@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemController {
    @GET
    public Response list() {
        List<Item> items = Item.listAll();
        return Response.ok(items).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Item item = Item.findById(id);
        if (item == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(item).build();
    }

    @POST
    @Transactional
    public Response post(Item item) {
        item.setCreatedAt(LocalDateTime.now());
        item.persist();
        return Response.status(Response.Status.CREATED).entity(item).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Item updatedItem) {
        Item item = Item.findById(id);
        if (item == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        item.setName(updatedItem.getName());
        item.setCount(updatedItem.getCount());
        item.setPrice(updatedItem.getPrice());
        item.setType(updatedItem.getType());
        item.setDescription(updatedItem.getDescription());
        item.setUpdatedAt(LocalDateTime.now());

        item.persist();
        return Response.ok(item).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Item item = Item.findById(id);
        if (item == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        item.delete();
        return Response.noContent().build();
    }
}
