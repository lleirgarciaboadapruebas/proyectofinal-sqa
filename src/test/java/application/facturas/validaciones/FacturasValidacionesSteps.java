package application.facturas.validaciones;

import application.facturas.atributos.FacturasAtributos;
import global_utils.AbstractValidations;

/**
 * Created by lleir on 16/6/17.
 */
public class FacturasValidacionesSteps extends AbstractValidations<FacturasAtributos> {

    public void validarPantallaListado(boolean isDetailed) {

    }

    public void validarExistenciaButtonCrearFactura(boolean isDetailed) {
        if (isDetailed)
            esVisible(getDriverUtils().getByUtils().byId(atributos.selectorBtnCrear));
    }

    public void validarExistenciaButtonVolverAtras(boolean isDetailed) {

    }

    public void validarPantallaCreacion(boolean isDetailed) {

    }

    private void validarCampoExistenteCodigo(boolean isDetailed) {

    }

    private void validarCampoExistenteFecha(boolean isDetailed) {

    }

    private void validarCampoExistentePrecioHoraFIjo(boolean isDetailed) {

    }

    // mirar:: creo que habia una seleccion de ccliente y otra de coche de cliente (( verificar ))
    private void validarCampoExistenteCliente() {

    }


    public FacturasValidacionesSteps() {
        atributos = new FacturasAtributos();
    }

    private FacturasAtributos atributos;

    @Override
    protected FacturasAtributos getAtributos() {
        return atributos;
    }

    public void validarExistenciaButtonGuardarDatos(boolean detailed) {
    }

    public void validarExistenciaButtonFiltrar(boolean detailed) {

    }
}