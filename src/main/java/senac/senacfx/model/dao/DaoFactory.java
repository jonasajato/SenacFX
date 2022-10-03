package senac.senacfx.model.dao;

import senac.senacfx.db.DB;
import senac.senacfx.model.dao.impl.DepartmentDaoJDBC;
import senac.senacfx.model.dao.impl.FabricDaoJDBC;

public class DaoFactory {

    public static FabricDao createSellerDao(){
        return new FabricDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao(){
        return new DepartmentDaoJDBC(DB.getConnection());
    }

}
