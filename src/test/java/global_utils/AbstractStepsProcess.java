package global_utils;

/**
 * Created by lleir on 25/6/17.
 */
public abstract class AbstractStepsProcess<Steps, Validations> {

    protected abstract Steps getSteps();

    protected abstract Validations getValidations();

}
