package application.coches.main.interfaces;

import application.clientes.main.steps.ClienteProcessSteps;
import application.coches.main.steps.CochesSteps;
import application.coches.main.steps.CochesStepsProcess;
import application.coches.main.validaciones.CocheValidacionesSteps;
import application.coches.main.validaciones.CochesValidacionesProcesosAction;

/**
 * Created by lleir on 19/6/17.
 */
public interface CocheStepInterface {

    public CochesStepsProcess getStepsProcess();
    public CochesValidacionesProcesosAction getValidationsProcess();
    public ClienteProcessSteps getStepsProcessCliente();
}
