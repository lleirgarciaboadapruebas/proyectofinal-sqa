package selenium_tools;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TablaUtils {

	private ADriverUtils driverUtils;
	
	public TablaUtils(ADriverUtils driver){
		this.driverUtils = driver;
	}

    public List<WebElement> getTrsTablaById(String parentId){
		return getTrsTabla(driverUtils.getByUtils().byTagnameAndIdContains("tbody", parentId));
	}
	
	/** Devuelve los trs de una tabla segun el patron de esta. 
	 *  
	 * @param parent Identificador del 'tbody'.
	 * @return Listado de trs.
	 */
	public List<WebElement> getTrsTabla(By parent){
		return getListadoTableBy(parent, driverUtils.getByUtils().byCss("tr"));
	}
	
	public List<WebElement> getListadoTableBy(By parent, By son){
		
		// recojo la tabla
		WebElement tabla = driverUtils.findElement(parent);
		
		// devuelvo trs de tabla 
		return driverUtils.findElements(tabla, son);
	}
	
	public void mostrarMasElementos(String idUlElementos) {
		driverUtils.clickByContainsId(idUlElementos);
	}
	
}
