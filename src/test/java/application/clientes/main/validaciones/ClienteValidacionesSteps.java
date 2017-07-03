package application.clientes.main.validaciones;

import application.clientes.main.atributos.ClienteAtributos;
import global_utils.AbstractValidations;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by lleir on 15/6/17.
 */
public class ClienteValidacionesSteps extends AbstractValidations<ClienteAtributos>{


    public void validarClienteEnListado(String nombre, String apellidos, String telefono) {
        List<WebElement> trs = getDriverUtils().findElementsByCss(atributos.selectorTabla);

        for (WebElement tr : trs) {
            String td_nombre = getDriverUtils().getTextoByWebElement(tr, getDriverUtils().getByUtils().byCss("td:nth-child(1)"));
            String td_apellidos = getDriverUtils().getTextoByWebElement(tr, getDriverUtils().getByUtils().byCss("td:nth-child(2)"));
            String td_telefono = getDriverUtils().getTextoByWebElement(tr, getDriverUtils().getByUtils().byCss("td:nth-child(4)"));

            boolean nombreok = StringUtils.equals(td_nombre, nombre);
            boolean apellidosok = StringUtils.equals(td_apellidos, apellidos);
            boolean telefonook = StringUtils.equals(td_telefono, telefono);

            if (nombreok && apellidosok && telefonook)
                getDriverUtils().clickWebELement(tr, getDriverUtils().getByUtils().byCss(atributos.selectorEliminar));

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
            List<WebElement> trs = getDriverUtils().findElementsByCss(atributos.selectorTabla);

            for (WebElement tr : trs) {
                String td_nombre = getDriverUtils().getTextoByWebElement(tr, getDriverUtils().getByUtils().byCss("td:nth-child(1)"));
                String td_apellidos = getDriverUtils().getTextoByWebElement(tr, getDriverUtils().getByUtils().byCss("td:nth-child(2)"));
                String td_telefono = getDriverUtils().getTextoByWebElement(tr, getDriverUtils().getByUtils().byCss("td:nth-child(4)"));

                boolean nombreok = StringUtils.equals(td_nombre, nombre);
                boolean apellidosok = StringUtils.equals(td_apellidos, apellidos);
                boolean telefonook = StringUtils.equals(td_telefono, telefono);

                if (nombreok && apellidosok && telefonook)
                    getDriverUtils().clickWebELement(tr, getDriverUtils().getByUtils().byCss(atributos.selectorEliminar));

            }
        }
    }
}
