package application.main;

import global_utils.AbstractBaseUtils;

/**
 * Created by lleir on 21/6/17.
 */
public abstract class AbstractSteps<Atributos, Validations> extends AbstractBaseUtils<Atributos>{

    public abstract Validations getValidations();

}
