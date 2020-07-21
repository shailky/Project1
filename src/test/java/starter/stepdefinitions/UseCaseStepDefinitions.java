package starter.stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import static org.junit.Assert.*;

    public class UseCaseStepDefinitions {

        @Steps
        UseCaseSteps useCaseSteps;

        @Given("^I am on Home page$")
        public void iAmOnHomePage() throws Throwable {

            useCaseSteps.open();
            throw new PendingException();
        }

        @And("^I navigate to popular items section$")
        public void iNavigateToPopularItemsSection() throws Throwable {

            useCaseSteps.navigateToPopularSection();
        }

        @And("^I add the element with lowest price \"([^\"]*)\" into the cart$")
        public void iAddTheElementWithLowestPriceIntoTheCart(String arg0) throws Throwable {

            useCaseSteps.addElementWithLowestPriceToCartAndNoteItsName(arg0);
            throw new PendingException();
        }

        @When("^I navigate to the cart$")
        public void iNavigateToTheCart() throws Throwable {
            useCaseSteps.navigateToTheCart();
        }

        @Then("^I verify that \"([^\"]*)\" should be successfully added to the cart$")
        public void iVerifyThatShouldBeSuccessfullyAddedToTheCart(String arg0) throws Throwable {

            assertTrue(useCaseSteps.verifyItemIsAddedSuccessfullyToTheCart(arg0));
        }

        @Then("^I verify the count of discounted items as \"([^\"]*)\" on Home page$")
        public void iVerifyTheCountOfDiscountedItems(String count) {

            useCaseSteps.verifyTheCountOfDiscountedItems(count);
        }

        @And("^I verify the discounted value is correct$")
        public void iVerifyDiscountedValueIsCorrect(){

            assertTrue(useCaseSteps.verifyDiscountedValueIsCorrect());
        }

    }

