package application.coches.main.steps;

import application.coches.main.validaciones.CocheValidacionesSteps;
import global_utils.AbstractStepsProcess;

/**
 * Created by lleir on 16/6/17.
 */
public class CochesStepsProcess extends AbstractStepsProcess<CochesSteps, CocheValidacionesSteps> {

    public void irListadoCoches() {
        steps.clickEnMenuCoches();
    }

    public void crearCoche(String matricula, String marca, String modelo, String kmActuales, String numBastidor, String cliente){
        irListadoCoches();
        steps.crear();
        steps.insertarMatricula(matricula);
        steps.insertarMarca(marca);
        steps.insertarModelo(modelo);
        steps.insertarKmActuales(kmActuales);
        steps.insertarNumBastidor(numBastidor);
        steps.seleccionarCliente(cliente);
        steps.guardarDatos();
    }

    public void editarCoche(String matricula, String newMatricula, String marca, String modelo, String kmActuales, String numBastidor, String cliente){
        irListadoCoches();
        steps.editarEnListado(matricula);
        steps.insertarMatricula(matricula);
        steps.insertarMarca(marca);
        steps.insertarModelo(modelo);
        steps.insertarKmActuales(kmActuales);
        steps.insertarNumBastidor(numBastidor);
        steps.seleccionarCliente(cliente);
    }

    public void eliminarCoche(String matricula){
        irListadoCoches();
        steps.eliminar(matricula);
    }

    public void filtrarPor(String modelo, String marca, String matricula, String nombreOApellido){
        irListadoCoches();
        steps.insertarModeloEnFiltro(modelo);
        steps.insertarMarcaEnFiltro(marca);
        steps.insertarMatriculaEnFiltro(matricula);
        steps.insertarNombreOApellido(nombreOApellido);
        steps.filtrar();
    }

    private CochesSteps steps;
    private CocheValidacionesSteps validations;

    public CochesStepsProcess() {
        steps = new CochesSteps();
        validations = new CocheValidacionesSteps();
    }
    
    @Override
    public CochesSteps getSteps() {
        return steps;
    }

    @Override
    public CocheValidacionesSteps getValidations() {
        return validations;
    }
}
