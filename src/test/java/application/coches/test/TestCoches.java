package application.coches.test;

import application.clientes.main.Cliente;
import application.coches.main.Coches;
import global_utils.GenericUtils;
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
        setTestNameClass(this.getClass().getName());
        setDetailValidation(false);
    }


    @Test
    public void validarPantallaListadoCoches() throws Exception {
        Coches.process.irListadoCoches();
        Coches.validaciones.validarPantallaListado(true);
    }

    @Test
    public void validarCreacionCocheEnListado() throws Exception {
        String matricula = GenericUtils.randomString(10);
        String marca = GenericUtils.randomString(10);
        String modelo = GenericUtils.randomString(10);


        Coches.process.crearCoche(matricula, marca, modelo, "200000", "1283-2392-3829-3243", "ALBA FARRES JUBANY");
        Coches.steps.clickEnMenuCoches();
        Coches.validaciones.validarCocheEnListado(matricula, marca, true);
    }

    @Test
    public void validarCocheDisponibleEnCreacionFactura() throws Exception {
        String matricula = GenericUtils.randomString(10);
        String marca = GenericUtils.randomString(10);
        String modelo = GenericUtils.randomString(10);
        String nif = GenericUtils.randomString(8) + "N";
        String nombre = GenericUtils.randomString(7);
        String apellidos = GenericUtils.randomString(8);
        String telefono = Integer.toString(GenericUtils.randomNumberSpecificRange(12, 23));


        Coches.process.crearCoche(matricula, marca, modelo, "200000", "1283-2392-3829-3243", "ALBA FARRES JUBANY");
        Cliente.process.crearCliente(nif, nombre, apellidos, "Psg/ la garza 10", "Cardedeu", telefono, "");

    }

    @Test
    public void vlaidarEliminacionCOche() throws Exception {

    }


    @Override
    public void setBaseUrl(String baseUrll) {
        baseUrl = baseUrll;
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
}
