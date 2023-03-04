package features;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import javafx.scene.control.TableView;
import org.testfx.api.FxRobot;
import stu.najah.se.sql.entity.CustomerEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditCustomerSteps extends FxRobot {

    private final TableView<CustomerEntity> tableCustomers
             = lookup("#tableCustomers").queryTableView();

    @And("customers panel is opened")
    public void customersPanelIsOpened() {
        clickOn("#tabCustomers");
    }

    @And("edit customer tab is opened")
    public void addCustomerTabIsOpened() {
        clickOn("#tabEditCustomer");
    }

    @Given("I enter a customer name, phone, address")
    public void iEnterACustomerNamePhoneAddress() {
        clickOn("#textFieldName");
        write("some name");
        clickOn("#textFieldPhone");
        write("0123456789");
        clickOn("#textFieldAddress");
        write("some address");
    }

    @And("the name is not empty")
    public void theNameIsNotEmpty() {
        // 'some name' is not an empty string
    }

    @And("I click add customer button")
    public void iClickAddCustomerButton() {
        clickOn("#buttonCreateCustomer");
    }

    @Then("a new customer is added to the list")
    public void aNewCustomerIsAddedToTheList() {
        int rowIndex = -1;
        for (int i = 0; i < tableCustomers.getItems().size(); i++) {
            if (tableCustomers.getItems().get(i).getName().equals("some name")) {
                rowIndex = i;
                break;
            }
        }
        assertTrue(rowIndex != -1);
    }

    @Given("I select a customer from the list")
    public void iSelectACustomerFromTheList() {
        for (int i = 0; i < tableCustomers.getItems().size(); i++) {
            if (tableCustomers.getItems().get(i).getName().equals("some name")) {
                tableCustomers.getSelectionModel().clearAndSelect(i);
                break;
            }
        }
    }

    @And("I enter a different customer information")
    public void iEnterADifferentCustomerInformation() {
        clickOn("#textFieldAddress");
        eraseText("some address".length());
        write("different address");
    }

    @And("I click update customer button")
    public void iClickUpdateCustomerButton() {
        clickOn("#buttonUpdateCustomer");
    }

    @Then("the selected customer is updated")
    public void theSelectedCustomerIsUpdated() {
        for (int i = 0; i < tableCustomers.getItems().size(); i++) {
            if (tableCustomers.getItems().get(i).getName().equals("some name")) {
                assertEquals("0123456789", tableCustomers.getItems().get(i).getPhone());
                assertEquals("different address", tableCustomers.getItems().get(i).getAddress());
                break;
            }
        }
    }

    @And("I click delete customer button")
    public void iClickDeleteCustomerButton() {
        clickOn("#buttonDeleteCustomer");
    }

    @Then("the selected customer is deleted")
    public void theSelectedCustomerIsDeleted() {
        int rowIndex = -1;
        for (int i = 0; i < tableCustomers.getItems().size(); i++) {
            if (tableCustomers.getItems().get(i).getName().equals("some name")) {
                rowIndex = i;
                break;
            }
        }
        assertEquals(-1, rowIndex);
    }
}