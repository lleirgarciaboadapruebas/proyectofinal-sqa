package application.coches.main.steps;

import application.coches.main.atributos.CochesAtributos;
import application.coches.main.validaciones.CocheValidacionesSteps;
import application.menu_top.steps.MenuTopSteps;
import application.menu_top.validations.MenuTopValidationSteps;
import global_utils.AbstractSteps;
import global_utils.AbstractStepsAndNavigation;
import global_utils.interfaces.GeneralStepsInterface;
import selenium_tools.ADriverUtils;
import selenium_tools.DriverUtils;

/**
 *  @author Lleir Garcia -- lleirgarica@gmail.com
 */
public class CochesSteps extends AbstractStepsAndNavigation<CochesAtributos, CocheValidacionesSteps> implements GeneralStepsInterface {

    public void clickEnMenuCoches() {
        driver.writeStep(driver.getNameMethod());
        menuSteps.clickEnCoches();
        validations.validarPantallaListado(validations.isDetailed());
    }

    @Override
    public void crear(){
        driver.writeStep(driver.getNameMethod());
        validations.validarExistenciaButtonCrearCoche(validations.isDetailed());
        driver.clickButtonById(atributos.btnCrearId);
        validations.validarPantallaCreacion(validations.isDetailed());
    }

    @Override
    public void volver() {
        driver.writeStep(driver.getNameMethod());
        validations.validarExistenciaButtonVolverAtras(validations.isDetailed());
        driver.clickButtonById(atributos.btnVolverId);
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
        validations.validarExistenciaButtonCrearCoche(validations.isDetailed());
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
        validations.validarExistenciaButtonCrearCoche(validations.isDetailed());
        driver.clickButtonById(atributos.btnCrearId);
    }

    @Override
    public void editarEnListado(String id) {
        driver.writeStep(driver.getNameMethod());
        validations.validarExistenciaButtonCrearCoche(validations.isDetailed());
        driver.clickButtonById(atributos.btnCrearId);
        validations.validarPantallaCreacion(validations.isDetailed());
    }

    @Override
    public void eliminar(String id) {
        driver.writeStep(driver.getNameMethod());
    }

    /** Escribo matricula. */
    public void insertarMatricula(String matricula){
        driver.writeStep(driver.getNameMethod());
        validations.validarCampoExistenteMatricula(validations.isDetailed());
        driver.introDatosInputById(getAtributos().matriculaClass, matricula);
    }

    /** Escribo marca. */
    public void insertarMarca(String marca){
        driver.writeStep(driver.getNameMethod());
        validations.validarCampoExistenteMarca(validations.isDetailed());
        driver.introDatosInputByClass(getAtributos().marcaClass, marca);
    }

    /** Escribo modelo. */
    public void insertarModelo(String modelo){
        driver.writeStep(driver.getNameMethod());
        validations.validarCampoExistenteModelo(validations.isDetailed());
        driver.introDatosInputByClass(getAtributos().modeloClass, modelo);
    }

    /** Escribo km actuales. */
    public void insertarKmActuales(String kmActuales){
        driver.writeStep(driver.getNameMethod());
        validations.validarCampoExistenteKmActuales(validations.isDetailed());
        driver.introDatosInputByClass(getAtributos().kmActualesClass, kmActuales);
    }

    /** Escribo num bastidor. */
    public void insertarNumBastidor(String numBastidor){
        driver.writeStep(driver.getNameMethod());
        validations.validarCampoExistenteNumBastidor(validations.isDetailed());
        driver.introDatosInputByClass(getAtributos().numBastidorClass, numBastidor);
    }

    public void seleccionarCliente(String cliente) {
        driver.writeStep(driver.getNameMethod());
        validations.validarCampoExistenteCliente(validations.isDetailed());
        driver.selecTextByClass(getAtributos().matriculaClass, cliente);
        validations.validarCliente(cliente);
    }

    private CocheValidacionesSteps validations;
    private CochesAtributos atributos;
    private MenuTopSteps menuSteps;
    private ADriverUtils driver;

    public CochesSteps() {
        validations = new CocheValidacionesSteps();
        atributos = new CochesAtributos();
        driver = new ADriverUtils();
        menuSteps = new MenuTopSteps();
    }



    @Override
    public CocheValidacionesSteps getValidations() {
        return validations = validations == null ? new CocheValidacionesSteps() : validations;
    }

    @Override
    protected ADriverUtils getDriverUtils() {
        return driver;
    }

    @Override
    public CochesAtributos getAtributos() {
        return atributos;
    }

    @Override
    public MenuTopSteps getMenuSteps() {
        return menuSteps;
    }
}
