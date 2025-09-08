package pageUIs;

public class ProductDetailsPageUI {
    public static final String productDetailsPage_Title = "xpath=//h1//span[@data-ui-id='page-title-wrapper']";
    public static final String productDetailsPage_Size = "xpath=//div[@aria-label='Size']//input[@aria-label='%s']/ancestor::label";
    public static final String productDetailsPage_Color = "xpath=//div[@aria-label='Color']//input[@aria-label='%s']/ancestor::label";
    public static final String productDetailsPage_Qty = "xpath=//input[@name='qty']";
    public static final String productDetailsPage_addToCart = "xpath=//button[@id='product-addtocart-button']";
    public static final String productDetailsPage_messageSuccess = "xpath=//div[@class='message success']";
    public static final String productDetailsPage_QtyInCart = "xpath=//span[@x-text='cart.summary_count']";
}
