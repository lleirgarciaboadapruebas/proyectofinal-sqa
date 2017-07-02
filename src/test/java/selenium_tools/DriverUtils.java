package selenium_tools;

//import static billage.itest.selenium.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DriverUtils extends AByUtils{
//
////    private SelectorUtils s = new SelectorUtils();
//
//    public void writeLog(String log){
//        System.out.println(log);
//    }
//
//    /** ****************************************************************************** Busqueda elementos. */
//
//    public WebElement findElementById(String id){
//       return findElement(byId(id));
//    }
//
//    public WebElement findElementByCss(String css){
//        return findElement(byCss(css));
//    }
//
//    public WebElement findElementByClass(String clas){
//        return findElement(byClass(clas));
//    }
//
//    public WebElement findElementByTagname(String tagname) {
//        return findElement(byTag(tagname));
//    }
//
//    /** El metodo DEVUEVLE un <WebElement> de un WebElement */
//    public WebElement findElement(WebElement e, By by) {
//        if (estaElementoPresenteYVisible(e, by))
//            return e.findElement(by);
//        else
//            return null;
//    }
//
//    /** El metodo DEVUELVE un <WebElement> por un By. */
//    public WebElement findElement(By elemento) {
//        return BaseTest.getDriver().findElement(elemento);                   // AQUI se coge el WEbDriver (mirar mañana en arquia)
//    }
//
//    /** El metodo DEVUELVE un <WebElements> por un By. */
//    public List<WebElement> findElements(By element) {
//        return findElements(element);
//    }
//
//
//    /** el metodo DEVUELVE unos <WebElemenet> de un WebElement */
//    public List<WebElement> findElements(WebElement e, By by) {
//        return e.findElements(by);
//    }
//
//    /** ****************************************************************************** CLick en elementos. */
//
//    /** Click By WebElemenet */
//    public void clickEnElement(WebElement e) {
//        e.click();
//    }
//
//    /** Click By Element in webElement */
//    public void clickEnElementBy(WebElement e, By by) {
//        findElement(e, by).click();
//    }
//
//    /** Click By css */
//    public void clickEnCss(String css) {
//        clickInBy(byCss(css));
//    }
//
//    /** Clik By Href. */
//    public void clickEnHref(String href){
//        clickInBy(byCss("a[href='"+ href +"']"));
//    }
//
//    /** Click By id */
//    public void clickEnId(String id) {
//        clickInBy(byId(id));
//    }
//
//    /** Click By className */
//    public void clickEnClass(String clas) {
//        clickInBy(byClass(clas));
//    }
//
//    /** Click By texto. */
//    public void clickEnTexto(String txt) {
//        clickInBy(byText(txt));
//    }
//
//    public void clickEnTexto(WebElement e, String txt) {
//        clickInBy(e, byText(txt));
//    }
//
//    /** Click By name */
//    public void clickEnName(String name) {
//        clickInBy(byName(name));
//    }
//
//    /** Click By tag */
//    public void clickEnTag(String tag) {
//        clickInBy(byTag(tag));
//    }
//
//    public void clickEnFor(String forr){
//        clickInBy(byCss("*[for='"+ forr +"']"));
//    }
//
//    /** Click By value */
//    public void clickEnValue(String etiqueta, String valueDeElemento) {
//        clickInBy(byValue(etiqueta, valueDeElemento));
//    }
//
//    /** Click By onclick */
//    public void clickEnOnclick(String onclick) {
//        clickEnCss("*[onclick=\"" + onclick + "\"]");
//    }
//
//    /** Click BUTTON BY onclick */
//    public void clickEnButtonOnclick(String onclick) {
//        clickEnCss(s.buttonOnclick(onclick));
//    }
//
//    /** Click LINK BY onclick */
//    public void clickEnLinckOnclick(String onclick) {
//        clickEnCss(s.linkOnclick(onclick));
//    }
//
//    /** Click DIV BY onclick */
//    public void clickEnDivOnclick(String onclick) {
//        clickEnCss(s.divOnclick(onclick));
//    }
//
//    /** Click LINK BY href */
//    public void clickEnLinkHref(String href) {
//        clickEnCss(s.linkHref(href));
//    }
//
//    /** Cliek LINK BY href + saas */
//    public void clickEnLinkHrefSaas(String href) {
//        clickEnCss(s.linkHrefSaas(href));
//    }
//
//    /** Click en Attr que contenga "value" */
//    public void clickEnAttrContainsValue(String attr, String value){
//        clickEnCss("*["+ attr +"*='"+ value +"']");
//    }
//
//
//    /** ****************************************************************************** Introduccion de datos en elemento. */
//
//    public void introDatosInput(By by, String literal) {
//        if (literal != null) {
//            findElement(by).clear();
//            findElement(by).sendKeys(literal);
//        }
//    }
//
//    public void introDatosInputByName(String name, String literal) {
//        introDatosInput(byName(name), literal);
//    }
//
//    /** Introduce datos dentro segun un patron By dentro de un WebElement ya guardado. */
//    public void introDatosInput(WebElement e, By by, String literal) {
//        if (literal != null) {
//            e.findElement(by).sendKeys(literal);
//        }
//    }
//
//    /** Introduce datos dentro de un WebElement ya guardado. */
//    public void introDatosInput(WebElement e, String literal) {
//        if (literal != null) {
//            e.sendKeys(literal);
//        }
//    }
//
//    /** Introduce datos segun patron By y pulsa enter. */
//    public void introDatosInputAndEnter(By by, String literal){
//        introDatosInput(by, literal);
//        pressEnterKey(by);
//    }
//
//    /** Introduce datos segun WEbElement guardado anteriormente y pulsa enter. */
//    public void introDatosInputAndEnter(WebElement w, String literal){
//        introDatosInput(w, literal);
//        pressEnterKey(w);
//    }
//
//    public void introDatosInputAndEnter(String id, String literal){
//        introDatosInput(id, literal);
//        pressEnterKey(byId(id));
//    }
//
//    public void introDatosInputAndEnter(WebElement w, By by, String literal){
//        introDatosInput(w, by, literal);
//        pressEnterKey(by);
//    }
//
//    /** ****************************************************************************** Selects de <options> */
//
//    public void selectByText(String id, String value, String literal) {
//        selectByValue(By.id(id), value);
//    }
//
//    public void selectByText(String id, String literal) {
//        selectByVisibleText(By.id(id), literal);
//    }
//
////    public void selectValueBy(By by, String value, String literal) {
////        if(literal == null)
////            BaseTest.getDriver().findElement(by).selectByValue(by, value);
////        else
////            selectByValue(by, value, literal);
////    }
//
//    public void selectValueByName(String literal, String name) {
//        selectByVisibleText(byName(name), literal);
//    }
//
//    public void selectByText(By contenedor, String text) {
//        if (text != null)
//            if(!StringUtils.equalsIgnoreCase(text, "random"))
//                selectByVisibleText(contenedor, text);
//            else if(StringUtils.isEmpty(text))
//                selectByValue(contenedor, "");
//            else
//                selectByRandom(contenedor);
//
//    }
//
//    public void selectByTextIgnoreCase(By contenedor, String text) {
//        if (text != null)
//            if(!StringUtils.equals(text, "random"))
//                selectByVisibleText(contenedor, text);
//            else
//                selectByRandom(contenedor);
//    }
//
//    public void selectByTextContains(By contenedor, String text) {
//        if (text != null)
//            if(!StringUtils.equals(text, "random"))
//                selectByVisibleContainsText(contenedor, text);
//            else
//                selectByRandom(contenedor);
//
//    }
//
//    public void selectByTextIgnoreCases(By contenedor, String text){
//        if(text != null)
//            selectByVisibleTextIgnoreCase(contenedor, text);
//    }
//
//    public void selectByRandom(By contenedor){
//        List<String> options = getStringOptions(contenedor);
//        int optionsSize = options.size();
//
//        String text = "";
//
//        while(StringUtils.isEmpty(text)){
//            int random = GenericUtils.randomIntBetween(optionsSize);
//            if(StringUtils.isNotEmpty(options.get(random)))
//                text = options.get(random);
//        }
//        selectByVisibleText(contenedor, text);
//    }
//
//    public void selectByVisibleText(By by, String textExpected){
//        Select s = new Select(findElement(by));
//        s.selectByVisibleText(textExpected);
//    }
//
//    public void selectByValue(By by, String valueExpected){
//        Select s = new Select(findElement(by));
//        s.selectByValue(valueExpected);
//    }
//
//    public List<WebElement> getOptionsBy(By by){
//        Select s = new Select(findElement(by));
//        return s.getOptions();
//    }
//
//    public List<String> getStringOptions(By by){
//        Select s = new Select(findElement(by));
//        List<String> res = new ArrayList<>();
//
//        for(WebElement option : s.getOptions())
//            res.add(option.getText());
//
//
//        return res;
//    }
//
//    public void selectByVisibleContainsText(By by, String textContains){
//        Select s = new Select(findElement(by));
//        List<WebElement> options = s.getAllSelectedOptions();
//        for(WebElement o : options)
//            if(StringUtils.contains(o.getText(), textContains))
//                o.click();
//    }
//
//    public void selectByVisibleTextIgnoreCase(By by, String textContainsIgnoreCase){
//        Select s = new Select(findElement(by));
//        List<WebElement> options = s.getAllSelectedOptions();
//        for(WebElement o : options)
//            if(StringUtils.containsIgnoreCase(o.getText(), textContainsIgnoreCase))
//                o.click();
//    }
//
//
//    /** ****************************************************************************** Validaciones de elementos en pantalla y comprobaciones */
//
//    /**
//     * Espera 2 segundos a que el elemento se cargue en la pagina y valida que
//     * este Presente y Visible, sino devuelve FALSE.
//     */
//    public boolean estaElementoPresenteYVisible(By elemento) {
//        boolean res = false;
//        esperarElementoPresente(elemento, 5);
//        if (elementoPresente(elemento))
//            if (elementoVisible(elemento))
//                res = true;
//        return res;
//    }
//
//    public boolean estaElementoPresenteYVisible(WebElement e, By elemento) {
//        boolean res = false;
//        int a = 0;
//        while (a < 1) {
//            try {
//                if (elementoPresente(e, elemento))
//                    if (elementoVisible(e, elemento))
//                        res = true;
//
//                a = 1;
//            } catch (Exception ex) {
//                System.out.println("Exception StaleElementreference. Elemento: " + elemento);
//                System.out.println("Contador de fallos: '" + a + "'");
//                a++;
//            }
//        }
//        return res;
//    }
//
//    public boolean estaElementoPresenteYVisible(WebElement e) {
//        boolean res = false;
//        if (elementoPresente(e))
//            if (elementoVisible(e))
//                res = true;
//        return res;
//    }
//
//    /** Comprueba que un elemento esta Presente y Visible */
//    public boolean elementoVisible(By elemento) {
//        return isElementPresentAndDisplay(elemento);
//    }
//
//    public boolean elementoVisible(WebElement e, By elemento) {
//        return e.findElement(elemento).isDisplayed();
//    }
//
//    public boolean elementoDisponible(By elemento){
//        return (findElement(elemento).getAttribute("disabled") == null ? true : false);
//    }
//
//    public boolean elementoVisible(WebElement e) {
//        return e.isDisplayed();
//    }
//
//    /** Comprueba que un elemento esta Presente */
//    public boolean elementoPresente(By elemento) {
//        return isElementPresent(elemento);
//    }
//
//    public boolean elementoPresente(WebElement e, By elemento) {
//        return e.findElement(elemento).isEnabled();
//    }
//
//    public boolean elementoPresente(WebElement e) {
//        return e.isEnabled();
//    }
//
//    public boolean elementoExistente(By elemento) {
//        if(getElementsBy(elemento) != null)
//            return (getElementsBy(elemento).size() != 0 ? true : false);
//        else
//            return false;
//    }
//
//    public boolean elementoExistente(String elemento) {
//        if(getListBySelector(elemento) != null)
//            return (getListBySelector(elemento).size() != 0 ? true : false);
//        else
//            return false;
//    }
//
//    public boolean elementoExistente(WebElement e, By elemento) {
//        if(getListBySelector(e, elemento) != null)
//            return (getListBySelector(e, elemento).size() != 0 ? true : false);
//        else
//            return false;
//    }
//
//    /** El metodo DEVUELVE un List<WebElement> por un selectorCss */
//    public List<WebElement> getListBySelector(String selector) {
//        return getElementsInSelector(selector);
//    }
//
//    public List<WebElement> getListBySelector(WebElement e, String selector) {
//        return getElementsInSelector(e, selector);
//    }
//
//
//    public List<WebElement> getListBySelector(WebElement e, By element) {
//        List<WebElement> w = null;
//        if (estaElementoPresenteYVisible(e, element)) {
//            w = getElementsInSelector(e, element);
//        }
//        return w;
//    }
//
//    public List<WebElement> getElementsInSelector(String selector) {
//        return findElements(byCss(selector));
//    }
//
//
//    public List<WebElement> getElementsInSelector(String selector, String tagToGetIt) {
//        List<WebElement> elm = findElements(byCss(selector + " > " + tagToGetIt));
//        return elm;
//    }
//
//    public List<WebElement> getElementsBy(By by){
//        return findElements(by);
//    }
//
//    public List<WebElement> getElementsInSelector(WebElement e, String selector) {
//        return findElements(e, byCss(selector));
//    }
//
//    public List<WebElement> getElementsInSelector(WebElement e, By element) {
//        return findElements(e, element);
//    }
//
//    public List<WebElement> getElementsInId(String id) {
//        return findElements(byId(id));
//    }
//
//
//    /** Comprueba que el elemento esta Seleccionado */
//    public boolean isSelected(By elemento) {
//        return findElement(elemento).isSelected();
//    }
//
//    public boolean webElementVisible(WebElement elemento) {
//
//        return elemento.isDisplayed();
//    }
//
//
//
//    // public boolean existeElemento(By by){
//    // return findElement(by).isDisplayed();
//    // }
//    //
//    // public boolean existeElemento(WebElement e, By by){
//    // return e.findElement(by).isDisplayed();
//    // }
//
//    /**
//     * Espera a que el elemento se carrgue en la pagina y debuelve TRUE si esta
//     * cargado.
//     */
//    public boolean esperarPorElementoVisible(By elemento, long timeOutSeconds) {
//        esperarElementoVisible(elemento, timeOutSeconds);
//        return elementoVisible(elemento);
//    }
//
//    /**
//     * Espera a que el elemento se cargue en la pagina y debuelve TRUE si esta
//     * cargado.
//     */
//    public boolean esperarPorElementoPresente(By elemento, long timeOutSeconds) {
//        esperarElementoPresente(elemento, timeOutSeconds);
//        return elementoPresente(elemento);
//    }
//
//    /** Espera hasta que el elemento este visible */
//    public void esperarElementoVisible(By elemento, long timeOutSeconds) {
//        waitForElementVisible(elemento, timeOutSeconds);
//    }
//
//    /** Espera hasta que el elemento este presente */
//    public void esperarElementoPresente(By elemento, long timeOutSeconds) {
//        waitForElementPresent(elemento, timeOutSeconds);
//    }
//
//    /** Espera unos segundos */
//    public void esperar(long timeOutSeconds) throws InterruptedException {
//        wait(timeOutSeconds);
//    }
//
//    /** Espera hasta que recargue la pagina */
//    public void esperaRecargaPagina(long timeOutSeconds) {
//        waitForPageLoaded(timeOutSeconds);
//    }
//
//    public boolean isNull(By elemento) {
//        boolean vacio = false;
//        if (elemento == null)
//            vacio = true;
//        return vacio;
//    }
//
//
//    /**
//     * Comprueba si el elemento By est� Presente y Visible, y que es el esperado
//     * despues de una accion determinada. Tambien comprueba que la URL sea la
//     * esperada.
//     */
//    public void elementosEsperados(By elemento, String url) {
//        if (StringUtils.isNotEmpty(url))
//            TemplateTestUtils.validarUrlNavegador(url);
//        if (!isNull(elemento)) {
//            Assert.assertTrue("No se encuentra el elemento '" + elemento + "' esperado. \n (Opcional) en la url '" + url + "'", isElementPresentAndDisplay(elemento));
//        }
//    }
//
//    /**
//     * Espera a que el elemento este Presente y Visible. Comprueba si el
//     * elemento By est� Presente y Visible, y que es el esperado despues de una
//     * accion determinada. Tambien comprueba que la URL sea la esperada.
//     */
//    public void elementosEsperados(By elemento, String url, long timeout) {
//        waitForElementVisible(elemento, timeout);
//        if (StringUtils.isNotEmpty(url))
//            TemplateTestUtils.validarUrlNavegador(url);
//        if (!isNull(elemento)) {
//            Assert.assertTrue("No se encuentra el elemento '" + elemento + "' esperado, (Opcional) en la url '" + url + "'", isElementPresentAndDisplay(elemento));
//        }
//    }
//
//    /**
//     * Comprueba si el elemento By est� Presente y Visible, y que es el esperado
//     * despues de una accion determinada. Tambien comprueba que la URL sea la
//     * esperada. Este metodo valida varios BY's y varias URL's, pasando un array
//     * de 2 posiciones.
//     */
//    public void elementosEsperados(ArrayList<ArrayList> list) {
//        for (List row : list) {
//            By elemento = (By) row.get(0);
//            String url = (String) row.get(1);
//            if (StringUtils.isNotEmpty(url))
//                TemplateTestUtils.validarUrlNavegador(url);
//            if (!isNull(elemento)) {
//                Assert.assertTrue("No se encuentra el elemento '" + elemento + "' esperado, (Opcional) en la url '" + url + "'", isElementPresentAndDisplay(elemento));
//            }
//        }
//    }
//
//    /** Si el elemento no esta visible saltar� un error. */
//    public void elementoEsperado(By elemento) {
//        if (!isNull(elemento))
//            if (!estaElementoPresenteYVisible(elemento))
//                Assert.assertTrue("No se encuentra el elemento '" + elemento + "' esperado", elementoVisible(elemento));
//    }
//
//    /** Espera al elemento, y si no esta visible saltar� un error. */
//    public void elementoEsperado(By elemento, long timeout) {
//        waitForElementVisible(elemento, timeout);
//        elementoEsperado(elemento);
//    }
//
//    public void elementoNoEsperado(By elemento) {
//        if (!isNull(elemento))
//            Assert.assertFalse("Se encontro el elemento que no se esperaba '" + elemento + "'", elementoVisible(elemento));
//    }
//
//    /** Si el elemento no contiene el Atributo esperado saltara error. */
//    public void atributoEsperado(By elemento, String attr, String attrExpected) {
//        boolean equals = StringUtils.equals(findElement(elemento).getAttribute(attr), attrExpected) || StringUtils.contains(findElement(elemento).getAttribute(attr), attrExpected) ;
//        if (!isNull(elemento))
//            Assert.assertTrue("No se encuentra el atributo '" + attrExpected + "' esperado en el atributo: '" + attr + "'", equals);
//    }
//
//    public boolean tieneAtributoEsperado(By elemento, String attr, String attrExcpected){
//        return StringUtils.equals(findElement(elemento).getAttribute(attr), attrExcpected) || StringUtils.contains(findElement(elemento).getAttribute(attr), attrExcpected) ;
//    }
//
//    public boolean tieneAtributoEsperado(WebElement w, By elemento, String attr, String attrExcpected){
//        return StringUtils.equals(findElement(w, elemento).getAttribute(attr), attrExcpected) || StringUtils.contains(findElement(w, elemento).getAttribute(attr), attrExcpected) ;
//    }
//
//
//    /** ****************************************************************************** Getters de texto y atributos. */
//
//    public String getTextoByElemento(By by) {
//        if (estaElementoPresenteYVisible(by))
//            return findElement(by).getText();
//        else
//            return null;
//    }
//
//    public String getTextoById(String id){
//        if (estaElementoPresenteYVisible(byId(id)))
//            return getTextoByElemento(byId(id));
//        else
//            return null;
//    }
//
//    public String getTextoByClassName(String clas){
//        if(elementoExistente(byClass(clas))){
//            return findElementByClass(clas);
//        }
//    }
//
//    public String getTextoByElemento(WebElement e, By by) {
//        if (elementoExistente(e, by))
//            return findElement(e, by).getText();
//        else
//            return "";
//    }
//
//    public String getTextoByElemento(WebElement e) {
//        if(webElementVisible(e))
//            return e.getText();
//        else
//            return null;
//    }
//
//
//    /** Devuelve el ONCLICK de un Elemento */
//    public String getOnclickByElement(By by) {
//        return getAttrByElement(by, "onclick");
//    }
//
//    public String getAttrByWebElement(WebElement e, String attr) {
//        return e.getAttribute(attr);
//    }
//
//    public String getAttrByWebElement(WebElement e, By by, String attr) {
//        return findElement(e, by).getAttribute(attr);
//    }
//
//    public String getOnclickByElement(WebElement e, By by) {
//        return getAttrByWebElement(by, "onclick");
//    }
//
//    public String getTitleByElement(WebElement e, By by) {
//        return getAttrByWebElement(e, by, "title");
//    }
//
//    public String getActionByElement(By by) {
//        return getAttrByElement(by, "action");
//    }
//
//    /** Devuelve la CLASS de un Elemento */
//    public String getClassByElemento(By by) {
//        return getAttrByElement(by, "class");
//    }
//
//    /** Devuelve el HREF de un Elemento */
//    public String getHrefByElemento(By by) {
//        return getAttrByElement(by, "href");
//    }
//
//    /** Devuelve el SRC de un Elemento */
//    public String getSrcByElemento(By by) {
//        return getAttrByElement(by, "src");
//    }
//
//    /** Devuelve el ID de un Elemento */
//    public String getIdByElemento(By by) {
//        return getAttrByElement(by, "id");
//    }
//
//    /** Devuelve el ID de un WebElement */
//    public String getIdByElemento(WebElement e) {
//        return getAttrByWebElement(e, "id");
//    }
//
//    /** Devuelve el ID de un Elemento dentro de un WebElement */
//    public String getIdByElemento(WebElement e, By by) {
//        return getAttrByWebElement(e, by, "id");
//    }
//
//    /** Devuelve el VALUE de un Elemento */
//    public String getValueByElemento(By by) {
//        return getAttrByElement(by, "value");
//    }
//
//    public String getValueById(String id){
//        return getAttrByElement(byId(id), "value");
//    }
//
//    public String getValueByElemento(WebElement e) {
//        return getAttrByWebElement(e, "value");
//    }
//
//    public String getValueByElemento(WebElement e, By by) {
//        return getAttrByWebElement(e, by, "value");
//    }
//
//
//    /** Devuelve el 'atributo' de un elemento web. */
//    public String getAttrByElement(By by, String attr) {
//        if (elementoExistente(by))
//            return findElement(by).getAttribute(attr);
//        else
//            return "null";
//    }
//
//
//
//    public String getLocation() {
//        String location = BaseTest.getDriver().getCurrentUrl();
//        return location;
//    }
//
//    /** El metodo DEVUELVE la URL actual */
//    public String getCurrentUrl() {
//        return this.getLocation();
//    }
//
//    public void waitForPageLoaded(long timeOutSegundos) {
//        SeleniumUtils.waitForPageLoaded(BaseTest.getDriver(), timeOutSegundos);
//    }
//
//    public WebElement waitForElementVisible(By elemento, long timeOutSegundos) {
//        return SeleniumUtils.waitForElement(BaseTest.getDriver(),  elemento, timeOutSegundos);
//    }
//
//    public WebElement waitForElementPresent(By elemento, long timeOutSegundos) {
//        return SeleniumUtils.waitForElementPresent(BaseTest.getDriver(),  elemento, timeOutSegundos);
//    }
//
//    public boolean isElementPresentAndDisplay(By elemento) {
//        return SeleniumUtils.isElementPresentAndDisplay(BaseTest.getDriver(),  elemento);
//    }
//
//    public boolean isElementPresent(By elemento) {
//        return SeleniumUtils.isElementPresent(BaseTest.getDriver(), elemento);
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    public void ejecutarScript(WebElement e, String script) {
//		executeScriptJs(script);
//	}
//
//	public void pressEnterKey(By by) {
//        keypress(by, "enter");
//	}
//
//	public void pressEnterKey(WebElement e) {
//        keypress(e);
//	}
//
//	private static void pressKey(By by, String key) {
//		switch (key) {
//		case "enter":
//			findElement(by).sendKeys(Keys.RETURN);
//			break;
//		}
//	}
//
//	public void moverA(WebElement queSeMueve, WebElement aDondeSeMueve) {
//        dragNdDrop(queSeMueve, aDondeSeMueve);
//	}
//
//
//
//	public void refresh() {
//		// clearCache(testCase);
//		refresh();
//	}
//
//	public void clearCache() {
//        getWebDriver().manage().deleteCookieNamed("DOM");
//	}
//
//
//
//	public void clickIn(String id) {
//        click(By.id(id));
//	}
//
//	public void doubleClickIn(String id) {
//        click(By.id(id));
//        click(By.id(id));
//	}
//
//	public void clickInBy(By by) {
//		click(by);
//	}
//
//	public void clickInBy(WebElement e, By by) {
//		e.findElement(by).click();
//	}
//
//	public void switchTo() {
//		switchTo();
//	}
//
//	public void clickAndWait(By by, int timeout) {
//        clickAndWait(by, timeout);
//	}
//
//	public void reFind(By by) {
//		handleStaleElement(by);
//	}
//
//	// public void reFind(WebElement e, By by){
//	// handleStaleElement(e, by);
//	// }
//
//	// public void reFind(test, WebElement e, By by){
//	// handleStaleElement(test, e, by);
//	// }
//	//
//	// public void handleStaleElement(test, WebElement e, By
//	// element) {
//	// int count = 0;
//	// //It will try 4 times to find same element using name.
//	// while (count < 4) {
//	// try {
//	// //If exception generated that means It Is not able to find element then
//	// catch block will handle It.
//	// WebElement staledElement = null;
//	// } catch (StaleElementReferenceException st) {
//	// e.toString();
//	// System.out.println("Trying to recover from a stale element :" +
//	// st.getMessage());
//	// count = count + 1;
//	// }
//	// count = count + 4;
//	// }
//	// }
//
//	// public void finds(WebElement e, By by){
//	// getWebDriver()
//	// }
//
//	public void introDatosInput(String id, String literal) {
//		if(literal != null){
////			waitForPageLoaded(6);
//	//		literal = (StringUtils.equals(literal, "random") ? GenericUtils.stringAleatorioNormalLetter(longitudCaracteres, literalInicioCadena)(literal, 5) : literal);
//			int a = 0;
//			while (a < 2) {
//				try {
//					WebElement ele = findElement(By.id(id));
//					if (literal.equals("auto")) {
//						literal = ele.getAttribute("value");
//					}
//					if (literal != null) {
//						ele.clear();
//						ele.sendKeys(literal);
//					}
//					break;
//				} catch (Exception e) {
//					System.out.println("Exception StaleElementreference.");
//					System.out.println(e.getMessage() + " /n ");
//					System.out.println(" /n ");
//					System.out.println(a + " /n ");
//
//					a++;
//				}
//			}
//		}
//	}
//
//
//
//	/**
//	 * Comprueba si el elemento By contiene texto. Devuelve FALSE si no contiene
//	 * texto.
//	 */
//	public boolean tieneTexto(By by) {
//		if (StringUtils.isEmpty(getTextoByElemento(by)))
//			return false;
//		else
//			return true;
//	}
//
//	/**
//	 * Comprueba si el elemento By, en el atributo pasado por parametro,
//	 * contiene algun tipo de valor.
//	 *
//	 * @param ByUtils
//	 *            .by Elemento a buscar.
//	 * @param attr
//	 *            Atributo a comprobar.
//	 */
//	public boolean tieneValor(By elemento, String attr) {
//		WebElement campo = findElement(elemento);
//		if (campo.getAttribute(attr).equals(""))
//			return false;
//		else
//			return true;
//	}

}
