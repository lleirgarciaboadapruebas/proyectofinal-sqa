package application.facturas.main;

import application.facturas.main.steps.FacturasProcess;
import application.facturas.main.steps.FacturasSteps;
import application.facturas.main.validaciones.FacturasValidacionesSteps;

/**
 * Created by lleir on 6/7/17.
 */
public class Factura {

    public static FacturasProcess process = new FacturasProcess();
    public static FacturasSteps steps = new FacturasSteps();
    public static FacturasValidacionesSteps validaciones = new FacturasValidacionesSteps();

}
