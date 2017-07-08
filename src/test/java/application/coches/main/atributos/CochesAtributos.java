package application.coches.main.atributos;

import application.main.AtributosGenerales;

/**
 * Created by lleir on 16/6/17.
 */
public class CochesAtributos extends AtributosGenerales {

    // metemos atributos de pantalla coche
    public final String menu = "coche";
    public final String labelTitleText = "Listado de Vehiculos";

    public final String labelMatriculaClass      = "label-matricula";
    public final String labelValueMatriculaCss = "." + labelMatriculaClass + " + input";
    public final String labelMarcaClass          = "label-marca";
    public final String labelValueMarcaCss = "." + labelMarcaClass + " + input";
    public final String labelModeloClass         = "label-modelo";
    public final String labelValueModeloCss = "." + labelModeloClass + " + input";
    public final String labelKmActualesClass     = "label-km";
    public final String labelValueKmActualesCss = "." + labelKmActualesClass + " + input";
    public final String labelNumBastidorClass    = "label-bastidor";
    public final String labelValueNumBastidorCss = "." + labelNumBastidorClass + " + input";
    public final String labelClienteClass = "label-cliente";
    public final String selectClienteId = "combobox1";
    
    // tabla listado
    public final String tablaClass = "table-listado";
    public final String selectorTabla = ".table-listado tr:not(:first-child)";
    public final String selectorEliminar = ".td-acciones > a:nth-child(1)";

    public final String inputModeloFiltroName    = "entity.modelo";
    public final String inputMarcaFiltroName     = "entity.marca";
    public final String inputMatriculaFiltroName = "entity.matricula";
    public final String inputNombreFiltroName    = "entity.nombre o Apellido";





}
