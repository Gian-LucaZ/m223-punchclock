package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Category;
import ch.zli.m223.service.GenericService;

@Path("/categories")
@Tag(name = "Category", description = "Handling of categories")
public class CategoryController {
    
    @Inject
    GenericService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Categories.", description = "Returns a list of all categories.")
    public List<Category> index() {
        return service.index(Category.class);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new category.", description = "Creates a new category and returns the newly added category.")
    public Category create(Category category) {
       return service.create(category);
    }

    @DELETE @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category delete(@PathParam("id") Long id){
        return service.delete(id, Category.class);
    }

    @PUT @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Category update(@PathParam("id") Long id, Category category){
        return service.alter(category);
    }
}

