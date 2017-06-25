package application.clientes.main.steps;

import application.clientes.main.ClienteAtributos;
import application.clientes.main.ClienteValidacionesSteps;
import application.main.AbstractSteps;
import selenium_tools.ADriverUtils;
import selenium_tools.DriverUtils;

/**
 * Created by lleir on 16/6/17.
 */
public class ClienteSteps extends AbstractSteps<ClienteAtributos, ClienteValidacionesSteps> {

    /** Steps client module. */

    public void insertarNif(String nif) {
        driver.introDatosInputByClass(getAtributos().nifClass, nif);
        validations.validarTextoIntroducido(nif, getAtributos().nifClass, false); //isDetailed);
    }

    public void insertarNombre(String nombre) {
        driver.introDatosInputByClass(getAtributos().nombreClass, nombre);
        validations.validarTextoIntroducido(nombre, getAtributos().nifClass, false);
    }

    public void insertarApellidos(String apellidos) {
        driver.introDatosInputByClass(getAtributos().apellidosClass, apellidos);
//        validations.validarTextoIntroducido(nif, getAtributos().nifClass, false);
    }

    public void insertarDireccion(String direccion) {
        driver.introDatosInputByClass(getAtributos().direccionClass, direccion);
//        validations.validarTextoById(getAtributos().direccionClass, direccion);
    }

    public void insertarLocalidad(String localidad) {
        driver.introDatosInputByClass(getAtributos().localidadClass, localidad);
//        validations.validarTextoById(getAtributos().localidadClass, localidad);

    }

    public void insertarTel1(String tel1) {
        driver.introDatosInputByClass(getAtributos().tel1class, tel1);
//        validations.validarTextoById(getAtributos().tel1class, tel1);
    }

    public void insertarTel2(String tel2) {
        driver.introDatosInputByClass(getAtributos().tel2class, tel2);
//        validations.validarTextoById(getAtributos().tel2class, tel2);
    }

    public ClienteSteps(){
        validations = new ClienteValidacionesSteps();
        atributos = new ClienteAtributos();
        driver = new ADriverUtils();
    }
    
    private ClienteValidacionesSteps validations;
    private ClienteAtributos atributos;
    private ADriverUtils driver;

    @Override
    public ClienteValidacionesSteps getValidations() {
        return validations;
    }

    @Override
    protected ADriverUtils getDriverUtils() {
        return driver;
    }

    @Override
    public ClienteAtributos getAtributos() {
        return atributos;
    }

}
