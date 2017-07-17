package application.menu_top.steps;

import application.menu_top.validations.MenuTopValidationStepsProcess;
import global_utils.AbstractStepsProcess;

/**
 * Created by lleir on 25/6/17.
 */
public class MenuTopStepsProcess extends AbstractStepsProcess<MenuTopSteps, MenuTopValidationStepsProcess> {

    private MenuTopSteps steps = new MenuTopSteps();
    private MenuTopValidationStepsProcess validations = new MenuTopValidationStepsProcess();

    public void clickEnClientes(){
        steps.clickEnClientes();
//        validations.validarPantallaListadoClientes(validations.isDetailed());
    }

    public void clickEnFacturas(){
        steps.clickEnFacturas();
//        validations.validarPantallaListadoFacturas(validations.isDetailed());
    }

    public void clickEnCoches(){
        steps.clickEnCoches();
//        validations.validarPantallaListadoCoches(validations.isDetailed());
    }

    @Override
    public MenuTopSteps getSteps() {
        return steps;
    }

    @Override
    public MenuTopValidationStepsProcess getValidations() {
        return validations;
    }

}
