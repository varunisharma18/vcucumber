package externalxpath;

public class AmazonXpath 
{
	// login
	public static final String signin = "//*[text() = 'Hello, sign in']";
	public static final String userid2 = "//*[@id=\"ap_email_login\"]";
	public static final String userid ="//*[@id=\"ap_email\"]";
	public static final String ctnbtn = "//*[@id=\"continue\"]";
	public static final String err1 = "//*[@id=\"auth-email-invalid-claim-alert\"]/div/div";
	//public static final String password = "//*[@id=\"ap_password\"]";
	public static final String password = "//*[@id=\"ap_password\"]";
	public static final String submit = "//*[@id=\"signInSubmit\"]";
	public static final String err2 = "//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span";
	
	// search product
	public static final String searchbox = "//*[@id=\"twotabsearchtextbox\"]";
	
	// multiple products
	public static final String productlinks = "//*[@class = 'a-size-base-plus a-color-base a-text-normal']";
    public static final String pricelist = "//*[@class = 'a-price-whole']";
    
    public static final String addtokartbtn = "//*[@id=\"add-to-cart-button\"]";

}
