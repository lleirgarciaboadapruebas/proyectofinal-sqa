package application.clientes.test;

import application.clientes.main.Cliente;
import application.coches.main.Coches;
import global_utils.GenericUtils;
import org.junit.Before;
import org.junit.Test;
import selenium_tools.ABaseTestCase;

/**
 * Created by lleir on 3/7/17.
 */
public class TestCliente extends ABaseTestCase {

    @Before
    public void ini() {
        setBaseUrl("192.168.1.42/tallerlavi3/");
        setTestNameClass(this.getClass().getName());
//        System.setProperty(DETAIL_VALIDATION_STEP, "false");
        setDetailValidation(false);
    }

    @Test
    public void validarPantallaListadoCliente() throws Exception {
    	setTestCaseName(getNameTest());
        Cliente.steps.clickEnClientes();
        Cliente.validaciones.validarPantallaListado(true);
    }

    @Test
    public void validarCreacionClienteEnListado() throws Exception {
    	setTestCaseName(getNameTest());
        String nif = Integer.toString(GenericUtils.randomNumberSpecificRange(0, 10));
        Cliente.process.crearCliente(nif, "Pepito", "Sousa", "C/ Sin numero", "Cardedeu", "653847238", "");
        Cliente.steps.clickEnClientes();
        Cliente.validaciones.validarClienteEnListado("Pepito", "Sousa", "653847238");
    }


    @Test
    public void validarClienteDisponibleEnCreacionCoche() throws Exception {
    	setTestCaseName(getNameTest()); 
        String nif = Integer.toString(GenericUtils.randomNumberSpecificRange(0, 10));
        Cliente.process.crearCliente(nif, "Lourdes", "Martinez", "C/ Sin numero", "Cardedeu", "653847238", "");
        Coches.steps.clickEnMenuCoches();
        Coches.validaciones.validarClienteSeleccionableEnCreacionCoche("Lourdes Martinez");
    }

    @Test
    public void eliminarClienteValidarClienteEliminadoCocheEliminado() throws Exception {
        String nif = Integer.toString(GenericUtils.randomNumberSpecificRange(0, 10));
        Cliente.process.crearCliente(nif, "Pepe", "Costa", "C/ Sin numero", "Cardedeu", "653847238", "");
        Coches.process.crearCoche("4254-HJS", "Mercedes", "CLK 200", "190000", "3242-3242-4353-3453", "Pepe Costa");
        Cliente.process.eliminarCliente("Pepe", "Costa", "653847238");
        Cliente.validaciones.validarclienteInexistenteEnListado("Pepe", "Costa", "653847238", true);
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
    public void setTestNameClass(String testNameClasss) {
    	testClassName = testNameClasss;
    }

	@Override
	public void setTestCaseName(String testCaseNamee) {
		testCaseName = testCaseNamee;
	}
}
