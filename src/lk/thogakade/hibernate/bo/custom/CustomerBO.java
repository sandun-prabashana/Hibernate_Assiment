package lk.thogakade.hibernate.bo.custom;

import javafx.collections.ObservableList;
import lk.thogakade.hibernate.bo.SuperBO;
import lk.thogakade.hibernate.dto.CustomerDTO;

import java.util.List;


public interface CustomerBO extends SuperBO {
    public boolean addCustomer(CustomerDTO customer)throws Exception;

    boolean deleteCustomer(CustomerDTO customer)throws Exception;

    boolean updateCustomer(CustomerDTO customer)throws Exception;


    String newCustomerID() throws Exception;

    CustomerDTO searchCustomer(String id)throws Exception;

    List<CustomerDTO> findall()throws Exception;
}
