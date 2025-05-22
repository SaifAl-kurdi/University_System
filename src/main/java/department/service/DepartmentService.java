package department.service;

import department.dto.DepartmentDTO;
import department.model.DepartmentModel;
import department.repository.DepartmentRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class DepartmentService {

    @Inject
    DepartmentRepository departmentRepository;

    public List<DepartmentDTO> getAllDepartment() {
        List<DepartmentModel> departmentModels = departmentRepository.getAllDepartment();
        return departmentModels.stream().map(DepartmentDTO::new).collect(Collectors.toList());
    }

    public DepartmentDTO getDepartmentById(int id) {
        return new DepartmentDTO(departmentRepository.getDepartmentById(id));
    }

    public DepartmentDTO addDepartment(int id, String name) {
        return new DepartmentDTO(departmentRepository.addDepartment(id, name));
    }

    public DepartmentDTO updateDepartment(int id, String name) {
        return new DepartmentDTO(departmentRepository.updateDepartment(id, name));
    }

    public DepartmentDTO deleteDepartmentById(int id) {
        return new DepartmentDTO(departmentRepository.deleteDepartmentById(id));
    }

}
