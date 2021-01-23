package lk.thogakade.hibernate.bo.custom.impl;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.thogakade.hibernate.bo.custom.CustomerBO;
import lk.thogakade.hibernate.dao.DAOFactry;
import lk.thogakade.hibernate.dao.custom.CustomerDAO;
import lk.thogakade.hibernate.dto.CustomerDTO;
import lk.thogakade.hibernate.entity.Customer;

import javax.swing.text.html.parser.Entity;


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
    public CustomerDTO searchCustomer(CustomerDTO customer, String id) throws Exception {
//        Customer cus=customerDAO.find(customer,id);
//        return new Customer(customer.getId(),customer.getName(),customer.getAddress(),
//                customer.getDOB(),customer.getPhone_No(),customer.getSalary(),customer.getProvince());

        return customer;
    }

    @Override
    public ObservableList<CustomerDTO> getCustomer() throws Exception {
        ObservableList<Customer>list=customerDAO.findAll();
        ObservableList<CustomerDTO> studentList= FXCollections.observableArrayList();
        for(Customer l: list){
            studentList.add(new CustomerDTO(l.getId(),l.getName(),l.getAddress(),l.getDOB(),l.getPhone_No()
            ,l.getSalary(),l.getProvince()));
        }
        return studentList;
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


}
