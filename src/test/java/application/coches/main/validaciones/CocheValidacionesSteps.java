package application.coches.main.validaciones;

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
        validarExistenciaTablaCoches(isDetailed);
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
    }

    /**
     * valida campos existentes en pantalla vista de un coche.
     */
    public void validarPantallaVista(boolean isDetailed) {

    }

    public void validarPantallaModificacion(boolean isDetailed) {


    }

    public void validarExistenciaButtonCrearCoche(boolean isDetailed) {
        if (isDetailed)
            esVisible(getDriverUtils().getByUtils().byId(atributos.selectorBtnCrear));
    }

    public void validarExistenciaTablaCoches(boolean isDetailed){
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
            validarCampoExistenteById(atributos.matriculaClass);
    }

    public void validarCampoExistenteMarca(boolean isDetailed){
        if(isDetailed)
            validarCampoExistenteById(atributos.marcaClass);
    }

    public void validarCampoExistenteModelo(boolean isDetailed){
        if(isDetailed)
            validarCampoExistenteById(atributos.modeloClass);
    }

    public void validarCampoExistenteKmActuales(boolean isDetailed){
        if(isDetailed)
            validarCampoExistenteById(atributos.kmActualesClass);
    }

    public void validarCampoExistenteCliente(boolean isDetailed){
        if (isDetailed)
            validarCampoExistenteById(atributos.selectClienteId);
    }

    public void validarCampoExistenteNumBastidor(boolean isDetailed){
        if(isDetailed)
            validarCampoExistenteById(atributos.numBastidorClass);
    }



    public void validarMatricula(boolean isDetailed, String expectedMatricula){
        if(isDetailed)
            validarTextoById(atributos.matriculaClass, expectedMatricula);
    }

    public void validarMarca(boolean isDetailed, String expectedMarca){
        if(isDetailed)
            validarTextoById(atributos.marcaClass, expectedMarca);
    }

    public void validarModelo(boolean isDetailed, String expectedModelo){
        if(isDetailed)
            validarTextoById(atributos.modeloClass, expectedModelo);
    }

    public void validarKmActuales(boolean isDetailed, String expectedkm){
        if(isDetailed)
            validarTextoById(atributos.kmActualesClass, expectedkm);
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
}
