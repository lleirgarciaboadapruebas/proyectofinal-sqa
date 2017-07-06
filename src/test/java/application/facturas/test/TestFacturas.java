package application.facturas.test;

import application.facturas.main.Factura;
import org.junit.Before;
import org.junit.Test;
import selenium_tools.ABaseTestCase;

/**
 * Created by lleir on 6/7/17.
 */
public class TestFacturas extends ABaseTestCase {

    @Test
    public void validar_navegacion_a_listado() throws Exception {
        Factura.process.irListadoFacturas();
        Factura.validaciones.validarPantallaListado(true);
    }

    @Test
    public void validar_creacion_factura_en_listado() throws Exception {
        Factura.process.irListadoFacturas();
        Factura.process.crearFacturaSinConcepto("cliente real", "", "", "", "", "", "coche real de cliente");
        Factura.validaciones.validarFacturaExistenteEnListado("codigo", true);
    }

    @Test
    public void validar_edicion_factura_en_listado() throws Exception {

    }

    @Test
    public void validar_anadir_concepto_en_creacion_factura() throws Exception {

    }


    @Before
    public void ini() {
        setBaseUrl("192.168.1.42/tallerlavi3/");
        setTestNameClass(this.getClass().getName());
        setDetailValidation(false);
    }

    @Override
    public void setBaseUrl(String baseUrll) {
        baseUrl = baseUrll;
    }


    @Override
    public String getApp() {
        return app;
    }

    @Override
    public void setTestNameClass(String testNameClass) {
        testClassName = testNameClass;
    }


    @Override
    public void setTestCaseName(String testCaseNamee) {
        testCaseName = testCaseNamee;
    }
}
