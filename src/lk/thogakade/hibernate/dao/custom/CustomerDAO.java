package lk.thogakade.hibernate.dao.custom;

import lk.thogakade.hibernate.dao.SuperDAO;
import lk.thogakade.hibernate.entity.Customer;

import java.sql.SQLException;

public interface CustomerDAO extends SuperDAO<Customer, String> {
    String getLastCustomerID();
}
