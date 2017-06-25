package application.clientes.main;

import application.coches.main.atributos.CochesAtributos;
import global_utils.AbstractValidations;
import global_utils.ValidacionesUtils;

/**
 * Created by lleir on 15/6/17.
 */
public class ClienteValidacionesSteps extends AbstractValidations<ClienteAtributos>{


    public void validarPantallaCliente(boolean isDetailed){

    }

    public void validarTextoIntroducido(String expected, String clas, boolean isDetailed){
        if(isDetailed){

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
