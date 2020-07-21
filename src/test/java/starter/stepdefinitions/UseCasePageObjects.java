package starter.stepdefinitions;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UseCasePageObjects {

    @FindBy(css="ul[id='home-page-tabs']>li>a")
    public List<WebElement> tabOnHomePage;

    @FindBy(css="span[itemprop='price'][class='price product-price']")
    public List<WebElement> elementPriceOneHomePage;

    @FindBy(id="add_to_cart")
    public WebElement addToCartButton;

    @FindBy(css="span[title='Continue shopping']")
    public WebElement btn_ContinueShoppingOnPopup;

    @FindBy(css="a[title='View my shopping cart']")
    public WebElement img_ShoppingCart;

    @FindBy(css="p[class='product-name'] a")
    public List<WebElement> lbl_ProductNameOnCartPage;

    String nameOfProductToBeAdded="//span[contains(text(),'REPLACE_TEXT')]//parent::div[@class='content_price']/parent::div[@class='right-block']/h5/a";
    String discountedItems="//ul[@id='homefeatured'] /li/div/div[2]/div[1]/span[@class='price-percent-reduction']";
    String priceBeforeDiscount="//ul[@id='homefeatured'] /li/div/div[2]/div[1]/span[@class='old-price product-price']";
    String priceAfterDiscount="//ul[@id='homefeatured'] /li/div/div[2]/div[1]/span[@class='old-price product-price']/preceding-sibling::span";
}
