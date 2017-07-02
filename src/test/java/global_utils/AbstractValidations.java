package global_utils;

import java.util.List;

import org.apache.commons.codec.binary.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import selenium_tools.ABaseTestCase;
import selenium_tools.ADriverUtils;

/**
 * Created by lleir on 25/6/17.
 */

public abstract class AbstractValidations<AtributosPantalla> extends AbstractBaseUtils<AtributosPantalla> {

    protected void validarCampoExistenteById(String idExpected) {
        if (!existeCampo(getDriverUtils().getByUtils().byIdContains(idExpected))) {
            error("Se esperaba un campo en pantalla pero no se encontr� o no esta visible '" + idExpected + "'");
        }
    }

    protected void vlaidarCampoExistenteByClass(String classExpected) {
        if (!existeCampo(getDriverUtils().getByUtils().byClass(classExpected))) {
            error("Se esperaba un campo en pantalla pero no se encontr� o no esta visible '" + classExpected + "'");
        }
    }

    protected void validarCampoExistenteByCss(String cssExpected) {
        if (!existeCampo(getDriverUtils().getByUtils().byCss(cssExpected))) {
            error("Se esperaba un campo en pantalla pero no se encontr� o no esta visible '" + cssExpected + "'");
        }
    }

    protected void validarCampoExistenteByIdContains(String tagname, String idExpected) {
        if (!existeCampo(getDriverUtils().getByUtils().byTagnameAndIdContains(tagname, idExpected))) {
            error("Se esperaba un campo en pantalla pero no se encontr� o no esta visible '" + idExpected + "'");
        }
    }

    protected void validarCampoExistenteByClass(String classExpected) {
        if (!existeCampo(getDriverUtils().getByUtils().byClass(classExpected))) {
            error("Se esperaba un campo en pantalla pero no se encontr� o no esta visible '" + classExpected + "'");
        }
    }

    protected boolean esVisible(By by) {
        if (existeCampo(by) && getDriverUtils().isElementVisible(by))
            return true;

        return false;
    }

    protected boolean campoNoVisible(By by) {
        if (existeCampo(by) && !getDriverUtils().isElementVisible(by))
            return true;

        return false;
    }

    protected boolean existeCampo(By by) {
        if (getDriverUtils().isElementPresent(by))
            return true;

        return false;
    }

    protected void validarTextoById(String id, String expected) {
        write("Validacion de texto by ID");
        validarCampoExistenteById(id);
        String strPantalla = (getDriverUtils().getInputValueByContainsId(id));        //.isEmpty() ? getTextoByContainsId(id) : getTextoById(id));
        if (!eq(strPantalla, expected))
            error("Se esperaba el texto '"+ expected + "' pero se encontró '"+ strPantalla + "'");

    }

    protected void validarTextoByClass(String clas, String expected, String msg){
        write("Validacion de texto by CLASS");
        validarCampoExistenteByClass(clas);
        String strPantalla = (getDriverUtils().getTextoByClass(clas));
        if (!eq(strPantalla, expected))
            error(msg +" En pantalla se mustra el literal: '"+ strPantalla + "'");
    }

    protected void validarValueByCss(String css, String expected, String msg) {
        write("Validacion de texto by CLASS");
        validarCampoExistenteByCss(css);
        String strPantalla = (getDriverUtils().getValueByCss(css));
        if (!eq(strPantalla, expected))
            error("Se esperaba el valor '" + expected + "' en el campo patron Css '" + css + "' pero se encontr�: '" + strPantalla + "'");
    }   

    protected void validarTextSpanById(String id, String expected, String msg) {
        write("Validacion de texto by ID");
        validarCampoExistenteByIdContains("span", id);
        String strPantalla = (getDriverUtils().getSpanTextValueByContainsId(id));        //.isEmpty() ? getValueByContainsId(id) : getValueById(id));
        if (!eq(strPantalla, expected))
            error(msg);

    }

    protected void validarValueInputById(String id, String expected, String msg) {
        write("Validacion de texto by ID");
        validarCampoExistenteById(id);
        String strPantalla = (getDriverUtils().getInputValueByContainsId(id));        //.isEmpty() ? getValueByContainsId(id) : getValueById(id));
        if (!eq(strPantalla, expected))
            error(msg);

    }

    protected void validarAtributoCampoById(String id, String atributo, String expectedAttr, String msg){
        write("Validacion de atributo by ID y atributo");
        String attrTagPantalla = (getDriverUtils().getAtributoById(id, atributo));
        if (!eq(attrTagPantalla, expectedAttr))
            error(msg);
    }

    protected void validarOptionDisponibleEnCombo(String idCombo, String optionExpected) {
        write("Validacion option esperada en combo");
        Select select = new Select(getDriverUtils().findElementById(idCombo));
        List<WebElement> options = select.getOptions();

        int countok = 0;

        for (WebElement o : options)
            if (StringUtils.equals(o.getText(), optionExpected)) {
                countok++;
                break;
            }

        if (countok == 0)
            error("Se esperaba la opcion '" + optionExpected + "' en la combo con ID '" + idCombo + "' pero no se encontr�.");
    }

    protected void writeStepOk(String msg) {
        write("++ ValidStepOk ++ " + msg);
    }

    protected void writeStepFail(String msg) {
        write("-- ValidStepFail -- " + msg);
    }

    protected void error(String msg) {
        throwExceptionClass(ABaseTestCase.testClassName, msg, 1);
    }

    private boolean eq(String pantalla, String expected) {
        boolean res = false;
        if (StringUtils.equals(pantalla, expected)) {
            res = true;
            write("Expected '" + pantalla + "' vs pantalla '" + expected + "'");
        } else {
            res = false;
        }
        return res;
    }

    //Gestion de errores, por ahora solo lo manda a pantalla
    private void throwExceptionClass(String testClassName, String msg, int option) {
        String testName = new Exception().getStackTrace()[1].getMethodName();
//		System.out.println(testClassName + ": " + "("+testName+") "+msg);
        throwException(testClassName, "(" + testName + ") " + msg, option);
    }

    private void throwException(String ClassName, String msg, int option) {
        switch (option) {
            case 1:
                System.out.println(ClassName + ": " + msg);
                throw new Error(ClassName + ": " + msg);
            case 2:
                //CREATE LOG
            default:
                break;
        }
    }

    protected void write(String a) {
        System.out.println(a);
    }

    private ADriverUtils drive;

    @Override
    public ADriverUtils getDriverUtils() {
        drive = (drive == null ? new ADriverUtils() : drive);
        return drive;
    }

    /**
     * Si la validacion es con detalle "true" tambien se ejecutan las validaciones de los steps.
     */
    public boolean isDetailed() {
        return ABaseTestCase.isDetailedTest();
    }
}