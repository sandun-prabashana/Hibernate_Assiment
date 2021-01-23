package lk.thogakade.hibernate.dao;

import lk.thogakade.hibernate.dao.custom.impl.CustomerDAOImpl;

public class DAOFactry {
    private static DAOFactry daoFactry;

    private DAOFactry(){}

    public static DAOFactry getInstance(){
        if(daoFactry==null){
            daoFactry=new DAOFactry();
        }
        return daoFactry;
    }

    public enum DAOType{
        CUSTOMER
    }

    public SuperDAO getDAO (DAOType daoType){
        switch (daoType){
            case CUSTOMER:
                return new CustomerDAOImpl();
            default:
                return null;
        }
    }
}
