package selenium_tools;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class AlmacenSteps {

    public static Map<String, String> map = new LinkedHashMap<String, String>();
    public static Integer contadorSteps = 0;


    /**
     * @param tipo Define si es un step o una validacion de step.
     * @param step Se pasar� la clase (que hace referencia al step).
     */
    public static void putStep(String tipo, String step) {
        map.put(contadorSteps++ + "_____" + tipo, step);
    }

    public static void mostrarSteps() {
//		map.forEach((k,v) -> System.out.println(k + ": " + v));
    }

    public static void mostrarProcesos() {
        // recorrer y buscar steps process
    }

    public static void mostrarValidaciones() {
        // recorrer y buscar validaciones
    }

    /**
     * Recoje el ultimo step guardado.
     */
    public static String getLastStep() {
        List<String> steps = new ArrayList<String>();

        for (Map.Entry<String, String> mapp : map.entrySet())
            if (StringUtils.contains(mapp.getKey(), "step"))
                steps.add(mapp.getValue());

        return steps.get(steps.size() - 1);
    }

    public static String getLastStepValidation() {
        List<String> validations = new ArrayList<String>();

        for (Map.Entry<String, String> mapp : map.entrySet())
            if (StringUtils.contains(mapp.getKey(), "validacion"))
                validations.add(mapp.getValue());

        return validations.get(validations.size() - 1);
    }

    public static void guardarStepsFile(String testName) {

    }


}
