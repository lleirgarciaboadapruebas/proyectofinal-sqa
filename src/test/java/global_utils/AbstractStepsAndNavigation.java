package global_utils;

import application.menu_top.steps.MenuTopSteps;
import application.menu_top.validations.MenuTopValidationSteps;

/**
 * Created by lleir on 25/6/17.
 */
public abstract class AbstractStepsAndNavigation<Atributes, Validations> extends AbstractSteps<Atributes, Validations>{

    /** Todas y cada una de las classesStep que se utilicen para las pantallas que necesitan acciones de menu extendidas de esta clase. */

    public abstract MenuTopSteps getMenuSteps();
}
