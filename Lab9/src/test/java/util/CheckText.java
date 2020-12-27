package util;

import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckText {
    private static final String NAME_OF_PRODUCT = "Samsung";

    public static boolean wordVerification (List<WebElement> SearchElements, boolean chechName) {
        String name;
        for (int i = 0; i < SearchElements.size(); i++) {
            name = SearchElements.get(i).getText();
            if (!name.contains(NAME_OF_PRODUCT)){chechName=false;};
        }
        return chechName;
    }
}
