package application.menu_top.validations;

import application.menu_top.atributos.MenuTopAtributos;
import global_utils.AbstractValidations;

/**
 * Created by lleir on 25/6/17.
 */
public class MenuTopValidationSteps extends AbstractValidations<MenuTopAtributos> {

    public void validarMenuFacturasSeleccionado(boolean isDetailed){
        if(isDetailed)
            validarAtributoCampoById(atributos.liFacturaId, "class", atributos.liMenuSelectedClass,
                "El menu top 'Coches' no esta seleccionado.");
    }

    public void validarMenuClienteSeleccionado(boolean isDetailed){
        if(isDetailed)
            validarAtributoCampoById(atributos.liFacturaId, "class", atributos.liMenuSelectedClass,
                    "El menu top 'Coches' no esta seleccionado.");
    }

    public void validarMenuCochesSeleccionado(boolean isDetailed){
        if(isDetailed)
            validarAtributoCampoById(atributos.liFacturaId, "class", atributos.liMenuSelectedClass,
                    "El menu top 'Coches' no esta seleccionado.");
    }

    public void validarMenuFacturasExistente(boolean isDetailed){
        if(isDetailed)
            validarAtributoCampoById(atributos.liFacturaId, "class", atributos.liMenuSelectedClass, "No existe el li menu Facturas. ");
    }

    public void validarMenuClientesExistente(boolean isDetailed){
        if(isDetailed)
            validarAtributoCampoById(atributos.liClienteId, "class", atributos.liMenuSelectedClass, "No existe el li menu Clientes. ");
    }

    public void validarMenuCochesExistente(boolean isDetailed){
        if(isDetailed)
            validarAtributoCampoById(atributos.liCocheId, "class", atributos.liMenuSelectedClass, "No existe el li menu Coches. ");
    }

    public void validarPantallaListadoFacturas(boolean isDetailed){
        if(isDetailed) {
            validarAtributoCampoById(atributos.liFacturaId, "class", atributos.liMenuSelectedClass,
                    "El menu top 'Facturas' no esta seleccionado.");
            validarTextoByClass(atributos.labelTituloEncabezadoClass, atributos.labelTextoEncabezadoFacturas,
                    "Se esperaba el texto List '" + atributos.labelTextoEncabezadoFacturas +" en la cabezera pero se encontró '"+ getDriverUtils().getTextoByClass(atributos.labelTituloEncabezadoClass) + "'");
            // desde donde valido pantalla?? mirarlo en Arquia
        }
    }

    public void validarPantallaListadoClientes(boolean isDetailed){

    }

    public void validarPantallaListadoCoches(boolean isDetailed){

    }

    private MenuTopAtributos atributos;

    public MenuTopValidationSteps(){
        atributos = new MenuTopAtributos();
    }

    @Override
    protected MenuTopAtributos getAtributos() {
        return null;
    }
}
