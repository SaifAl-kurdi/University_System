package course.service;

import course.dto.CourseDTO;
import course.model.CourseModel;
import course.repository.CourseRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CourseService {

    @Inject
    CourseRepository courseRepository;


    public List<CourseDTO> getAllCourses() {
        List<CourseModel> courseModels = courseRepository.getAllCourses();
        return courseModels.stream().map(CourseDTO::new).collect(Collectors.toList());
    }

    public CourseDTO getCourseById(int id) {
        return new CourseDTO(courseRepository.getCourseById(id));
    }

    public CourseDTO getCoursesByName(String name) {
        return new CourseDTO(courseRepository.getCoursesByName(name));
    }

    public CourseDTO addCourse(String name, boolean isActive, int numberOfHours, int departmentId) {
        return new CourseDTO(courseRepository.addCourse(name, isActive, numberOfHours, departmentId));
    }

    public CourseDTO updateCourseById(int id, String name, boolean isActive, int numberOfHours, int departmentId) {
        return new CourseDTO(courseRepository.updateCourseById(id, name, isActive, numberOfHours, departmentId));
    }

    public CourseDTO deleteCourseById(int id) {
        return new CourseDTO(courseRepository.deleteCourseById(id));
    }

    public CourseDTO deleteCourseByName(String name) {
        return new CourseDTO(courseRepository.deleteCourseByName(name));
    }
}
