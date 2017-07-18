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
        setTestNameClass(this.getClass().getName());
        setDetailValidation(false);
    }

    @Test 		// test okay
    public void validarPantallaListadoCliente() throws Exception {
    	setTestCaseName(getNameTest());
        Cliente.steps.clickEnClientes();
        Cliente.validaciones.validarPantallaListado(true);
    }

    @Test		// test okay
    public void validarClienteCreadoEnListado() throws Exception {
    	setTestCaseName(getNameTest());
        String nif = Integer.toString(GenericUtils.randomNumberBetween());
        String telefono = Integer.toString(GenericUtils.randomNumberSpecificRange(0, 25));
        Cliente.process.crearCliente(nif, "Pepito", "Sousa", "C/ Sin numero", "Cardedeu", telefono, "");
        Cliente.steps.clickEnClientes();
        Cliente.validaciones.validarClienteEnListado("Pepito", "Sousa", telefono, true);
    }


    @Test 		// test okay
    public void validarClienteDisponibleEnCreacionCoche() throws Exception {
    	setTestCaseName(getNameTest()); 
        String nif = Integer.toString(GenericUtils.randomNumberBetween());
        String nombre = GenericUtils.randomString(10);
        Cliente.process.crearCliente(nif, nombre, "Martinez", "C/ Sin numero", "Cardedeu", "653847238", "");
        Coches.steps.clickEnMenuCoches();
        Coches.steps.crear();
        Coches.validaciones.validarClienteSeleccionableEnCreacionCoche("Lourdes Martinez");
    }

    @Test 		// test okay
    public void eliminarClienteValidarClienteEliminadoCocheEliminado() throws Exception {
        String nif = Integer.toString(GenericUtils.randomNumberBetween());
        String nombre = GenericUtils.randomString(10);
        String apellido = GenericUtils.randomString(10);
        String completo = nombre +" "+ apellido;
        
        Cliente.process.crearCliente(nif, nombre, apellido, "C/ Sin numero", "Cardedeu", "653847238", "");
        Coches.process.crearCoche(nif, "Mercedes", "CLK 200", "190000", "3242-3242-4353-3453", completo);
        Cliente.process.eliminarCliente(nombre, apellido, "653847238");
        Cliente.validaciones.validarclienteInexistenteEnListado(nombre, apellido, "653847238", true);
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
