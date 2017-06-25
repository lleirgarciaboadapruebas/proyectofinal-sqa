package application.menu_top.validations;

import application.clientes.main.ClienteValidacionesProcesosAction;
import application.menu_top.atributos.MenuTopAtributos;
import global_utils.AbstractValidations;

/**
 * Created by lleir on 25/6/17.
 */
public class MenuTopValidationStepsProcess extends AbstractValidations<MenuTopAtributos> {

    public void validarPantallaListadoClientes(boolean isDetailed){

    }

    public void validarPantallaListadoFacturas(boolean isDetailed){

    }

    public void validarPantallaListadoCoches(boolean isDetailed){

    }

    private MenuTopAtributos atributos;

    public MenuTopValidationStepsProcess() {
        atributos = new MenuTopAtributos();
    }

    @Override
    protected MenuTopAtributos getAtributos() {
        return atributos;
    }


}
