package br.com.brasilDoador.validacoes;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="validarEmail")
public class ValidaEmail implements Validator {
	
	public void validate(FacesContext context, UIComponent component,
	Object value) {
	String valor = value.toString();
		if (!valor.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
		throw new ValidatorException(new FacesMessage("Digite um endereço de e-mail válido"));
		}
	}
}
