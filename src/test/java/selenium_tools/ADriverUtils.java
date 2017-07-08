package selenium_tools;

import global_utils.GenericUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.List;

/**
 * Created by lleir on 25/6/17.
 */
public class ADriverUtils {

    /** **************************************************************************************** Busqueda de elementos en pantalla. */
    private AByUtils byUtils = new AByUtils();
    private static WebDriverWait wait = ABaseTestCase.getWebDriverWait();


    private GenericUtils genericUtils = new GenericUtils(this);
    private TablaUtils tablaUtils = new TablaUtils(this);

    public GenericUtils getGenericUtils(){
        return genericUtils;
    }

    public TablaUtils getTablaUtils(){
        return tablaUtils;
    }

    @Before
    public void ini(){
        byUtils = new AByUtils();
        wait = ABaseTestCase.getWebDriverWait();
    }

    public WebDriverWait getWait(){
        if(wait == null)
            wait = ABaseTestCase.getWebDriverWait();
        return wait;
    }

    public AByUtils getByUtils() {
        return this.byUtils;
    }

    /** Busca un elemento segun atributo id. */
    public WebElement findElementById(String id){
        return findElement(byUtils.byId(id));
    }

    /** Busca un elemento web segun patron css. */
    public WebElement findElementByCss(String css){
        return findElement(byUtils.byCss(css));
    }

    /** Busca un elemento web segun etiqueta "tag". */
    public WebElement findElementByTagname(String tagname){
        return findElement(byUtils.byTagname(tagname));
    }

    /** Busca un elemento web segun el atributo clase. */
    public WebElement findElementByClass(String clas){
        return findElement(byUtils.byClass(clas));
    }

    public List<WebElement> findElements(By by){
        return ABaseTestCase.getWebDriver().findElements(by);
    }

    public List<WebElement> findElements(WebElement webelement, By by){
        return webelement.findElements(by);
    }

    /** Busca varios elements web segun un patron css. */
    public List<WebElement> findElementsByCss(String css){
        return findElements(byUtils.byCss(css));
    }

    /** Busca varios elements web segun una clase. */
    public List<WebElement> findElementsByClass(String clas){
        return findElements(byUtils.byClass(clas));
    }

    public List<WebElement> findElementsById(String id){
        return findElements(byUtils.byId(id));
    }

    public List<WebElement> findElementsByIdContains(String tagname, String id){
        return findElements(By.xpath("//"+tagname+"[contains(@id, '"+id+"')]"));
    }


    /** Busca varios elementos web segun una etiqueta. */
    public List<WebElement> findElementsByTagname(String tagname){
        return findElements(byUtils.byTagname(tagname));
    }

    public WebElement findElement(By by) {
        return ABaseTestCase.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement findElement(WebElement webelement) {
        return ABaseTestCase.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webelement));
    }

    public WebElement findElement(WebElement webelement, By by){
        return ABaseTestCase.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webelement)).findElement(by);
    }

    public WebElement findElementByCss(WebElement webelement, String css) {
        return ABaseTestCase.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webelement)).findElement(getByUtils().byCss(css));
    }

    /** Busca un elemento segun etiqueta y atributo  id. */
    public WebElement findElementById(String tagname, String id){
        return findElement(byUtils.byTagnameAndId(tagname, id));
    }

    /** Busca un elemento segun etiqueta y atributo id contiene id esperado. */
    public WebElement findElementContainsId(String tagname, String id){
        return findElement(byUtils.byTagnameAndIdContains(tagname, id));
    }

    /** Busca un elemento segun etiqueta y atributo  clas. */
    public WebElement findElementByClass(String tagname, String clas){
        return findElement(byUtils.byTagnameAndClass(tagname, clas));
    }

    /** Busca un elemento segun etiqueta y atributo class contiene clas esperada. */
    public WebElement findElementContainsClass(String tagname, String clas){
        return findElement(byUtils.byTagnameAndContainsClass(tagname, clas));
    }



    // ver para que sirve esto! tiene pinta de que cambia de pest�a al abrir el CRM
    private void switchToFrame(String frameId) {
        ABaseTestCase.getWebDriver().switchTo().parentFrame();
        ABaseTestCase.getWebDriver().switchTo().frame("CRMApplicationFrame");
        ABaseTestCase.getWebDriver().switchTo().frame(frameId);
    }

    /** **************************************************************************************** Clicks en elemento web segun patron. */

    /** Hace click segun atributo id. */
    public void clickById(String id){
        click(byUtils.byId(id));
    }

    public void clickByContainsId(String id){
        click(byUtils.byCss("*[id*="+id+"]"));
    }

    public void clickButtonById(String id){
        click(byUtils.byTagnameAndId("button", id));
    }

    public void clickButtonByContainsId(String id){
        click(byUtils.byCss("button[id*='"+ id +"']"));
    }

    public void clickDivByContainsId(String id){
        click(byUtils.byTagnameAndIdContains("div", id));
    }

    public void clickImgById(String id){
        click(byUtils.byTagnameAndId("img", id));
    }

    public void clickImgByContainsId(String id){
        click(byUtils.byTagnameAndIdContains("img", id));
    }

    public void clickSpanById(String id){
        click(byUtils.byTagnameAndId("span", id));
    }

    public void clickSpanByIdContains(String id){
        click(byUtils.byTagnameAndIdContains("span", id));
    }

    /** Hace click segun etiqueta y atributo id. */
    public void clickById(String tagname, String id){
        click(byUtils.byTagnameAndId(tagname, id));
    }

    public void clickByIdContains(String tagname, String id){
        click(byUtils.byTagnameAndIdContains(tagname, id));
    }

    /** Hace click segun atributo class. */
    public void clickByClass(String clas){
        click(byUtils.byClass(clas));
    }

    /** Hace click segun etiqueta y atributo class. */
    public void clickByClass(String tagname, String clas){
        click(byUtils.byTagnameAndClass(tagname, clas));
    }

    /** Hace click segun patron css. */
    public void clickByCss(String css){
        click(byUtils.byCss(css));
    }

    public void clickByLinkText(String linktext){
        click(byUtils.byLinkText(linktext));
    }

    public void clickByLinkTextPartial(String linktext){
        click(byUtils.byPartialLinkText(linktext));
    }

    public void clickWebElement(WebElement e){
        e.click();
    }

    public void clickWebELement(WebElement e, By by) {
        e.findElement(by);
    }

    private static void click(By by){
        ABaseTestCase.getWebDriver().findElement(by).click();
    }


    /** **************************************************************************************** Introduccion de datos en pantalla. */

    /** Busca un <input> segun su atributo ID, limpia su valor y introduce la cadena de texto. */
    public void introDatosInputById(String id, String cadenaTexto){
        introDatosInput(byUtils.byId(id), cadenaTexto);
    }

    public void introDatosInputContainsById(String id, String cadenaTexto){
        introDatosInput(byUtils.byCss("*[id="+id+"]"), cadenaTexto);
    }

    public void introDatosInputByClass(String clas, String cadenaTexto){
        introDatosInput(byUtils.byClass(clas), cadenaTexto);
    }

    public void introDatosInputByContainsId(String id, String cadenaTexto){
        introDatosInput(byUtils.byTagnameAndIdContains("input", id), cadenaTexto);
    }

    /** Busca un <input> segun un patron CSS, limpia su valor y introduce la cadena de texto. */
    public void introDatosInputByCss(String css, String cadenaTexto){
        introDatosInput(byUtils.byCss(css), cadenaTexto);
    }

    public void introDatosInputByName(String name, String cadenaTexto){
        introDatosInput(byUtils.byName(name), cadenaTexto);
    }

    private void introDatosInput(By by, String cadenaTexto){
        findElement(by).clear();
        findElement(by).sendKeys(cadenaTexto);
    }


    /** ****************************************************************************************  Busca elementos selects y selecciona. */

    /** Select <option> segun atributo id. */
    public void selecTextById(String id, String text){
        Select s = new Select(findElementById(id));
        s.selectByVisibleText(text);
    }

    public void selectTextByContainsId(String id, String text){
        Select s = new Select(findElementByCss("select[id*=\"" + id + "\"]"));
        s.selectByVisibleText(text);
    }

    /** Select <option> segun atributo class. */
    public void selecTextByClass(String clas, String text){
        Select s = new Select(findElementByClass(clas));
        s.selectByVisibleText(text);
    }

    /** Select <option> segun patron css. */
    public void selecTextByCss(String css, String text){
        Select s = new Select(findElementByCss(css));
        s.selectByVisibleText(text);
    }

    /** **************************************************************************************** Recogida de datos desde pantalla. */

    /** Busca el elemento @id y devuelve el texto. */
    public String getTextoById(String id){
        return findElement(byUtils.byId(id)).getText();
    }

    /** Busca el elemento que contenga el @id y devuelve el texto. */
    public String getTextoByContainsId(String id){
        return findElement(byUtils.byIdContains(id)).getText();
    }

    /** Busca el elemento con la class @clas y devuelve el texto. */
    public String getTextoByClass(String clas){
        return findElementByClass(clas).getText();
    }

    /** Busca el elemento <input> que contenga el @id y devuelve el value. */
    public String getSpanTextoByContainsId(String id){
        return findElement(byUtils.byTagnameAndIdContains("span", id)).getAttribute("value");
    }

    /** Busca el elemento con el patron @css. y devuelve el texto. */
    public String getTextoByCss(String css){
        return findElement(byUtils.byCss(css)).getText();
    }

    /** Busca el elemento @id y devuelve el value. */
    public String getValueById(String id){
        return findElement(byUtils.byId(id)).getAttribute("value");
    }

    /** Busca el elemento <input> que contenga el @id y devuelve el value. */
    public String getInputValueByContainsId(String id){
        return findElement(byUtils.byTagnameAndIdContains("input", id)).getAttribute("value");
    }

    /** Busca el elemento <span> que contenga el @id y devuelve el value. */
    public String getSpanTextValueByContainsId(String id){
        return findElement(byUtils.byTagnameAndIdContains("span", id)).getText();
    }

    /** Busca el elemento con el patron @css. y devuelve el value. */
    public String getValueByCss(String css){
        return findElement(byUtils.byCss(css)).getAttribute("value");
    }

    public String getTextoInWebElementByCss(WebElement e, String css){
        return getTextoByWebElement(e, byUtils.byCss(css));
    }

    public String getTextoInWebElementByClass(WebElement e, String clas){
        return getTextoByWebElement(e, byUtils.byClass(clas));
    }

    public String getAtributoById(String id, String atributo){
        return findElement(byUtils.byId(id)).getAttribute(atributo);
    }

    public String getTextoByWebElement(WebElement e, By by){
        return e.findElement(by).getText();
    }

    public String getTextoByWbElement(WebElement e){
        return e.getText();
    }

    public String getValueByWbElement(WebElement e){
        return e.getAttribute("value");
    }

    /** **************************************************************************************** Esperar por elementos en pantalla. */

    /** Espera y mira si un elemento web esta presente en el DOM segun id (presente no significa visible!) */

    public void waitForElementPresentWithId(String id) {
        waitForElementPresentBy(byUtils.byId(id));
    }

    public void waitForElementPresentWithIdContains(String id) {
        waitForElementPresentBy(byUtils.byIdContains(id));
    }

    /** Espera y mira si un elemento web esta presente en el DOM segun css (presente no significa visible!) */
    public void waitForElementPresentWithCss(String css){
        waitForElementPresentBy(byUtils.byCss(css));
    }

    /** Espera y mira si un elemento web esta presente en el DOM segun clas (presente no significa visible!) */
    public void waitForElementPresentWithClass(String clas){
        waitForElementPresentBy(byUtils.byClass(clas));
    }

    /** Espera y mira si un elemento web esta visible en la DOM segun su id (si esta visible significa que estar� presente). */
    public void waitForElementVisibleWithId(String id){
        waitForElementVisibleBy(byUtils.byId(id));
    }

    /** Espera y mira si un elemento web esta visible en la DOM segun su patron css (si esta visible significa que estar� presente). */
    public void waitForElementVisibleWithCss(String css){
        waitForElementVisibleBy(byUtils.byCss(css));
    }

    /** Espera y mira si un elemento web esta visible en la DOM segun su class (si esta visible significa que estar� presente). */
    public void waitForElementVisibleWith(String clas){
        waitForElementVisibleBy(byUtils.byClass(clas));
    }

    public void waitForElementVisibleByIdContains(String tagname, String id){
        waitForElementPresentBy(byUtils.byTagnameAndIdContains(tagname, id));
    }

    public void waitForElementPresentBy(By by){
        ABaseTestCase.getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementVisibleBy(By by){
        ABaseTestCase.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /** Esta el elemento presente. */
    public boolean isElementPresent(By by) {
        try {
            ABaseTestCase.getWebDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /** Esta el elemento visible. */
    public boolean isElementVisible(By by) {
        if(isElementPresent(by)){
            if(ABaseTestCase.getWebDriver().findElement(by).isDisplayed())
                return true;
            else
                return false;
        }
        return false;
    }

    /** Esta el alert javascript presente. */
    public boolean isAlertPresent() {
        try {
            ABaseTestCase.getWebDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    /** Coje el texto y cierra la alerta. */
    public String closeAlertAndGetItsText() {
        try {
            Alert alert = ABaseTestCase.getWebDriver().switchTo().alert();
            String alertText = alert.getText();
            if (ABaseTestCase.getAcceptNextAlert()) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            ABaseTestCase.setAcceptNextAlert(true);
        }
    }

    //FUNCION PARA LA OBTENCION DEL XPATH DEL OBJETO
    public By objectGetId(String id, String tagname) throws Exception {
        return By.xpath("//"+tagname+"[contains(@id, '"+id+"')]");
    }
    //FUNCION PARA LA OBTENCION DE ELEMENTOS LI CON UN DETERMINADO ID
    public List<WebElement> objectsGetElementsId(String id, String tagname) throws Exception {
        return ABaseTestCase.getWebDriver().findElements(By.xpath("//"+tagname+"[contains(@id, '"+id+"')]"));
    }

    //FUNCION DE ESPARA PARA LA RESPUESTA DEL AJAX LOAD
    public void waitForAjaxLoad(String SAPUI_BUSY_INDICATOR) {
        ABaseTestCase.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(SAPUI_BUSY_INDICATOR)));
        ABaseTestCase.getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SAPUI_BUSY_INDICATOR)));
    }

    public void writeLog(String log){
        System.out.println(log);
    }

    public void writeStep(String log){
        writeLog("Step ---- "+ log);
        AlmacenSteps.putStep("step", log);
    }

    public void writeStepValidation(String log) {
        writeLog("Validation ---- " + log);
        AlmacenSteps.putStep("validacion", log);
    }

    public void writeStepProces(String log){
        writeLog("StepProcess ---- "+ log);
    }

    public void writeStepResult(String log){
        writeLog("Result Step ---- "+ log);
    }

    public String getNameMethod(){
        return new Exception().getStackTrace()[1].getMethodName();
    }

    /** **************************************************************************************** Ejecutar javascript. */

    public void ejecutarJavascript(String script){
        if (ABaseTestCase.getWebDriver() instanceof JavascriptExecutor)
            ((JavascriptExecutor)ABaseTestCase.getWebDriver()).executeScript(script);
        else
            throw new IllegalStateException("This driver does not support JavaScript!");

    }



    /** **************************************************************************************** Super utils. */

    public WebElement devolverWebElement(String listSelector, String td1, String td2, String td3, String expect1, String expect2, String expect3) {
        // cojo elementos segun selector css
        List<WebElement> trs = findElementsByCss(listSelector);

        // recorro 
        for (WebElement tr : trs) {
            String it1 = getTextoByWebElement(tr, getByUtils().byCss(td1));
            String it2 = getTextoByWebElement(tr, getByUtils().byCss(td2));
            String it3 = getTextoByWebElement(tr, getByUtils().byCss(td3));

            boolean ok1 = StringUtils.equals(it1, expect1);
            boolean ok2 = StringUtils.equals(it2, expect2);
            boolean ok3 = StringUtils.equals(it3, expect3);

            System.out.println("pos 1: "+ it1 +"'        pos 2: "+ it2 +"        pos 3: "+ it3);
            System.out.println("ex 1: "+ expect1 +"'     ex 2: "+ expect2 +"     ex 3: "+ expect3);
            
            if (ok1 && ok2 && ok3)
                return tr;
        }

        return null;
    }
    
    public String getAlertText(){
    	return ABaseTestCase.getWebDriver().switchTo().alert().getText();
    }
    
    public void acceptarAlert(){
    	ABaseTestCase.getWebDriver().switchTo().alert().accept();
    }
}
