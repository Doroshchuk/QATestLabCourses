package pages.userPageComponents;

import org.openqa.selenium.WebDriver;
import java.util.*;

public class SideBar {
    private WebDriver driver;

    public List<SideBarItem> items;

    public SideBar(WebDriver driver){
        this.driver = driver;
        items = new ArrayList<SideBarItem>();
        items.add(new SideBarItem(driver, "tab-AdminDashboard"));
        items.add(new SideBarItem(driver, "subtab-AdminParentOrders"));
        items.add(new SideBarItem(driver, "subtab-AdminCatalog"));
        items.add(new SideBarItem(driver, "subtab-AdminParentCustomer"));
        items.add(new SideBarItem(driver, "subtab-AdminParentCustomerThreads"));
        items.add(new SideBarItem(driver, "subtab-AdminStats"));
        items.add(new SideBarItem(driver, "subtab-AdminParentModulesSf"));
        items.add(new SideBarItem(driver, "subtab-AdminParentThemes"));
        items.add(new SideBarItem(driver, "subtab-AdminParentShipping"));
        items.add(new SideBarItem(driver, "subtab-AdminParentPayment"));
        items.add(new SideBarItem(driver, "subtab-AdminInternational"));
        items.add(new SideBarItem(driver, "subtab-ShopParameters"));
        items.add(new SideBarItem(driver, "subtab-AdminAdvancedParameters"));
    }

    public SideBarItem GetSideBarItem(String id){
        SideBarItem item = null;
        for (SideBarItem component: items){
            if (component.getItem().getAttribute("id").equals(id)){
                item =  component;
                break;
            }
        }
        return item;
    }
}
