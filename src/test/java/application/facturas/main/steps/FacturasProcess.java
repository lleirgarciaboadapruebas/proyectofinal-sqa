package application.facturas.main.steps;

import application.facturas.main.validaciones.FacturasValidacionesSteps;
import global_utils.AbstractStepsProcess;

/**
 * Created by lleir on 16/6/17.
 */
public class FacturasProcess extends AbstractStepsProcess<FacturasSteps, FacturasValidacionesSteps> {

    public void irListadoFacturas() {
        steps.clickEnMenuFacturas();
    }

    /**
     * Crea una factura sin conceptos.
     */
    public void crearFacturaSinConcepto(String cliente, String codigo, String fecha, String estado, String iva,
                                        String precio_hora, String coche) {
        irListadoFacturas();
        escribirDatosGeneralesFactura(cliente, codigo, fecha, estado, iva, precio_hora, coche);
        steps.guardarDatos();
    }

    /**
     * Crea 1 factura con todos sus datos y ademas con 1 concepto.
     */
    public void crearFacturaCon1Concepto(String cliente, String codigo, String fecha, String estado, String iva,
                                         String precio_hora, String coche, String tipoConcepto, String descripcionConcepto,
                                         String cantidadHorasConcepto, String precioConcepto) {
        irListadoFacturas();
        escribirDatosGeneralesFactura(cliente, codigo, fecha, estado, iva, precio_hora, coche);
        escribirDatosGeneralesConcepto(tipoConcepto, descripcionConcepto, cantidadHorasConcepto, precioConcepto);
        steps.clickEnButtonAnadirConcepto();
    }

    public void editarDatosPrincipalesDeFactura(String codigo, String nuevoCodigo, String cliente, String fecha, String estado, String iva,
                                                String precioHora, String coche) {

        // buscar, entrar y rellenar datos
    }

    public void anadirConceptosEnEdicionFactura(String factura, String tipoConcepto, String descripcionConcepto, String cantidad_horas, String precio) {

    }

    /**
     * Escribe los datos principales de una Factura, obiando los conceptos.
     */
    public void escribirDatosGeneralesFactura(String cliente, String codigo, String fecha, String estado, String iva,
                                              String precio_hora, String coche) {
        steps.crear();
        steps.seleccionarCliente(cliente);
        steps.escribirCodigo(codigo);
        steps.escribirFecha(fecha);
        steps.seleccionarEstado(estado);
        steps.escribirIva(iva);
        steps.escribirPrecioHoraGeneral(precio_hora);
        steps.seleccionarCoche(coche);
    }

    /**
     * Escribe los datos que tiene un concepto.
     */
    public void escribirDatosGeneralesConcepto(String tipoConcepto, String descripcionConcepto,
                                               String cantidadHorasConcepto, String precioConcepto) {
        steps.seleccionarTipoConcepto(tipoConcepto);
        steps.escribirDescripcionConcepto(descripcionConcepto);
        steps.escribirCantidadOHorasConcepto(cantidadHorasConcepto);
        steps.escribirPrecioConcepto(precioConcepto);
    }

    public FacturasProcess() {
        steps = new FacturasSteps();
        validaciones = new FacturasValidacionesSteps();
    }

    private FacturasSteps steps;
    private FacturasValidacionesSteps validaciones;

    @Override
    protected FacturasSteps getSteps() {
        return null;
    }

    @Override
    protected FacturasValidacionesSteps getValidations() {
        return null;
    }
}
