package id.kawahedukasi.tugas6.service;

import id.kawahedukasi.tugas6.model.Item;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class ItemService {

    public Response findAll() {
        List<Item> items = Item.listAll();
        return Response.ok(items).build();
    }

    public Response findById(@PathParam("id") Long id) {
        Item item = Item.findById(id);
        if (item == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(item).build();
    }

    @Transactional
    public Response post(Item item) {
        item.setCreatedat(LocalDateTime.now());
        item.persist();
        return Response.status(Response.Status.CREATED).entity(item).build();
    }

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
        item.setUpdatedat(LocalDateTime.now());

        item.persist();
        return Response.ok(item).build();
    }

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
