package global_utils;

import selenium_tools.ADriverUtils;
import selenium_tools.DriverUtils;

/**
 * Created by lleir on 25/6/17.
 */
public abstract class AbstractBaseUtils<AtributosPantalla> {

    protected abstract ADriverUtils getDriverUtils();
    protected abstract AtributosPantalla getAtributos();

}
