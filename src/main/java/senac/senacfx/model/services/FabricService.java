package senac.senacfx.model.services;

import senac.senacfx.model.dao.DaoFactory;
import senac.senacfx.model.dao.FabricDao;
import senac.senacfx.model.entities.Fabric;


import java.util.List;

public class FabricService {

    //dependencia injetada usando padrao factory
    private FabricDao dao = DaoFactory.createSellerDao();

    public List<Fabric> findAll() {
        return dao.findAll();

        //Dados MOCK (fake) so para testar, sem puxar do banco por hora
//        List<Fabric> list = new ArrayList<>();
//        list.add(new Fabric(1,"Computadores"));
//        list.add(new Fabric(2,"Alimentação"));
//        list.add(new Fabric(3,"Financeiro"));
//        return list;

    }
    public void saveOrUpdate(Fabric obj){
        if (obj.getId() == null){
            dao.insert(obj);
        } else {
            dao.update(obj);
            }
        }

        public void remove(Fabric obj){
            dao.deleteById(obj.getId());
        }
    }

