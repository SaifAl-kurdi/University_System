package department.repository;

import department.model.DepartmentModel;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class DepartmentRepository {

    @Inject
    EntityManager entityManager;

    public List<DepartmentModel> getAllDepartment() {
        return entityManager.createQuery("select d from DepartmentModel d", DepartmentModel.class).getResultList();
    }

    public DepartmentModel getDepartmentById(int id) {
        return entityManager.find(DepartmentModel.class, id);
    }

    public DepartmentModel addDepartment(int id, String name) {
        DepartmentModel departmentModel = new DepartmentModel();
        departmentModel.setId(id);
        departmentModel.setName(name);
        entityManager.persist(departmentModel);
        return departmentModel;
    }

    public DepartmentModel updateDepartment(int id, String name) {
        DepartmentModel departmentModel = getDepartmentById(id);
        departmentModel.setName(name);
        entityManager.merge(departmentModel);
        return departmentModel;
    }

    public DepartmentModel deleteDepartmentById(int id) {
        DepartmentModel departmentModel = getDepartmentById(id);
        entityManager.remove(departmentModel);
        return departmentModel;
    }
}
