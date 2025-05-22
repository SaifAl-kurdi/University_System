package course.repository;

import course.model.CourseModel;
import department.model.DepartmentModel;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CourseRepository {

    @Inject
    EntityManager entityManager;

    public List<CourseModel> getAllCourses() {
        return entityManager.createQuery("SELECT c FROM CourseModel c", CourseModel.class).getResultList();
    }

    public CourseModel getCourseById(int id) {
        return entityManager.find(CourseModel.class, id);
    }

    public CourseModel getCoursesByName(String name) {
        return entityManager.createQuery("select c From CourseModel c where c.name = :name", CourseModel.class).setParameter("name", name).getSingleResult();
    }

    public CourseModel addCourse(String name, boolean isActive, int numberOfHours, int departmentId) {
        CourseModel courseModel = new CourseModel();
        courseModel.setName(name);
        courseModel.setActive(isActive);
        courseModel.setNumberOfHours(numberOfHours);

        DepartmentModel departmentModel = entityManager.getReference(DepartmentModel.class, departmentId);
        courseModel.setDepartmentId(departmentModel);

        entityManager.persist(courseModel);
        return courseModel;
    }

    public CourseModel updateCourseById(int id, String name, boolean isActive, int numberOfHours, int departmentId) {
        CourseModel course = getCourseById(id);

        if (name != null) {
            course.setName(name);
        }
        if (isActive) {
            course.setActive(true);
        } else {
            course.setActive(false);
        }

        if (numberOfHours > 0) {
            course.setNumberOfHours(numberOfHours);
        }
        if (departmentId > 0) {
            DepartmentModel department = new DepartmentModel();
            department.setId(departmentId);
        }
        entityManager.merge(course);
        return course;
    }

    public CourseModel deleteCourseById(int id) {
        CourseModel course = getCourseById(id);
        entityManager.remove(course);
        return course;
    }

    public CourseModel deleteCourseByName(String name) {
        CourseModel course = getCoursesByName(name);
        entityManager.remove(course);
        return course;
    }
}
