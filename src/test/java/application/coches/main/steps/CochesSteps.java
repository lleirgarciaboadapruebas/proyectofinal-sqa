package application.coches.main.steps;

import application.coches.main.atributos.CochesAtributos;
import application.coches.main.validaciones.CocheValidacionesSteps;
import application.menu_top.steps.MenuTopSteps;
import global_utils.AbstractStepsAndNavigation;
import global_utils.interfaces.GeneralStepsInterface;
import org.apache.commons.codec.binary.StringUtils;
import org.openqa.selenium.WebElement;
import selenium_tools.ADriverUtils;
import sun.swing.StringUIClientPropertyKey;

import java.util.List;

/**
 *  @author Lleir Garcia -- lleirgarica@gmail.com
 */
public class CochesSteps extends AbstractStepsAndNavigation<CochesAtributos, CocheValidacionesSteps> implements GeneralStepsInterface {

    public void clickEnMenuCoches() {
        driver.writeStep(driver.getNameMethod());
        menuSteps.clickEnCoches();
        driver.waitForElementPresentWithId(atributos.btnCrearId);
        validations.validarPantallaListado(validations.isDetailed());
    }

    public void crear(){
        driver.writeStep(driver.getNameMethod());
        driver.waitForElementPresentWithId(atributos.btnCrearId);
        validations.validarExistenciaButtonCrearCoche(validations.isDetailed());
        driver.clickByCss(atributos.selectorBtnCrear);
        validations.validarPantallaCreacion(validations.isDetailed());
    }

    public void volver() {
        driver.writeStep(driver.getNameMethod());
        validations.validarExistenciaButtonVolverAtras(validations.isDetailed());
        driver.clickByCss(atributos.btnVolverId);
        validations.validarPantallaCreacion(validations.isDetailed());
    }

    public void insertarModeloEnFiltro(String modelo) {
        driver.writeStep(driver.getNameMethod());
        driver.introDatosInputByName(atributos.inputModeloFiltroName, modelo);
    }

    public void insertarMarcaEnFiltro(String marca) {
        driver.writeStep(driver.getNameMethod());
        driver.introDatosInputByName(atributos.inputMarcaFiltroName, marca);

    }

    public void insertarMatriculaEnFiltro(String matricula) {
        driver.writeStep(driver.getNameMethod());
        driver.introDatosInputByName(atributos.inputMatriculaFiltroName, matricula);
    }

    public void insertarNombreOApellido(String nombreOApellidos) {
        driver.writeStep(driver.getNameMethod());
        driver.introDatosInputByName(atributos.inputNombreFiltroName, nombreOApellidos);
    }

    public void filtrar() {
        driver.writeStep(driver.getNameMethod());
        validations.validarExistenciaButtonFiltrar(validations.isDetailed());
        driver.clickButtonById(atributos.btnFiltrarId);
        validations.validarPantallaCreacion(validations.isDetailed());
    }

    public void editarDatos() {
        driver.writeStep(driver.getNameMethod());
        validations.validarExistenciaButtonCrearCoche(validations.isDetailed());
        driver.clickButtonById(atributos.btnEditarId);
        validations.validarPantallaCreacion(validations.isDetailed());
    }

    public void guardarDatos() {
        driver.writeStep(driver.getNameMethod());
        validations.validarExistenciaButtonGuardarDatos(validations.isDetailed());
        driver.clickById(atributos.btnGuardarId);
    }

    public void cancelarDatos() {
        driver.writeStep(driver.getNameMethod());
        validations.validarExistenciaButtonCrearCoche(validations.isDetailed());
        driver.clickById(atributos.btnCrearId);
    }

    public void editarEnListado(String matricula) {
        driver.writeStep(driver.getNameMethod());
        List<WebElement> trs = driver.findElementsByCss(atributos.selectorTableListado);
        WebElement linkEdicion = null;
        for (WebElement tr : trs)
            if (StringUtils.equals(tr.getText(), matricula))
                linkEdicion = driver.findElementByCss(tr, atributos.selectorTableEdition);

        driver.clickWebElement(linkEdicion);
        validations.validarPantallaVista(validations.isDetailed());
    }

    public void eliminar(String id) {
        driver.writeStep(driver.getNameMethod());
    }

    /** Escribo matricula. */
    public void insertarMatricula(String matricula){
        driver.writeStep(driver.getNameMethod());
        validations.validarCampoExistenteMatricula(validations.isDetailed());
        driver.introDatosInputByCss(getAtributos().labelValueMatriculaCss, matricula);
    }

    /** Escribo marca. */
    public void insertarMarca(String marca){
        driver.writeStep(driver.getNameMethod());
        validations.validarCampoExistenteMarca(validations.isDetailed());
        driver.introDatosInputByCss(getAtributos().labelValueMarcaCss, marca);
    }

    /** Escribo modelo. */
    public void insertarModelo(String modelo){
        driver.writeStep(driver.getNameMethod());
        validations.validarCampoExistenteModelo(validations.isDetailed());
        driver.introDatosInputByCss(getAtributos().labelValueModeloCss, modelo);
    }

    /** Escribo km actuales. */
    public void insertarKmActuales(String kmActuales){
        driver.writeStep(driver.getNameMethod());
        validations.validarCampoExistenteKmActuales(validations.isDetailed());
        driver.introDatosInputByCss(getAtributos().labelValueKmActualesCss, kmActuales);
    }

    /** Escribo num bastidor. */
    public void insertarNumBastidor(String numBastidor){
        driver.writeStep(driver.getNameMethod());
        validations.validarCampoExistenteNumBastidor(validations.isDetailed());
        driver.introDatosInputByCss(getAtributos().labelValueNumBastidorCss, numBastidor);
    }

    public void seleccionarCliente(String cliente) {
        driver.writeStep(driver.getNameMethod());
        validations.validarCampoExistenteCliente(validations.isDetailed());
        driver.selecTextById(getAtributos().selectClienteId, cliente);
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
