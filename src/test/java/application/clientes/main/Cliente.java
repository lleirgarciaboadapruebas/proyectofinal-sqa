package application.clientes.main;

import application.clientes.main.steps.ClienteProcess;
import application.clientes.main.steps.ClienteSteps;
import application.clientes.main.validaciones.ClienteValidacionesSteps;

public class Cliente {


    public static ClienteProcess process = new ClienteProcess();
    public static ClienteSteps steps = new ClienteSteps();
    public static ClienteValidacionesSteps validaciones = new ClienteValidacionesSteps();

}
