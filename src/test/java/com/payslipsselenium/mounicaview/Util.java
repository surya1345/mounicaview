package com.payslipsselenium.mounicaview;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {

public static void clickLinkByHref(WebDriver driver, String href, int position) {
    List<WebElement> anchors = driver.findElements(By.tagName("a"));
    Iterator<WebElement> i = anchors.iterator();
    int j = 0;
    while(i.hasNext()) {
        WebElement anchor = i.next();
        if(anchor.getAttribute("href").contains(href)) {
            j++;
        }
        if(anchor.getAttribute("href").contains(href)
                && j == position) {
        	System.out.println("MMMMMMMMMMMMMM");
            anchor.click();
            break;
        }
    }
}
}
