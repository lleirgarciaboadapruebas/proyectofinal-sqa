package application.facturas.main.steps;

import application.facturas.main.atributos.FacturasAtributos;
import application.facturas.main.validaciones.FacturasValidacionesSteps;
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

    public void seleccionarCliente(String cliente) {
        driver.writeStep(driver.getNameMethod());
        driver.selecTextById(atributos.comboClienteId, cliente);
        // validar
    }

    public void escribirCodigo(String codigo) {
        driver.writeStep(driver.getNameMethod());
        driver.introDatosInputByCss(atributos.inputCodigoCss, codigo);
        // validar
    }

    public void escribirFecha(String fecha) {
        driver.writeStep(driver.getNameMethod());
        driver.introDatosInputByCss(atributos.inputFechaCss, fecha);
        // validar
    }

    public void seleccionarEstado(String estado) {
        driver.writeStep(driver.getNameMethod());
        driver.introDatosInputByCss(atributos.comboEstadoCss, estado);
    }

    public void escribirIva(String iva) {
        driver.writeStep(driver.getNameMethod());
        driver.introDatosInputByCss(atributos.inputIvaCss, iva);
    }

    public void escribirPrecioHoraGeneral(String precioHora) {
        driver.writeStep(driver.getNameMethod());
        driver.introDatosInputByCss(atributos.inputPrecioHoraCss, precioHora);
    }

    public void seleccionarCoche(String coche) {
        driver.writeStep(driver.getNameMethod());
        driver.selecTextById(atributos.comboVehiculoId, coche);
    }


    // conceptos

    public void seleccionarTipoConcepto(String tipo) {
        driver.writeStep(driver.getNameMethod());
        driver.selecTextById(atributos.comboTipoConceptoId, tipo);
    }

    public void escribirDescripcionConcepto(String descripcion) {
        driver.writeStep(driver.getNameMethod());
        driver.introDatosInputById(atributos.textAreaDescripcionConceptoId, descripcion);
    }

    public void escribirCantidadOHorasConcepto(String cantidad_horas) {
        driver.writeStep(driver.getNameMethod());
        driver.introDatosInputByCss(atributos.inputHorasCantidadConceptoCss, cantidad_horas);
    }

    public void escribirPrecioConcepto(String precio) {
        driver.writeStep(driver.getNameMethod());
        driver.introDatosInputByCss(atributos.inputPrecioConceptoCss, precio);
    }

    public void clickEnButtonAnadirConcepto() {
        driver.writeStep(driver.getNameMethod());
        driver.clickById(atributos.buttonAnadirConceptoId);
    }

    public void clickEnEditarConcepto(String descripcionConcepto) {
        driver.writeStep(driver.getNameMethod());

        // buscar elemento en tabla
    }

    public void clickEnGuardarConcepto(String descripcionConcepto) {
        driver.writeStep(driver.getNameMethod());

        // buscar elemento en tabla
    }

    public void clickEnEliminarConcepto(String descripcionConcepto) {

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
