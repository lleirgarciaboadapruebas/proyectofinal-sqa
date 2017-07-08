package application.coches.test;

import application.clientes.main.Cliente;
import application.coches.main.Coches;
import application.facturas.main.Factura;
import cucumber.deps.com.thoughtworks.xstream.core.util.Pool.Factory;
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
        setBaseUrl("192.168.1.42/tallerlavi_git/");
        setTestNameClass(this.getClass().getName());
        setDetailValidation(false);
    }


    @Test			// test okey
    public void validarPantallaListadoCoches() throws Exception {
        Coches.process.irListadoCoches();
        Coches.validaciones.validarPantallaListado(true);
    }

    @Test			// test okey
    public void validarCreacionCocheEnListado() throws Exception {
        String matricula = GenericUtils.randomString(10);
        String marca = GenericUtils.randomString(10);
        String modelo = GenericUtils.randomString(10);


        Coches.process.crearCoche(matricula, marca, modelo, "200000", "1283-2392-3829-3243", "ALBA FARRES JUBANY");
        Coches.steps.clickEnMenuCoches();
        Coches.validaciones.validarCocheEnListado(matricula, marca, modelo, true);
    }

    @Test  		// test okey
    public void validarCocheDisponibleEnCreacionFactura() throws Exception {
        String matricula = GenericUtils.randomString(10);
        String marca = GenericUtils.randomString(10);
        String modelo = GenericUtils.randomString(10);
        String nif = GenericUtils.randomString(8) + "N";
        String nombre = GenericUtils.randomString(7);
        String apellidos = GenericUtils.randomString(8);
        String completo  = nombre +" "+apellidos;        		
        String telefono = Integer.toString(GenericUtils.randomNumberSpecificRange(12, 23));


        Cliente.process.crearCliente(nif, nombre, apellidos, "Psg/ la garza 10", "Cardedeu", telefono, "");
        Coches.process.crearCoche(matricula, marca, modelo, "200000", "1283-2392-3829-3243", completo);
        Factura.steps.clickEnMenuFacturas();
        Factura.steps.crear();
        Factura.steps.seleccionarCliente(completo);
        Factura.validaciones.validarComboCocheVisible(true);
        Factura.validaciones.validarCocheSeleccionable(marca, modelo, matricula, true);
        

    }

    @Test
    public void validarEliminacionCoche() throws Exception {

    }


    @Override
    public void setBaseUrl(String baseUrll) {
        baseUrl = baseUrll;
    }

    @Override
    public String getApp() {
        return app;
    }

    @Override
    public void setTestNameClass(String testNameClass) {
        testClassName = testNameClass;
    }

    @Override
    public void setTestCaseName(String testCaseNamee) {
        testCaseName = testCaseNamee;
    }
}
