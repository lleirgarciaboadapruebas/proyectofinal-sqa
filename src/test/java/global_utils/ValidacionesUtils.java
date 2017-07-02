package global_utils;

import org.apache.commons.lang3.StringUtils;

import selenium_tools.ADriverUtils;

/**
 * Created by lleir on 15/6/17.
 */
public abstract class ValidacionesUtils<Atributos>  extends AbstractBaseUtils<Atributos>{

    private ADriverUtils driver;

    public void validarCampoExistenteById(String id){
        if(!getDriverUtils().isElementVisible(getDriverUtils().getByUtils().byId(id)))
            error("El campo '"+ id +"' no se visualiza.");
    }

    public void validarValueById(String id, String expected){
        if(getDriverUtils().isElementVisible(getDriverUtils().getByUtils().byId(id))) {
            String strText = getDriverUtils().getValueById(id);
            if (!StringUtils.equals(getDriverUtils().getValueById(id), expected))
                error("Se esperaba el texto '" + expected + "' y se encontró '" +strText +"'");

        }
    }

    public void validarTextoById(String id, String expected){
        if(getDriverUtils().isElementVisible(getDriverUtils().getByUtils().byId(id))) {
            String strText = getDriverUtils().getTextoById(id);
            if (!StringUtils.equals(getDriverUtils().getValueById(id), expected))
                error("Se esperaba el texto '" + expected + "' y se encontró '" +strText +"'");

        }
    }

    public void validarTextoByClass(String clas, String expected){
        if(getDriverUtils().isElementVisible(getDriverUtils().getByUtils().byClass(clas))) {
            String strText = getDriverUtils().getTextoById(clas);
            if (!StringUtils.equals(getDriverUtils().getValueById(clas), expected))
                error("Se esperaba el texto '" + expected + "' y se encontró '" +strText +"'");

        }
    }

    public void validarTaxtoByBy(){

    }

    public void error(String error){
        getDriverUtils().writeLog(error);
    }


    @Override
    public ADriverUtils getDriverUtils() {
        return driver == null ? new ADriverUtils() : driver;
    }
    
}
