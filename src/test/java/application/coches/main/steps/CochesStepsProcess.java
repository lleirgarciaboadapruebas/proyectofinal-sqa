package application.coches.main.steps;

import application.coches.main.validaciones.CocheValidacionesSteps;
import application.coches.main.validaciones.CochesValidacionesProcesosAction;
import global_utils.AbstractStepsProcess;

/**
 * Created by lleir on 16/6/17.
 */
public class CochesStepsProcess extends AbstractStepsProcess<CochesSteps, CochesValidacionesProcesosAction>{

    public void irListadoCoches() {
        steps.clickEnMenuCoches();
    }

    private CochesSteps steps;
    private CochesValidacionesProcesosAction validations;

    @Override
    public CochesSteps getSteps() {
        return steps;
    }

    @Override
    public CochesValidacionesProcesosAction getValidations() {
        return validations;
    }
}
