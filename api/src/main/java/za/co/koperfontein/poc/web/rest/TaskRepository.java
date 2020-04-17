package za.co.koperfontein.poc.web.rest;

import za.co.koperfontein.poc.domain.Task;
import za.co.koperfontein.poc.service.TaskService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/api")
public class TaskRepository {
    @Inject TaskService taskService;
    @POST
    @Path("/task")
    public Task createTask(Task task) {
        return taskService.addTask(task);
    }

    @GET
    @Path("/task/{id}")
    public Response getTask(@PathParam("id") Long id) {
        return taskService.getTask(id)
                .map(Response::ok)
                .map(Response.ResponseBuilder::build)
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}
