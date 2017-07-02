package application.clientes.main.steps;

import application.clientes.main.validaciones.ClienteValidacionesSteps;
import global_utils.AbstractStepsProcess;

/**
 * Created by lleir on 16/6/17.
 */
public class ClienteProcess extends AbstractStepsProcess<ClienteSteps, ClienteValidacionesSteps> {

    public void crearCliente(String nif, String nombre, String apellidos, String direccion, String localidad, String telefono1, String telefono2) {
        steps.clickEnClientes();
        steps.crear();
        steps.insertarNif(nif);
        steps.insertarNombre(nombre);
        steps.insertarApellidos(apellidos);
        steps.insertarDireccion(direccion);
        steps.insertarLocalidad(localidad);
        steps.insertarTel1(telefono1);
        steps.insertarTel2(telefono2);
        steps.guardarDatos();
    }

    public void editarCliente(){

    }

    private ClienteSteps steps;
    private ClienteValidacionesSteps validaciones;

    public ClienteProcess() {
        steps = new ClienteSteps();
        validaciones = new ClienteValidacionesSteps();
    }

    @Override
    protected ClienteSteps getSteps() {
        return steps;
    }

    @Override
    protected ClienteValidacionesSteps getValidations() {
        return validaciones;
    }


}
