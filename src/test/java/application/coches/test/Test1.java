package application.coches.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import application.clientes.main.Cliente;
import application.coches.main.Coches;
import global_utils.GenericUtils;
import selenium_tools.ABaseTestCase;

/**
 * Created by lleir on 25/6/17.
 */

@RunWith(JUnit4.class)
public class Test1 extends ABaseTestCase {

    @Before
    public void ini(){
        setBaseUrl("192.168.1.42/tallerlavi3/");
        setTestNameClass("Test");
        setTestNameClass("test1");
//        System.setProperty(DETAIL_VALIDATION_STEP, "false");
        setDetailValidation(false);
    }

    @Test
    public void t_ir_listado_coches() throws Exception{
        Coches.process.irListadoCoches();
    }

    @Test
    public void t_validar_pantalla_creacion_coche() throws Exception {
        Coches.process.irListadoCoches();
        Coches.steps.crear();
        Coches.validaciones.validarPantallaCreacion(true);
    }

    @Test
    public void t_validar_pantalla_vista_coche() throws Exception {
        Coches.process.irListadoCoches();
        Coches.steps.editarEnListado("matriculaexistente");
        Coches.validaciones.validarPantallaVista(true);
    }

    @Test
    public void t_validar_pantalla_edicion_coche() throws Exception {
        Coches.process.irListadoCoches();
        Coches.steps.editarEnListado("matriculaexistente");
        Coches.steps.editarDatos();
        Coches.validaciones.validarPantallaModificacion(true);
    }

    @Test
    public void t_crear_coche_exito() throws Exception {
        Coches.process.crearCoche("" + GenericUtils.randomNumberSpecificRange(0, 9), "Nissan", "Almera", "200000", "4526-9545-5654-5454", "");

    }
    
    @Test public void t_validar_clientes_existentes() throws Exception {
        String nif = GenericUtils.randomNumberSpecificRange(1, 1000) + "N";
        String nombre = "Pepe";
        String apellidos = "Rubianes";
        String complete = nombre +" "+ apellidos;

        Cliente.process.crearCliente(nif, nombre, apellidos, "Pasage Z, nº 20", "Cardedeu", "637283942", "");
        Coches.process.irListadoCoches();
        Coches.process.getSteps().crear();
        Coches.validaciones.validarClienteSeleccionableEnCreacionCoche(complete);
    }

    @Test public void t_validar_cliente_creado_existente() throws Exception{

    }

    @Test public void t_validar_creacion_listado() throws Exception {
        String matricula = "2304 HPE";
        Coches.process.irListadoCoches();
        Coches.process.crearCoche(matricula, "Mercedes", "CLK 200", "180000", "3424-5433-2345-3424", "Cliente");
        Coches.validaciones.validarCreacionEnListado(matricula);
    }

    @Test public void t_validar_filtro_modelo(){
        String modelo = "Clio";
        Coches.process.irListadoCoches();
        Coches.process.filtrarPor(modelo, null, null, null);
        Coches.validaciones.validarFiltrado(true, "Modelo", modelo);
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



}
