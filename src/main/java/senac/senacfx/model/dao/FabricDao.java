package senac.senacfx.model.dao;

import senac.senacfx.model.entities.Department;
import senac.senacfx.model.entities.Fabric;

import java.util.List;

public interface FabricDao {

    void insert(Fabric obj);
    void update(Fabric obj);


    void deleteById(Integer id);
    Fabric findById(Integer id);
    List<Fabric> findAll();
    List<Fabric> findByDepartment(Department department);

}
