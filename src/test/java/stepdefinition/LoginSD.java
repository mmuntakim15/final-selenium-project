package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HomePage;
import framework.webPages.LoginPage;
import org.testng.Assert;

/**
 * Created by mohammadmuntakim.
 */
public class LoginSD {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();

    @Given("^I am on home page$")
    public void iAmOnHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(),
                "Facebook - Log In or Sign Up",
                "Invalid Home Page");
    }

    @When("^I enter (.+) into (username|password|firstname|lastname|mobile number|new password|ssn) text fields on home screen$")
    public void enterDataIntoTextFields(String value, String textFields) {

        switch (textFields) {
            case "username":
                homePage.enterEmail(value);
                break;
            case "password":
                homePage.enterPassword(value);
                break;
            case "firstname":
                homePage.enterFirstName(value);
                break;
            case "lastname":
                homePage.enterLastName(value);
                break;
            case "mobile number":
                homePage.enterMobileNumber(value);
                break;
            case "new password":
                homePage.enterNewPassword(value);
                break;
        }
    }

    @When("^I click on (login|submit) button on home screen$")
    public void clickOnLoginButton(String button) {

        switch (button) {
            case "login":
                homePage.clickOnLoginButton();
                break;
            case "submit":
                //Implement Create account object
                break;
        }
    }

    @Then("^I verify that i am on invalid login page$")
    public void verifyInvalidLoginPage() {
        Assert.assertEquals(loginPage.getPageHeader(), "Log Into Facebook");
    }

    @Then("^I verify invalid signup error message$")
    public void verifySignUpErrorMessage() {
        Assert.assertEquals(homePage.getErrorMessage(), "Invalid signup");
    }

    @Then("^I verify that signup button is disable at homepage$")
    public void verifyDisableSignupButton() {
        Assert.assertFalse(homePage.isSignupButtonEnable(), "Signup button should be disable");
    }

    @Then("^I see number (.+) in text field$")
    public void verifyNumberTextField(String pageNumber) {

    }
}
