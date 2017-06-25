package application.menu_top.steps;

import application.menu_top.atributos.MenuTopAtributos;
import application.menu_top.validations.MenuTopValidationSteps;
import global_utils.AbstractSteps;
import selenium_tools.ADriverUtils;
import selenium_tools.DriverUtils;

/**
 * Created by lleir on 25/6/17.
 */
public class MenuTopSteps extends AbstractSteps<MenuTopAtributos, MenuTopValidationSteps> {

    public void clickEnFacturas(){
        driver.writeStep(driver.getNameMethod());
        validations.validarMenuFacturasExistente(validations.isDetailed());
        driver.clickById(atributos.liFacturaId);
    }

    public void clickEnClientes() {
        driver.writeStep(driver.getNameMethod());
        validations.validarMenuClientesExistente(validations.isDetailed());
        driver.clickById(atributos.liClienteId);
    }

    public void clickEnCoches() {
        driver.writeStep(driver.getNameMethod());
        validations.validarMenuCochesExistente(validations.isDetailed());
        driver.clickById(atributos.liCocheId);
    }


    private MenuTopValidationSteps validations;
    private ADriverUtils driver;
    private MenuTopAtributos atributos;

    public MenuTopSteps(){
        validations = new MenuTopValidationSteps();
        atributos = new MenuTopAtributos();
        driver = new ADriverUtils();
    }

    @Override
    public MenuTopValidationSteps getValidations() {
        return validations;
    }

    @Override
    protected ADriverUtils getDriverUtils() {
        return driver;
    }

    @Override
    protected MenuTopAtributos getAtributos() {
        return atributos;
    }
}
