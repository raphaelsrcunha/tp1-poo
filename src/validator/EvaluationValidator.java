package validator;
import exception.ValidationException;

public class EvaluationValidator {

	public static void validateCoefficient(double coefficient) throws ValidationException{
		if(coefficient < 0 || coefficient > 1.0) {
			throw new ValidationException("Le coefficient doit être entre 0 et 1");
		}
	}
	
}
