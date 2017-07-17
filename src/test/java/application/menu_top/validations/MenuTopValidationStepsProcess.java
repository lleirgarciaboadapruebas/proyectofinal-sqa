package application.menu_top.validations;

import application.menu_top.atributos.MenuTopAtributos;
import global_utils.AbstractValidations;

/**
 * Created by lleir on 25/6/17.
 */
public class MenuTopValidationStepsProcess extends AbstractValidations<MenuTopAtributos> {


    private MenuTopAtributos atributos;

    public MenuTopValidationStepsProcess() {
        atributos = new MenuTopAtributos();
    }

    @Override
    protected MenuTopAtributos getAtributos() {
        return atributos;
    }


}
