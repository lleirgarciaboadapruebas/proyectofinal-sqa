package application.coches.main.validaciones;

import application.coches.main.atributos.CochesAtributos;
import global_utils.AbstractValidations;

/**
 * Created by lleir on 16/6/17.
 */
public class CocheValidacionesSteps extends AbstractValidations<CochesAtributos> {

    /**Valido pantalla de listado coches. */
    public void validarPantallaListado(boolean isDetailed){
        if(isDetailed) {
            validarTituloEncabezado(isDetailed);
            validarExistenciaButtonCrearCoche(isDetailed);
            validarExistenciaTablaCoches(isDetailed);
        }
    }

    public void validarExistenciaButtonCrearCoche(boolean isDetailed) {
        if(isDetailed)
            esVisible(getDriverUtils().getByUtils().byId(atributos.btnCrearId));
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

    /** Valido campos existentes en pantalla creacion. */
    public void validarPantallaCreacion(boolean isDetailed){
            validarCampoExistenteMatricula(isDetailed);
            validarCampoExistenteModelo(isDetailed);
            validarCampoExistenteMarca(isDetailed);
            validarCampoExistenteKmActuales(isDetailed);
            validarCampoExistenteCliente(isDetailed);
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
        if(isDetailed)
            validarCampoExistenteById(atributos.clienteClass);
    }

    public void validarCampoExistenteNumBastidor(boolean isDetailed){
        if(isDetailed)
            validarCampoExistenteById(atributos.numBastidorClass);
    }



    public void validarMatricula(String expectedMatricula){

    }

    public void validarMarca(String expectedMarca){

    }

    public void validarModelo(String expectedModelo){

    }

    public void validarKmActuales(String expectedkm){

    }

    public void validarCliente(String expectedClient){

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
