package department.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "Department")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentModel {
    @Id
    private int id;
    private String name;
}
