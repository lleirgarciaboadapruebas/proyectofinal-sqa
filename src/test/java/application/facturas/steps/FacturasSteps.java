package application.facturas.steps;

import application.facturas.FacturasAtributos;
import application.main.AbstractSteps;
import selenium_tools.ADriverUtils;
import selenium_tools.DriverUtils;

/**
 * Created by lleir on 16/6/17.
 */
public class FacturasSteps extends AbstractSteps<FacturasAtributos, FacturasValidacionesSteps> {

    private FacturasValidacionesSteps validations;
    private FacturasAtributos atributos;
    private ADriverUtils driverUtils;

    public FacturasSteps (){
        validations = new FacturasValidacionesSteps();
        atributos = new FacturasAtributos();
        driverUtils = new ADriverUtils();
    }

    @Override
    public FacturasValidacionesSteps getValidations() {
        return null;
    }

    @Override
    protected ADriverUtils getDriverUtils() {
        return driverUtils;
    }

    @Override
    public FacturasAtributos getAtributos() {
        return null;
    }

}
