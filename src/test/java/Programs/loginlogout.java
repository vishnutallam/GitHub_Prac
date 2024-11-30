package Programs;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginlogout {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://tradeoxy.com");
            driver.manage().window().maximize();

            // Verify navigation to signin
            driver.findElement(By.xpath("//div[@class='flex gap-7 justify-between items-center text-base font-medium text-neutral-400 max-md:flex-wrap max-lg:hidden']//a[3]")).click();//signin
            Thread.sleep(3000);
            String currentUrl = driver.getCurrentUrl();
            System.out.println(driver.getCurrentUrl());
            if (currentUrl.contains("https://tradeoxy.com/signin/")) {
                System.out.println("Signin navigation passed!");
            } else {
                System.out.println("Signin navigation failed!");
            }

            // Verify email navigation
            driver.findElement(By.xpath("//div[@class='flex flex-col items-center gap-7 w-6/12 max-md:w-8/12 max-sm:w-9/12']//div[3]")).click();//email link
            Thread.sleep(3000);


            currentUrl = driver.getCurrentUrl();
            System.out.println(driver.getCurrentUrl());
            if (currentUrl.contains("https://tradeoxy.com/signin/?email=true")) {
                System.out.println("Email navigation passed!");
            } else {
                System.out.println("Email navigation failed!");
            }

            // Verify login
            driver.findElement(By.xpath("(//div[@class='flex flex-col relative flex-1 gap-1'])[1]//input")).sendKeys("automationvishnupriya@gmail.com");//eamil
            driver.findElement(By.xpath("(//div[@class='flex flex-col relative flex-1 gap-1'])[2]//input")).sendKeys("Trade@12");//password
            driver.findElement(By.xpath("//div[@class='h-max flex flex-col gap-y-5 w-7/12 max-md:w-10/12 max-sm:w-11/12']//button")).click();//sign in
            Thread.sleep(3000);
            WebElement  success= driver.findElement(By.xpath("//html/body/div[1]/div/div[1]/div/div/div[contains(text(), \"Logged in successfully\")]"));
            JavascriptExecutor js= (JavascriptExecutor)driver;
            String successmsg = (String) js.executeScript("return arguments[0].innerText;", success);
            System.out.println("Text of the element: " + successmsg);


            if (successmsg.contains("Logged in successfully")) {
                System.out.println("Login passed!");
            } else {
                System.out.println("Login failed!");
            }
// Verify logout
            driver.findElement(By.xpath("//div[@class='flex gap-7 justify-between items-center text-base font-medium text-neutral-400 max-md:flex-wrap max-lg:hidden']//button")).click();//profile
            System.out.println("clicked on profile");
            driver.findElement(By.xpath("//p[normalize-space()='Log out']")).click();//logout
            System.out.println("clicked on logout");
            driver.findElement(By.xpath("//span[normalize-space()='Logout']")).click();//window logout
            Thread.sleep(3000);

        } catch (Exception e) {
            System.out.println("Test encountered an error: " + e.getMessage());
        } finally {

            driver.quit();
        }

    }
}
