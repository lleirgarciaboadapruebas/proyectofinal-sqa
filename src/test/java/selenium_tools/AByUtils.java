package selenium_tools;

import org.openqa.selenium.By;

/**
 * Created by lleir on 25/6/17.
 */
public class AByUtils {
    // normal gettere drivers

    public By byId(String id){
        return By.id(id);
    }

    public By byIdContains(String id){
        return By.cssSelector("*[id*='"+ id +"']");
    }

    public By byCss(String css){
        return By.cssSelector(css);
    }

    public By byValue(String value){
        return By.cssSelector("*[value='"+ value + "'");
    }

    public By byTagname(String tag){
        return By.tagName(tag);
    }

    public By byClass(String clas){
        return By.className(clas);
    }

    public By byLinkText(String linktext){
        return By.linkText(linktext);
    }

    public By byPartialLinkText(String linktext){
        return By.partialLinkText(linktext);
    }

    // xpath getter driver

    public By byTagnameAndId(String tagname, String id){
        return By.xpath("//"+tagname+"[@id, '"+id+"']");
    }

    public By byTagnameAndClass(String tagname, String clas){
        return By.xpath("//"+tagname+"[@class, '"+clas+"']");
    }

    public By byTagnameAndIdContains(String tagname, String id){
        return By.xpath("//"+tagname+"[contains(@id, '"+id+"')]");
    }

    public By byTagnameAndContainsClass(String tagname, String clas){
        return By.xpath("//"+tagname+"[contains(@class, '"+clas+"')]");
    }

    public By byTagnameAndValue(String tagname, String value){
        return By.xpath("//"+tagname+"[@value, '"+value+"']");
    }

}
