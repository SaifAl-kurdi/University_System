package course.dto;

import course.model.CourseModel;
import department.dto.DepartmentDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class CourseDTO {
    private String name;
    private boolean isActive;
    private int numberOfHours;
    private DepartmentDTO departmentId;

    public CourseDTO(CourseModel course) {
        this.name = course.getName();
        this.isActive = course.isActive();
        this.numberOfHours = course.getNumberOfHours();

        if (course.getDepartmentId() != null) {
            this.departmentId = new DepartmentDTO(course.getDepartmentId());
        }
    }
}
