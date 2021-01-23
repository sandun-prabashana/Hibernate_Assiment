package lk.thogakade.hibernate.bo.custom;

import javafx.collections.ObservableList;
import lk.thogakade.hibernate.bo.SuperBO;
import lk.thogakade.hibernate.dto.CustomerDTO;


public interface CustomerBO extends SuperBO {
    public boolean addCustomer(CustomerDTO customer)throws Exception;

    boolean deleteCustomer(CustomerDTO customer)throws Exception;

    boolean updateCustomer(CustomerDTO customer)throws Exception;

    CustomerDTO searchCustomer(CustomerDTO customer, String id)throws Exception;

    ObservableList<CustomerDTO> getCustomer()throws Exception;

    String newCustomerID() throws Exception;
}
