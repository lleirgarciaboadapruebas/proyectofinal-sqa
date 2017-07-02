package application.clientes.main.validaciones;

import application.clientes.main.atributos.ClienteAtributos;
import global_utils.AbstractValidations;

/**
 * Created by lleir on 15/6/17.
 */
public class ClienteValidacionesSteps extends AbstractValidations<ClienteAtributos>{

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
}
