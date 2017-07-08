package application.coches.main.validaciones;

import org.openqa.selenium.WebElement;

import application.coches.main.atributos.CochesAtributos;
import global_utils.AbstractValidations;

/**
 * Created by lleir on 16/6/17.
 */
public class CocheValidacionesSteps extends AbstractValidations<CochesAtributos> {

    /**Valido pantalla de listado coches. */
    public void validarPantallaListado(boolean isDetailed){
        validarTituloEncabezado(isDetailed);
        validarExistenciaButtonCrearCoche(isDetailed);
        validarExistenciaTabla(isDetailed);
        validarFiltroModelo(isDetailed);
        validarFiltroMarca(isDetailed);
        validarFiltroMatricula(isDetailed);
        validarFiltroNombreApellido(isDetailed);
    }
    

    private void validarFiltroModelo(boolean isDetailed) {
        if (isDetailed)
            validarCampoExistenteByName(atributos.inputModeloFiltroName);
    }
    
    private void validarFiltroMarca(boolean isDetailed) {
        if (isDetailed)
            validarCampoExistenteByName(atributos.inputMarcaFiltroName);
    }
    
    private void validarFiltroMatricula(boolean isDetailed) {
        if (isDetailed)
            validarCampoExistenteByName(atributos.inputMatriculaFiltroName);
    }
    
    private void validarFiltroNombreApellido(boolean isDetailed) {
        if (isDetailed)
            validarCampoExistenteByName(atributos.inputNombreFiltroName);
    }

    /**
     * Valido campos existentes en pantalla creacion.
     */
    public void validarPantallaCreacion(boolean isDetailed) {
        validarCampoExistenteMatricula(isDetailed);
        validarCampoExistenteModelo(isDetailed);
        validarCampoExistenteMarca(isDetailed);
        validarCampoExistenteKmActuales(isDetailed);
        validarCampoExistenteCliente(isDetailed);

        // validar inputs
    }

    /**
     * valida campos existentes en pantalla vista de un coche.
     */
    public void validarPantallaVista(boolean isDetailed) {
        if (isDetailed)
            validarPantallaCreacion(isDetailed);
    }

    public void validarPantallaModificacion(boolean isDetailed) {
        if (isDetailed)
            validarPantallaCreacion(isDetailed);
    }

    public void validarExistenciaButtonCrearCoche(boolean isDetailed) {
        if (isDetailed)
            esVisible(getDriverUtils().getByUtils().byId(atributos.selectorBtnCrear));
    }

    public void validarExistenciaTabla(boolean isDetailed){
        if(isDetailed)
            esVisible(getDriverUtils().getByUtils().byId(atributos.tableid));
    }

    public void validarExistenciaButtonVolverAtras(boolean isDetailed){
        if(isDetailed)
            esVisible(getDriverUtils().getByUtils().byId(atributos.btnVolverId));
    }

    public void validarExistenciaButtonGuardarDatos(boolean isDetailed){
        if(isDetailed)
            esVisible(getDriverUtils().getByUtils().byId(atributos.btnVolverId));
    }

    public void validarExistenciaButtonFiltrar(boolean isDetailed){
        if(isDetailed)
            esVisible(getDriverUtils().getByUtils().byId(atributos.btnFiltrarId));
    }


    public void validarTituloEncabezado(boolean isDetailed){
        if(isDetailed)
            validarTextoByClass(atributos.labelTitleClass, atributos.labelTitleText,
                    "Se esperaba el titulo '"+ atributos.labelTitleText + "' pero no coincidió.");
    }

    
    public void validarCampoExistenteMatricula(boolean isDetailed){
        if(isDetailed)
            validarCampoExistenteById(atributos.labelMatriculaClass);
    }

    public void validarCampoExistenteMarca(boolean isDetailed){
        if(isDetailed)
            validarCampoExistenteById(atributos.labelMarcaClass);
    }

    public void validarCampoExistenteModelo(boolean isDetailed){
        if(isDetailed)
            validarCampoExistenteById(atributos.labelModeloClass);
    }

    public void validarCampoExistenteKmActuales(boolean isDetailed){
        if(isDetailed)
            validarCampoExistenteById(atributos.labelKmActualesClass);
    }

    public void validarCampoExistenteCliente(boolean isDetailed){
        if (isDetailed)
            validarCampoExistenteById(atributos.selectClienteId);
    }

    public void validarCampoExistenteNumBastidor(boolean isDetailed){
        if(isDetailed)
            validarCampoExistenteById(atributos.labelNumBastidorClass);
    }



    public void validarMatricula(boolean isDetailed, String expectedMatricula){
        if(isDetailed)
            validarTextoById(atributos.labelMatriculaClass, expectedMatricula);
    }

    public void validarMarca(boolean isDetailed, String expectedMarca){
        if(isDetailed)
            validarTextoById(atributos.labelMarcaClass, expectedMarca);
    }

    public void validarModelo(boolean isDetailed, String expectedModelo){
        if(isDetailed)
            validarTextoById(atributos.labelModeloClass, expectedModelo);
    }

    public void validarKmActuales(boolean isDetailed, String expectedkm){
        if(isDetailed)
            validarTextoById(atributos.labelKmActualesClass, expectedkm);
    }

    public void validarCliente(boolean isDetailed, String expectedClient){
        if (isDetailed)
            validarTextoById(atributos.selectClienteId, expectedClient);
    }


    public void validarCreacionEnListado(String matricula) {
        // buscar texto en listado
    }

    public void validarCocheSeleccionableEnCreacionFactura(String coche) {
        // cojer todoo el combo y mirar
    }

    public void validarClienteSeleccionableEnCreacionCoche(String cliente) {
        validarOptionDisponibleEnCombo(atributos.selectClienteId, cliente);
    }

    public void validarFiltrado(boolean isDetailed, String filtroAplicado, String textoExpected) {
//        if(isDetailed)
        // validar filtrado segun campo
        // segun el filtroAplicado se cogera un <td> u otro (podria hacer mas metodos "validarFiltradoXXXX"
        // coger y mirar si todas las filas son del textExpected.

    }


    private CochesAtributos atributos;
    

    public CocheValidacionesSteps () {
        atributos = new CochesAtributos();
    }

    @Override
    protected CochesAtributos getAtributos() {
        return atributos;
    }

    public void validarCocheEnListado(String matricula, String marca, String modelo, boolean isDetailed) {
    	 if (isDetailed) {

             WebElement tr = getDriverUtils().devolverWebElement(atributos.selectorTabla, "td:nth-child(1)", "td:nth-child(2)", "td:nth-child(3)", modelo, marca, matricula);
             if (tr == null)
                 error("No se ha encontrado el Vehiculo con con matricula '"+ matricula +"' de la marca y modelo '"+ marca +"' '"+ modelo +"'.");
             else
             	getDriverUtils().writeStepValidation("Se ha encontrado el Vehiculo con con matricula '"+ matricula +"' de la marca y modelo '"+ marca +"' '"+ modelo +"'.");
         }
    	
    }
}
