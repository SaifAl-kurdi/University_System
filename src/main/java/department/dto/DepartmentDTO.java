package department.dto;

import department.model.DepartmentModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class DepartmentDTO {

    private int id;
    private String name;

    public DepartmentDTO(DepartmentModel departmentModel) {
        this.id = departmentModel.getId();
        this.name = departmentModel.getName();
    }
}
