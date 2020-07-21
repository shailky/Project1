package starter.stepdefinitions;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseSteps extends PageObject {

    @Steps
    UseCasePageObjects useCasePageObjects;

    @Step
    /**
     * Method to click on popular tab displayed on the home page
     */
    public void navigateToPopularSection(){
        for(WebElement webElement:useCasePageObjects.tabOnHomePage){
            if(webElement.getText().equalsIgnoreCase("popular")){
                webElement.click();
            }
        }
    }

    @Step
    /**
     * Method find element with the lowest price and note its name in a session variable and add to cart the product
     */
    public void addElementWithLowestPriceToCartAndNoteItsName(String elementName){

        List<Integer> list = new ArrayList<Integer>();
        for(WebElement webElement:useCasePageObjects.elementPriceOneHomePage){
            String priceValue=webElement.getText().substring(1,webElement.getText().length());
            list.add(Integer.valueOf(priceValue));
        }
        int minimumPrice= Collections.min(list);
        String price=String.valueOf(minimumPrice);
        String locator=useCasePageObjects.nameOfProductToBeAdded.replace("REPLACE_TEXT",price);
        WebElement actualElementName=find(By.xpath(locator));
        actualElementName.click();
        useCasePageObjects.addToCartButton.click();
        useCasePageObjects.btn_ContinueShoppingOnPopup.click();
        Serenity.setSessionVariable(elementName).to(actualElementName.getText());
    }

    @Step
    /**
     * Method to click on the cart icon
     */
    public void navigateToTheCart(){

        useCasePageObjects.img_ShoppingCart.click();
    }

    @Step
    /**
     * Method returns true if item added in the previous steps is successfully displayed in the cart
     */
    public boolean verifyItemIsAddedSuccessfullyToTheCart(String itemName){
        boolean flag=false;
        String actualitemName=Serenity.sessionVariableCalled(itemName).toString();
        for(WebElement webElement:useCasePageObjects.lbl_ProductNameOnCartPage){
            if(webElement.getText().equalsIgnoreCase(actualitemName)){
                flag=true;
            }
            if(!flag){
                break;
            }
        }
        return flag;
    }

    @Step
    /**
     * Method counts the discounted items displayed on the home page and note the count in a session variable
     */
    public void verifyTheCountOfDiscountedItems(String count){

        List<WebElement> discountedItems=getDriver().findElements(By.xpath(useCasePageObjects.discountedItems));
        Serenity.setSessionVariable(count).to(discountedItems.size());
    }

    @Step
    /**
     * Method verifies that discount is calculated properly and actual value is reflected as per the discount
     */
    public boolean verifyDiscountedValueIsCorrect(){
        boolean flag=false;
        List<WebElement> discountList=getDriver().findElements(By.xpath(useCasePageObjects.discountedItems));
        List<WebElement> priceBeforeDiscount=getDriver().findElements(By.xpath(useCasePageObjects.priceBeforeDiscount));
        List<WebElement> priceAfterDiscount=getDriver().findElements(By.xpath(useCasePageObjects.priceAfterDiscount));
        for(int i=0;i<priceAfterDiscount.size();i++){
            String original=priceBeforeDiscount.get(i).getText().substring(1,priceBeforeDiscount.get(i).getText().length());
            String after=priceAfterDiscount.get(i).getText().substring(1,priceAfterDiscount.get(i).getText().length());
            String discount=discountList.get(i).getText().substring(1,discountList.get(i).getText().length());
            int actualDiscount=(((Integer.parseInt(original))-(Integer.parseInt(after)))/Integer.parseInt(original))*100;
            if(String.valueOf(actualDiscount).equalsIgnoreCase(discount)){
                flag=true;
            }
        }
        return flag;
    }


}
