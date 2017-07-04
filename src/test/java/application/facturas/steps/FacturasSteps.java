package application.facturas.steps;

import application.facturas.atributos.FacturasAtributos;
import application.facturas.validaciones.FacturasValidacionesSteps;
import application.main.AbstractSteps;
import application.menu_top.steps.MenuTopSteps;
import global_utils.AbstractStepsAndNavigation;
import global_utils.interfaces.GeneralStepsInterface;
import selenium_tools.ADriverUtils;

/**
 * Created by lleir on 16/6/17.
 */
public class FacturasSteps extends AbstractStepsAndNavigation<FacturasAtributos, FacturasValidacionesSteps> implements GeneralStepsInterface {

    public void clickEnMenuFacturas() {
        driver.writeStep(driver.getNameMethod());
        menuSteps.clickEnFacturas();
        validations.validarPantallaListado(validations.isDetailed());
    }


    public void insertarCodigo(String codigo) {

    }

    public void insertarFecha(String fecha) {

    }

    public void seleccionarCliente(String cliente) {

    }

    public void anadirDescripcionConcepto(String concepto) {

    }

    public void seleccionarTipoConcepto(String tipo) {

    }


    @Override
    public void crear() {
        driver.writeStep(driver.getNameMethod());
        driver.waitForElementPresentWithCss(atributos.selectorBtnCrear);
        validations.validarExistenciaButtonCrearFactura(validations.isDetailed());
        driver.clickByCss(atributos.selectorBtnCrear);
        validations.validarPantallaCreacion(validations.isDetailed());
    }

    @Override
    public void volver() {
        driver.writeStep(driver.getNameMethod());
        validations.validarExistenciaButtonVolverAtras(validations.isDetailed());
        driver.clickByCss(atributos.btnVolverId);
        validations.validarPantallaCreacion(validations.isDetailed());
    }

    @Override
    public void filtrar() {
        driver.writeStep(driver.getNameMethod());
        validations.validarExistenciaButtonFiltrar(validations.isDetailed());
        driver.clickButtonById(atributos.btnFiltrarId);
        validations.validarPantallaCreacion(validations.isDetailed());
    }

    @Override
    public void editarDatos() {
        driver.writeStep(driver.getNameMethod());
        validations.validarExistenciaButtonCrearFactura(validations.isDetailed());
        driver.clickButtonById(atributos.btnEditarId);
        validations.validarPantallaCreacion(validations.isDetailed());
    }

    @Override
    public void guardarDatos() {
        driver.writeStep(driver.getNameMethod());
        validations.validarExistenciaButtonGuardarDatos(validations.isDetailed());
        driver.clickButtonById(atributos.btnCrearId);
    }

    @Override
    public void cancelarDatos() {
        driver.writeStep(driver.getNameMethod());
        validations.validarExistenciaButtonCrearFactura(validations.isDetailed());
        driver.clickButtonById(atributos.btnCrearId);
    }

    @Override
    public void editarEnListado(String id) {

    }

    @Override
    public void eliminar(String id) {

    }




    private FacturasValidacionesSteps validations;
    private FacturasAtributos atributos;
    private ADriverUtils driver;
    private MenuTopSteps menuSteps;

    public FacturasSteps (){
        validations = new FacturasValidacionesSteps();
        atributos = new FacturasAtributos();
        driver = new ADriverUtils();
        menuSteps = new MenuTopSteps();
    }

    @Override
    public FacturasValidacionesSteps getValidations() {
        return null;
    }

    @Override
    protected ADriverUtils getDriverUtils() {
        return driver;
    }

    @Override
    public FacturasAtributos getAtributos() {
        return atributos;
    }

    @Override
    public MenuTopSteps getMenuSteps() {
        return menuSteps;
    }

}
