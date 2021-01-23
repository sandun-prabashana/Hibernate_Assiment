package lk.thogakade.hibernate.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.thogakade.hibernate.dao.custom.CustomerDAO;
import lk.thogakade.hibernate.entity.Customer;
import lk.thogakade.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import javax.swing.text.html.parser.Entity;
import java.sql.ResultSet;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(Customer entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();

        session.close();
        return true;
    }

    @Override
    public boolean delete(Customer entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.delete(entity);

        transaction.commit();

        session.close();
        return true;
    }


    @Override
    public boolean update(Customer entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();

        session.close();
        return true;
    }

    @Override
    public Customer find(Customer entity, String id) throws Exception {
        return null;
    }

    @Override
    public ObservableList<Customer> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        NativeQuery sqlQuery = session.createSQLQuery("select * from Customer");


//        session.createQuery("from Customer");
        transaction.commit();
        ResultSet rst = (ResultSet) sqlQuery.uniqueResult();
        ObservableList<Customer> list = FXCollections.observableArrayList();
        while ((rst==null)) {
            list.add(new Customer(rst.getString("Id"), rst.getString("Name"), rst.getString("Address")
                    , rst.getString("DOB"), rst.getString("Phone_No"), rst.getString("Salary")
                    , rst.getString("Province")));


        }
        session.close();
        return list;
    }

    @Override
    public String getLastCustomerID() {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        NativeQuery sqlQuery = session.createSQLQuery("select id from Customer order by id desc limit 1");
        String id = (String) sqlQuery.uniqueResult();
        transaction.commit();

        session.close();
        return id;
    }

//    @Override
//    public Customer find(CustomerDTO entity, String s) throws Exception {
//        Session session = FactoryConfiguration.getInstance().getSession();
//
//        Transaction transaction = session.beginTransaction();
//
//        session.load(entity,s);
//
//        transaction.commit();
//
//        session.close();
//        return new Customer(entity.getId(),entity.getName(),entity.getAddress(),entity.getDOB(),entity.getPhone_No(),
//                entity.getSalary(),entity.getProvince());
//    }


//    @Override
//    public ObservableList<Entity> findAll() throws Exception {
//        Session session = FactoryConfiguration.getInstance().getSession();
//
//        Transaction transaction = session.beginTransaction();
//
//        NativeQuery sqlQuery = session.createSQLQuery("select * from Customer");
//        String id = (String) sqlQuery.uniqueResult();
//        transaction.commit();
//
//        session.close();
//        ObservableList<Customer> list = FXCollections.observableArrayList();
//        list.forEach(c -> {
//            list.add(new Customer(c.getId(),c.getName(),c.getAddress(),c.getDOB(),
//                    c.getPhone_No(),c.getSalary(),c.getProvince()));
//        });
//        return list;
//    }
}
