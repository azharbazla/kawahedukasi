package id.kawahedukasi.tugas6.controller;

import id.kawahedukasi.tugas6.model.Item;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemController {
    @GET
    public Response list() {
        return Response.status(Response.Status.OK).entity(Item.findAll().list()).build();

    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Item item = Item.findById(id);
        return Response.status(Response.Status.OK).entity(item).build();
    }

    @POST
    @Transactional
    public Response post(Map<String, Object> req) {
        Item item = new Item();
        item.name = req.get("name").toString();
        item.count = req.get("email").toString();
        item.price = req.get("price").toString();
        item.type = req.get("type").toString();
        item.description = req.get("description").toString();
        item.createdAt = LocalDateTime.now();

        item.persist();
        return Response.status(Response.Status.CREATED).entity(new HashMap<>()).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Map<String, Object> req) {
        Item item = Item.findById(id);
        if (item == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        item.name = req.get("name").toString();
        item.count = req.get("email").toString();
        item.price = req.get("price").toString();
        item.type = req.get("type").toString();
        item.description = req.get("description").toString();
        item.updatedAt = LocalDateTime.now();

        item.persist();
        return Response.status(Response.Status.CREATED).entity(new HashMap<>()).build();
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
        return Response.status(Response.Status.NO_CONTENT).entity(new HashMap<>()).build();
    }
}

