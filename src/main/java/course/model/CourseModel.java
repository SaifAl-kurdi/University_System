package course.model;

import department.model.DepartmentModel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "Course")
@Getter @Setter
public class CourseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private boolean isActive;
    private int numberOfHours;
    @ManyToOne
    @JoinColumn(name = "departmentId")
    private DepartmentModel departmentId;
}
