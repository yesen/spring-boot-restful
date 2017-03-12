package com.jessen.controller.sys;

import com.jessen.domain.sys.UsersDomain;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by sen.ye on 2017/43/12.
 */

@Path("/users")
public interface UsersResource {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    List<UsersDomain> findAll();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    UsersDomain findById(@PathParam("id") Long id);

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)//接收
    @Produces(MediaType.APPLICATION_JSON)
//返回
    UsersDomain create(final UsersDomain domain);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)//接收
    @Produces(MediaType.APPLICATION_JSON)
//返回
    UsersDomain update(@PathParam("id") Long id, final UsersDomain domain);

    @DELETE
    @Path("/{id}")
    void delete(@PathParam("id") Long id);
}

