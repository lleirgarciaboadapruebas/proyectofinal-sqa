package application.coches.test;

import org.junit.Before;
import org.junit.Test;
import selenium_tools.ABaseTestCase;

/**
 * Created by lleir on 3/7/17.
 */
public class TestCoches extends ABaseTestCase {


    @Before
    public void ini() {
        setBaseUrl("192.168.1.42/tallerlavi3/");
        setTestNameClass("Test");
        setTestNameClass("test1");
//        System.setProperty(DETAIL_VALIDATION_STEP, "false");
        setDetailValidation(false);
    }


    @Test
    public void validarPantallaListadoCoches() throws Exception {

    }

    @Test
    public void validarCreacionCocheEnListado() throws Exception {

    }

    @Test
    public void validarCocheDisponibleEnCreacionFactura() throws Exception {

    }

    @Test
    public void vlaidarEliminacionCOche() throws Exception {

    }


    @Override
    public void setBaseUrl(String baseUrl) {

    }

    @Override
    public void setUser(String userr) {

    }

    @Override
    public void setPassword(String passwordd) {

    }

    @Override
    public String getApp() {
        return null;
    }

    @Override
    public void setTestNameClass(String testNameClass) {

    }
}
