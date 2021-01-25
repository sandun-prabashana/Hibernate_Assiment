package lk.thogakade.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer implements SuperEntity {
    @Id
    private String Id;
    private String Name;
    private String Address;
    private String DOB;
    private String Phone_No;
    private String Salary;
    private String Province;

    public Customer(String id, String name, String address, String DOB, String phone_No, String salary, String province) {
        Id = id;
        Name = name;
        Address = address;
        this.DOB = DOB;
        Phone_No = phone_No;
        Salary = salary;
        Province = province;
    }

    public Customer() {

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPhone_No() {
        return Phone_No;
    }

    public void setPhone_No(String phone_No) {
        Phone_No = phone_No;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", DOB='" + DOB + '\'' +
                ", Phone_No='" + Phone_No + '\'' +
                ", Salary='" + Salary + '\'' +
                ", Province='" + Province + '\'' +
                '}';
    }
}