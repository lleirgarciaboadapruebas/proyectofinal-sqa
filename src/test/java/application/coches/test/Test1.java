package application.coches.test;

import application.clientes.main.steps.ClienteProcessSteps;
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
    public void t_ir_listado_coches() throws Exception{
        stepsProcess.irListadoCoches();
    }

    @Test public void t_validar_clientes_existentes() throws Exception {
        String nombre = "Pepe";
        String apellidos = "Rubianes";
        String complete = nombre +" "+ apellidos;

        stepsProcessCliente.crearCliente("45928374-B", nombre, apellidos, "Pasage Z, nº 20", "Cardedeu", "637283942", null);
        stepsProcess.irListadoCoches();
        stepsProcess.getSteps().crear();
        validations.validarClienteSeleccionableEnCreacionCoche(complete);
    }

    @Test public void t_validar_cliente_creado_existente() throws Exception{

    }

    @Test public void t_validar_creacion_listado() throws Exception {
        String matricula = "2304 HPE";
        stepsProcess.irListadoCoches();
        stepsProcess.crearCoche(matricula,  "Mercedes", "CLK 200", "180000", "3424-5433-2345-3424", "Cliente");
        validations.validarCreacionEnListado(matricula);
    }

    @Test public void t_validar_filtro_modelo(){
        String modelo = "Clio";
        stepsProcess.irListadoCoches();
        stepsProcess.filtrarPor(modelo, null, null, null);
        validations.validarFiltrado(true, "Modelo", modelo);
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


    private CochesStepsProcess stepsProcess = new CochesStepsProcess();
    private CochesValidacionesProcesosAction validations = new CochesValidacionesProcesosAction();
    private ClienteProcessSteps stepsProcessCliente = new ClienteProcessSteps();

    @Override
    public CochesStepsProcess getStepsProcess() {
        return stepsProcess;
    }

    @Override
    public CochesValidacionesProcesosAction getValidationsProcess() {
        return validations;
    }

    @Override
    public ClienteProcessSteps getStepsProcessCliente() {
        return stepsProcessCliente;
    }
}
