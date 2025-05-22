package course.controller;

import course.dto.CourseDTO;
import course.service.CourseService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("courseOperation")
public class CourseController {

    @Inject
    CourseService courseService;

    @GET
    @Path("allCourses")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GET
    @Path("coursesById")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public CourseDTO getCourseById(@QueryParam("id") int id) {
        return courseService.getCourseById(id);
    }

    @GET
    @Path("coursesByName")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public CourseDTO getCoursesByName(@QueryParam("name") String name) {
        return courseService.getCoursesByName(name);
    }

    @POST
    @Path("addCourses")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public CourseDTO addCourse(@QueryParam("name") String name, @QueryParam("isActive") boolean isActive,
                               @QueryParam("numberOfHours") int numberOfHours, @QueryParam("departmentId") int departmentId) {
        return courseService.addCourse(name, isActive, numberOfHours, departmentId);
    }

    @PUT
    @Path("updateCourseById")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public CourseDTO updateCourseById(@QueryParam("id") int id, @QueryParam("name") String name, @QueryParam("isActive") boolean isActive,
                                          @QueryParam("numberOfHours") int numberOfHours, @QueryParam("departmentId") int departmentId) {
        return courseService.updateCourseById(id, name, isActive, numberOfHours, departmentId);
    }

    @DELETE
    @Path("deleteCourseById")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public CourseDTO deleteCourseById(@QueryParam("id") int id) {
        return courseService.deleteCourseById(id);
    }

    @DELETE
    @Path("deleteCourseByName")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public CourseDTO deleteCourseByName(@QueryParam("name") String name) {
        return courseService.deleteCourseByName(name);
    }

}
