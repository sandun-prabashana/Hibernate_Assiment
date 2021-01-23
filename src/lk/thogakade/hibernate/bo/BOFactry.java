package lk.thogakade.hibernate.bo;


import lk.thogakade.hibernate.bo.custom.impl.CustomerBOImpl;

public class BOFactry {

    private static BOFactry boFactry;

    private BOFactry(){

    }

    public static BOFactry getInstance(){
        if(boFactry==null){
            boFactry=new BOFactry();
        }
        return boFactry;
    }

    public enum BOTypes{
        CUSTOMER
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBOImpl();

            default:
                return null;
        }
    }
}
