package lk.thogakade.hibernate.bo.custom.impl;



import javafx.collections.ObservableList;
import lk.thogakade.hibernate.bo.custom.CustomerBO;
import lk.thogakade.hibernate.dao.DAOFactry;
import lk.thogakade.hibernate.dao.custom.CustomerDAO;
import lk.thogakade.hibernate.dto.CustomerDTO;
import lk.thogakade.hibernate.entity.Customer;

import java.util.ArrayList;
import java.util.List;


public class CustomerBOImpl implements CustomerBO {
    static CustomerDAO customerDAO= (CustomerDAO) DAOFactry.getInstance().getDAO(DAOFactry.DAOType.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.add(new Customer(customer.getId(),
                customer.getName(),
                customer.getAddress(),customer.getDOB(),customer.getPhone_No(),customer.getSalary(),customer.getProvince()));
    }

    @Override
    public boolean deleteCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.delete(new Customer(customer.getId(),
                customer.getName(),
                customer.getAddress(),customer.getDOB(),customer.getPhone_No(),customer.getSalary(),customer.getProvince()));
    }


    @Override
    public boolean updateCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.update(new Customer(customer.getId(),
                customer.getName(),
                customer.getAddress(),customer.getDOB(),customer.getPhone_No(),customer.getSalary(),customer.getProvince()));
    }



    @Override
    public String newCustomerID() throws Exception {
        String lastID = customerDAO.getLastCustomerID();

        int newID = Integer.parseInt(lastID.substring(1, 4)) + 1;

        if(newID == 0){
            return "C001";
        }else if(newID < 10){
            return "C00"+newID;
        }else if(newID < 100){
            return "C0"+newID;
        }else{
            return "C"+newID;
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws Exception {
        Customer cus = customerDAO.search(id);
        return new CustomerDTO(cus.getId(),cus.getName(),cus.getAddress(),cus.getDOB()
        ,cus.getPhone_No(),cus.getSalary(),cus.getProvince());
    }

    @Override
    public List<CustomerDTO> findall() throws Exception {
        List<Customer> all = customerDAO.getAll();
        List<CustomerDTO> list = new ArrayList<>();
        for (Customer c : all) {
            list.add(new CustomerDTO(c.getId(), c.getName(), c.getAddress(),
                    c.getDOB(),c.getPhone_No(),c.getSalary(),c.getProvince()));
        }
        return list;
    }


}
