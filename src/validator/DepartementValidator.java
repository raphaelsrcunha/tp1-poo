package validator;

import exception.ValidationException;

public class DepartementValidator {
	
	public static void validateNom(String nom) throws ValidationException {
		
		if(nom == null) {
			throw new ValidationException("Le nom du departement ne peut pas etre vide!");
		}
		
	}

}
