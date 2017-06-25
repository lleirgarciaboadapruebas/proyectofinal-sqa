package application.coches.test;

import application.coches.main.interfaces.CocheStepInterface;
import application.coches.main.steps.CochesStepsProcess;
import application.coches.main.validaciones.CochesValidacionesProcesosAction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import selenium_tools.ABaseTestCase;

/**
 * Created by lleir on 25/6/17.
 */

@RunWith(JUnit4.class)
public class Test1 extends ABaseTestCase implements CocheStepInterface{

    @Before
    public void ini(){
        setBaseUrl("192.168.1.42/tallerlavi3/");
        setTestNameClass("Test");
    }

    @Test
    public void test1(){
        stepsProcess.irListadoCoches();
    }


    @Override
    public void setBaseUrl(String url) {
        baseUrl = url;
    }

    @Override
    public void setUser(String userr) {
        user = userr;
    }

    @Override
    public void setPassword(String passwordd) {
        password = passwordd;
    }

    @Override
    public String getApp() {
        return app;
    }

    @Override
    public void setTestNameClass(String testNameClass) {
        testClassName = testNameClass;
    }


    private CochesStepsProcess stepsProcess;
    private CochesValidacionesProcesosAction validations;

    @Override
    public CochesStepsProcess getStepsProcess() {
        return stepsProcess;
    }

    @Override
    public CochesValidacionesProcesosAction getValidationsProcess() {
        return validations;
    }
}
