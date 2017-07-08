package application.clientes.main.steps;

import application.clientes.main.atributos.ClienteAtributos;
import application.clientes.main.validaciones.ClienteValidacionesSteps;
import application.main.AbstractSteps;
import application.menu_top.steps.Menu;
import global_utils.interfaces.GeneralStepsInterface;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import selenium_tools.ADriverUtils;

import java.util.List;

/**
 * Created by lleir on 16/6/17.
 */
public class ClienteSteps extends AbstractSteps<ClienteAtributos, ClienteValidacionesSteps> implements GeneralStepsInterface {
    /** Steps client module. */

    public void clickEnClientes() {
        Menu.process.clickEnClientes();
        driver.waitForElementPresentWithClass(atributos.tablaClass);
        validaciones.validarPantallaListado(validaciones.isDetailed());
    }

    public void crear() {
        driver.writeStep(driver.getNameMethod());
        // cogemos el button crear por css porque por id nos da problemas
        driver.waitForElementPresentWithCss(atributos.selectorBtnCrear);
        driver.clickByCss(atributos.selectorBtnCrear);
        validaciones.validarPantallaCreacion(validaciones.isDetailed());
    }

    public void volver() {
        // TODO Auto-generated method stub

    }

    public void filtrar() {
        // TODO Auto-generated method stub

    }

    public void editarDatos() {
        // TODO Auto-generated method stub

    }


    public void guardarDatos() {
        driver.writeStep(driver.getNameMethod());
        driver.clickById(atributos.btnGuardarId);

    }

    public void cancelarDatos() {
        // TODO Auto-generated method stub

    }

    public void editarEnListado(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void eliminar(String id) {

    }


    public void eliminar(String nombre, String apellidos, String telefono) {
        WebElement tr_expected = getDriverUtils().devolverWebElement(atributos.selectorTabla, 
    			"td:nth-child(1)", "td:nth-child(2)", "td:nth-child(4)", nombre, apellidos, telefono);
        if(tr_expected != null){
	        List<WebElement> a = driver.findElements(tr_expected, driver.getByUtils().byCss(".td-acciones > a"));
	        driver.clickWebElement(a.get(0));
        }
    }
    
    public void clickAceptarEliminarCliente(){
    	driver.acceptarAlert();
    }

    public void insertarNif(String nif) {
        driver.writeStep(driver.getNameMethod());
        driver.introDatosInputByCss(atributos.labelValueNifCss, nif);
        validaciones.validarTextoIntroducido(nif, atributos.labelNifClass, false); //isDetailed);
    }

    public void insertarNombre(String nombre) {
        driver.introDatosInputByCss(atributos.labelValueNombreCss, nombre);
        validaciones.validarTextoIntroducido(nombre, atributos.labelNifClass, false);
    }

    public void insertarApellidos(String apellidos) {
        driver.introDatosInputByCss(atributos.labelValueApellidosCss, apellidos);
        validaciones.validarTextoIntroducido(apellidos, atributos.labelApellidosClass, false);
    }

    public void insertarDireccion(String direccion) {
        driver.introDatosInputByCss(atributos.labelValueDireccionCss, direccion);
//        validations.validarTextoById(atributos.direccionClass, direccion);
    }

    public void insertarLocalidad(String localidad) {
        driver.introDatosInputByCss(atributos.labelValueLocalidadCss, localidad);
//        validations.validarTextoById(atributos.localidadClass, localidad);

    }

    public void insertarTel1(String tel1) {
        driver.introDatosInputByCss(atributos.labelValueTel1Css, tel1);
//        validations.validarTextoById(atributos.tel1class, tel1);
    }

    public void insertarTel2(String tel2) {
        driver.introDatosInputByCss(atributos.labelValueTel2Css, tel2);
//        validations.validarTextoById(atributos.tel2class, tel2);
    }


    public ClienteSteps(){
        validaciones = new ClienteValidacionesSteps();
        atributos = new ClienteAtributos();
        driver = new ADriverUtils();
    }

    private ClienteValidacionesSteps validaciones;
    private ClienteAtributos atributos;
    private ADriverUtils driver;

    @Override
    public ClienteValidacionesSteps getValidations() {
        return validaciones;
    }

    @Override
    protected ADriverUtils getDriverUtils() {
        return driver;
    }

    @Override
    public ClienteAtributos getAtributos() {
        return atributos;
    }


}
