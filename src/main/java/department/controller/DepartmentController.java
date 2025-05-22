package department.controller;

import department.dto.DepartmentDTO;
import department.service.DepartmentService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("departmentOperation")
public class DepartmentController {

    @Inject
    DepartmentService departmentService;

    @GET
    @Path("allDepartments")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public List<DepartmentDTO> getAllDepartment() {
        return departmentService.getAllDepartment();
    }

    @GET
    @Path("departmentById")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public DepartmentDTO getDepartmentById(@QueryParam("id") int id) {
        return departmentService.getDepartmentById(id);
    }

    @POST
    @Path("addDepartment")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public DepartmentDTO addDepartment(@QueryParam("id") int id, @QueryParam("name") String name) {
        return departmentService.addDepartment(id, name);
    }

    @PUT
    @Path("updateDepartmentById")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public DepartmentDTO updateDepartmentById(@QueryParam("id") int id, @QueryParam("name") String name) {
        return departmentService.updateDepartment(id, name);
    }

    @DELETE
    @Path("deleteDepartmentById")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public DepartmentDTO deleteDepartmentById(@QueryParam("id") int id) {
        return departmentService.deleteDepartmentById(id);
    }
}
