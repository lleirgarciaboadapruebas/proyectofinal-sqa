package application.clientes.main.validaciones;

import org.openqa.selenium.WebElement;

import application.clientes.main.atributos.ClienteAtributos;
import global_utils.AbstractValidations;

/**
 * Created by lleir on 15/6/17.
 */
public class ClienteValidacionesSteps extends AbstractValidations<ClienteAtributos>{


    public void validarClienteEnListado(String nombre, String apellidos, String telefono) {
        if(isDetailed()){
        	WebElement tr_expected = getDriverUtils().devolverWebElement(atributos.selectorTabla, 
        			"td:nth-child(1)", "td:nth-child(2)", "td:nth-child(4)", nombre, apellidos, telefono);
        	
        	if(tr_expected == null)
        		error("No se ha encontrado el Cliente '"+ nombre +" "+ apellidos +"' con el telefono '"+ telefono +"' en el listado de clientes.");
        }
    }

    public void validarPantallaCreacion(boolean isDetailed) {
        validarCampoExistenteNif(isDetailed);
        validarCampoExistenteNombre(isDetailed);
        validarCampoExistenteApellidos(isDetailed);
        validarCampoExistenteDireccion(isDetailed);
        validarCampoExistenteLocalidad(isDetailed);
        validarCampoExistenteTelefonoPrincipal(isDetailed);
        validarCampoExistenteTelefonoSegundario(isDetailed);
    }

    public void validarPantallaListado(boolean isDetailed) {
        validarCampoExistenteTabla(isDetailed);
        validarCampoExistenteFiltroNombre(isDetailed);
        validarCampoExistenteFiltroApellido(isDetailed);
        validarCampoExistenteFiltroTelefono(isDetailed);
        validarCampoExistenteFiltroNif(isDetailed);
    }

    private void validarCampoExistenteTabla(boolean isDetailed) {
        if (isDetailed)
            validarCampoExistenteByClass(atributos.tablaClass);
    }

    private void validarCampoExistenteFiltroNombre(boolean isDetailed) {
        if (isDetailed)
            validarCampoExistenteById(atributos.nombreFiltro);
    }

    private void validarCampoExistenteFiltroApellido(boolean isDetailed) {
        if (isDetailed)
            validarCampoExistenteById(atributos.apellidoFiltro);
    }

    private void validarCampoExistenteFiltroTelefono(boolean isDetailed) {
        if (isDetailed)
            validarCampoExistenteById(atributos.telefonoFiltro);
    }

    private void validarCampoExistenteFiltroNif(boolean isDetailed) {
        if (isDetailed)
            validarCampoExistenteById(atributos.nifFiltro);
    }

    public void validarCampoExistenteNif(boolean isDetailed) {
        if (isDetailed)
            validarCampoExistenteByClass(atributos.labelNifClass);
    }

    public void validarCampoExistenteNombre(boolean isDetailed) {
        if (isDetailed)
            validarCampoExistenteByClass(atributos.labelNombreClass);
    }

    public void validarCampoExistenteApellidos(boolean isDetailed) {
        if (isDetailed)
            validarCampoExistenteByClass(atributos.labelApellidosClass);
    }

    public void validarCampoExistenteDireccion(boolean isDetailed) {
        if (isDetailed)
            validarCampoExistenteByClass(atributos.labelDireccionClass);
    }

    public void validarCampoExistenteLocalidad(boolean isDetailed) {
        if (isDetailed)
            validarCampoExistenteByClass(atributos.labelLocalidadClass);
    }

    public void validarCampoExistenteTelefonoPrincipal(boolean isDetailed) {
        if (isDetailed)
            validarCampoExistenteByClass(atributos.labelTel1Class);
    }

    public void validarCampoExistenteTelefonoSegundario(boolean isDetailed) {
        if (isDetailed)
            validarCampoExistenteByClass(atributos.labelTel2Class);
    }
    
    public void validarTextoIntroducido(String expected, String clas, boolean isDetailed){
        if(isDetailed){
            validarTextoByClass(clas, expected, null);
        }
    }

    private ClienteAtributos atributos;

    public ClienteValidacionesSteps(){
        atributos = new ClienteAtributos();
    }

    @Override
    protected ClienteAtributos getAtributos() {
        return atributos;
    }

    public void validarclienteInexistenteEnListado(String nombre, String apellidos, String telefono, boolean isDetailed) {
        if (isDetailed) {

            WebElement tr = getDriverUtils().devolverWebElement(atributos.selectorTabla, "td:nth-child(1)", "td:nth-child(2)", "td_nth-child(3)", nombre, apellidos, telefono);
            if (tr == null)
                error("No se ha encontrado el Cliente con Nombre y Apellidos '" + nombre + " " + apellidos + "' y Telefono '" + telefono + "'");
        }
    }
}
