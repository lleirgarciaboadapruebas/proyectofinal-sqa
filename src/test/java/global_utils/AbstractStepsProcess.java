package global_utils;

/**
 * Created by lleir on 25/6/17.
 */
public abstract class AbstractStepsProcess<Steps, Validations> {

    public abstract Steps getSteps();
    public abstract Validations getValidations();

}
