package pages.admin.userPageComponents;

import javafx.geometry.Side;
import org.openqa.selenium.WebDriver;
import java.util.*;

public class SideBar {
    private WebDriver driver;

    public static List<String>  ids = Arrays.asList(
            "tab-AdminDashboard",
            "subtab-AdminParentOrders",
            "subtab-AdminCatalog",
            "subtab-AdminParentCustomer",
            "subtab-AdminParentCustomerThreads",
            "subtab-AdminStats",
            "subtab-AdminParentModulesSf",
            "subtab-AdminParentThemes",
            "subtab-AdminParentShipping",
            "subtab-AdminParentPayment",
            "subtab-AdminInternational",
            "subtab-ShopParameters",
            "subtab-AdminAdvancedParameters"
        );

    public List<SideBarItem> items;

    public SideBar(WebDriver driver){
        this.driver = driver;
        items = new ArrayList<>();
        for (String id : ids){
            items.add(new SideBarItem(driver, id));
        }
    }

    public SideBarItem GetSideBarItem(String id){
        SideBarItem item = items.stream().filter(x -> Objects.equals(x.getId(), id)).findFirst().orElse(null);
        return item;
    }
}
