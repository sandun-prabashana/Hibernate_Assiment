package lk.thogakade.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.thogakade.hibernate.bo.BOFactry;
import lk.thogakade.hibernate.bo.custom.CustomerBO;
import lk.thogakade.hibernate.bo.custom.impl.CustomerBOImpl;
import lk.thogakade.hibernate.dto.CustomerDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class customerformcontroller implements Initializable {
    public JFXTextField txtid;
    public JFXTextField txtname;
    public JFXTextField txtaddress;
    public JFXTextField txtdob;
    public JFXTextField txtno;
    public JFXTextField txtsalary;
    public JFXTextField txtprovince;
    public JFXButton btnAdd;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;

    @FXML
    private TableView<CustomerDTO> tblcustomer;
    @FXML
    private TableColumn<CustomerDTO,String> tblid;

    @FXML
    private TableColumn<CustomerDTO,String> tblname;

    @FXML
    private TableColumn<CustomerDTO,String> tbladdress;

    @FXML
    private TableColumn<CustomerDTO,String> tbldob;

    @FXML
    private TableColumn<CustomerDTO,String> tblno;

    @FXML
    private TableColumn<CustomerDTO,String> tblsalary;

    @FXML
    private TableColumn<CustomerDTO,String> tblprovince;


    static CustomerBO customerBO = (CustomerBO) BOFactry.getInstance().getBO(BOFactry.BOTypes.CUSTOMER);

    private ObservableList<CustomerDTO> rows= FXCollections.observableArrayList();

    public void btnAddOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();
        String name = txtname.getText();
        String address = txtaddress.getText();
        String dob=txtdob.getText();
        String no=txtno.getText();
        String salary=txtsalary.getText();
        String province=txtprovince.getText();

        CustomerDTO customer = new CustomerDTO(id, name, address,dob,no,salary,province);


        try {
            boolean added = customerBO.addCustomer(customer);

            if(added){
                new Alert(Alert.AlertType.CONFIRMATION,"OK").showAndWait();
            }

            txtid.clear();
            txtname.clear();
            txtaddress.clear();
            txtprovince.clear();
            txtno.clear();
            txtsalary.clear();
            txtdob.clear();
            generateID();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();
        String name = txtname.getText();
        String address = txtaddress.getText();
        String dob=txtdob.getText();
        String no=txtno.getText();
        String salary=txtsalary.getText();
        String province=txtprovince.getText();

        CustomerDTO customer = new CustomerDTO(id, name, address,dob,no,salary,province);
        boolean added= false;

        try {
             added = customerBO.updateCustomer(customer);

            if(added){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Update Succcesfull").showAndWait();
            }else {
                new Alert(Alert.AlertType.WARNING,"Fail",ButtonType.OK).show();
            }

            txtid.clear();
            txtname.clear();
            txtaddress.clear();
            txtprovince.clear();
            txtno.clear();
            txtsalary.clear();
            txtdob.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = txtid.getText();
        String name = txtname.getText();
        String address = txtaddress.getText();
        String dob=txtdob.getText();
        String no=txtno.getText();
        String salary=txtsalary.getText();
        String province=txtprovince.getText();

        CustomerDTO customer = new CustomerDTO(id, name, address,dob,no,salary,province);
        boolean added= false;

        try {
            added = customerBO.deleteCustomer(customer);

            if(added){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Remove Succcesfull").showAndWait();
            }else {
                new Alert(Alert.AlertType.WARNING,"Fail",ButtonType.OK).show();
            }

            txtid.clear();
            txtname.clear();
            txtaddress.clear();
            txtprovince.clear();
            txtno.clear();
            txtsalary.clear();
            txtdob.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void txtSearchOnAction(MouseEvent mouseEvent) {
        String id = txtid.getText();
        String name = txtname.getText();
        String address = txtaddress.getText();
        String dob=txtdob.getText();
        String no=txtno.getText();
        String salary=txtsalary.getText();
        String province=txtprovince.getText();

        CustomerDTO customer = new CustomerDTO(id, name, address,dob,no,salary,province);
        try{
            CustomerDTO customerDTO=customerBO.searchCustomer(customer,id);
            if(customerDTO!=null){
//                txtName.setText(studentDTO.getName());
//                txtAddress.setText(studentDTO.getAddress());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void get() {
        try {
            rows=customerBO.getCustomer();

            tblid.setCellValueFactory(new PropertyValueFactory<CustomerDTO,String>("Id"));
            tblname.setCellValueFactory(new PropertyValueFactory<CustomerDTO,String>("Name"));
            tbladdress.setCellValueFactory(new PropertyValueFactory<CustomerDTO,String>("Address"));
            tblcustomer.getItems().clear();
            tblcustomer.setItems(rows);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void generateID(){
        String s = null;
        try {
            s = customerBO.newCustomerID();
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtid.setText(s);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateID();
    }
}
