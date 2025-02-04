package validator;
import exception.ValidationException;

public class NoteValidator {

	public static void validateValeur(double valeur) throws ValidationException {
		if(valeur < 0 || valeur > 100) {
			throw new ValidationException("La note doit être entre zero et cent!");
		}
	}
	
}
