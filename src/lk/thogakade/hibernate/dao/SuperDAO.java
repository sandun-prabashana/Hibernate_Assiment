package lk.thogakade.hibernate.dao;

import javafx.collections.ObservableList;
import lk.thogakade.hibernate.dto.CustomerDTO;
import lk.thogakade.hibernate.entity.Customer;
import lk.thogakade.hibernate.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

public interface SuperDAO <Entity extends SuperEntity,ID extends Serializable>{
    public boolean add(Entity entity)throws Exception;

    public boolean delete(Entity entity)throws Exception;

    public boolean update(Entity entity)throws Exception;

    public Entity find(Entity entity, String id)throws Exception;

    public ObservableList<Customer> findAll()throws Exception;
}